package lectures.lecture3stackAndQueue;

import java.util.Map;
import java.util.Set;

public class Brackets {
    private static final String TEXT_EXAMPLE = """
            public E peek() {
                return data[size-1];
            };
            """;

    private static final Map<Character, Character> BRACKETS_MAP = Map.of(
            '(' , ')',
            '{' , '}',
            '[' , ']'
    );

    public static void main(String[] args) {
        new Brackets().check(TEXT_EXAMPLE);
    }

    public void check (String text){
        Stack<Character> stack = new StackImpl<>(text.length());

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (BRACKETS_MAP.containsKey(currentChar)){
                stack.push(currentChar);
            }else if (BRACKETS_MAP.containsValue(currentChar)){
                if (stack.isEmpty()){
                    System.err.println("Error: " + currentChar + " at " + i);
                    continue;
                }

                Character lastOpenedBracket = stack.pop();
                if (!BRACKETS_MAP.get(lastOpenedBracket).equals(currentChar)){
                    System.err.println("Error: " + currentChar + " at " + i);
                }
            }
        }
        if (!stack.isEmpty()){
            System.err.println("Error: missing right delimiter");
        }
    }
}

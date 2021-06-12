package lectures.lecture5Recursion;

import java.util.LinkedHashSet;
import java.util.Set;

public class Anagram {

    private char[] chars;
    private Set<String> result = new LinkedHashSet<>();

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        Set<String> anagrams = anagram.findAll("Cat");
        System.out.println(anagrams);
    }

    private Set<String> findAll(String word) {
        result.clear();
        this.chars = word.toCharArray();
        find(chars.length);
        return result;
    }

    private void find(int length) {   //рекурсивный метод
        // определяем базовый случай
        if (length == 1){
            return;
        }
        for (int i = 0; i < length; i++){  // совершаем столько перестановок, сколько букв в слове
            find(length -1);        // на каждой итерации вызываем метод find(), куда передаем значение (length - 1)
            result.add(String.valueOf(chars)); // каждую пересановку фиксируем в сете
            rotate(length);                // прокручиваем набор букв, сдвигая все на одну букву влево
        }
    }

    private void rotate(int length) {
        int pos = chars.length - length; // находим индекс первой буквы нашего подслова, которое будем прокручивать
        char temp = chars[pos];

        for (int i = pos+1; i < chars.length; i++) {
            chars[i-1] = chars[i];  // правые значения присваиваем левым
        }
        chars[chars.length-1] = temp;
    }
}

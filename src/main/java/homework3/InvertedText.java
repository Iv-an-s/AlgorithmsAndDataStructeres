package homework3;

import lectures.lecture3stackAndQueue.stack.Stack;

public class InvertedText {

    private char [] data;
    private int size;

    public InvertedText(String text) {
        data = text.toCharArray();
        size = data.length;
    }

    public void push(String value) {
        char[]addText = value.toCharArray();
        for (int i = 0; i < addText.length; i++) {
            if (data.length == size) {
                grow();
            }
            data[size++] = addText[i];
        }
    }

    private void grow() {
        if (data.length == 0){
            data = new char[1];
        } else{
            char [] newData = new char[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    public char pop() {
        if(size == 0){
            return 0;
        }
        return data[--size];
    }

    public char peek() {
        return data[size-1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void display() {
        int volume = size();
        for (int i = 0; i < volume; i++) {
            System.out.print(pop());
        }
        System.out.println("");
    }
}

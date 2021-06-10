package homework6;

import lectures.lecture6Trees.Tree;
import lectures.lecture6Trees.TreeImpl;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int maxDepth = 6;
        int treeCount = 20;

        int count = 0;

        boolean isBalanced = false;

        for (int i = 0; i < treeCount; i++) {
            Tree<Integer> tree = new TreeImpl<>(maxDepth);

            for (int j = 0; j < 63; j++) { // максимальное количество элементов в дереве = 2^maxDepth -1
                tree.add(random.nextInt(201)-100);
            }

            if (tree.isBalanced()) {
                count++;
                if(!isBalanced){
                    isBalanced = true;
                    tree.display();
                }
            }
        }
        System.out.println("Количество сбалансированных деревьев = " + (count/(double)treeCount)*100 + "%");
    }
}

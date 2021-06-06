package homework5.satchel;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Item[] items = {
                new Item("notebook", 2, 1000),
                new Item("hatchet", 2, 100),
                new Item("pot", 3, 50),
                new Item("pan", 4, 150),
                new Item("book", 1, 200),
                new Item("medicalKit", 5, 300),
                new Item("smthElse", 3, 500),
                new Item("anotherThing", 4, 700),
                new Item("heavyItem", 10, 500),
                new Item("expenciveItem", 1, 2000)
        };

        Satchel satchel = new Satchel(15);
        satchel.calcBestSet(Arrays.asList(items));

        for (Item item : satchel.getBestSet()){
            System.out.println(item.getName() + ", price =  " + item.getPrice());
        }
        System.out.println("Total weight is " + satchel.weightSum(satchel.getBestSet()));
        System.out.println("Total best price is " + satchel.getBestPrice());
    }
}

package homework5.satchel;

import java.util.ArrayList;
import java.util.List;

public class Satchel {
    private int capacity;
    private List<Item> bestItems = new ArrayList<>();
    private int bestPrice;

    public Satchel(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    protected int weightSum(List<Item> items) {
        int weightSum=0;
        for(Item item : items){
            weightSum += item.getWeight();
        }
        return weightSum;
    }

    private int priceSum(List<Item> items) {
        int priceSum=0;
        for(Item item : items){
            priceSum += item.getPrice();
        }
        return priceSum;
    }

    private void bestSet(List<Item> items){
        int priceSum = priceSum(items);
        int weightSum = weightSum(items);
        if(weightSum <=capacity && priceSum > bestPrice){
            bestItems = items;
            bestPrice = priceSum;
        }
    }

    public List<Item> getBestSet(){
        return bestItems;
    }

    public void calcBestSet(List<Item> items){
        if (items.isEmpty()){
            return;
        }
        bestSet(items);

        for (int i = 0; i < items.size(); i++) {
            List<Item>copiedItems = new ArrayList<>(items);
            copiedItems.remove(i);
            calcBestSet(copiedItems);
        }
    }

    public int getBestPrice(){
        return bestPrice;
    }
}

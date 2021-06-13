package homework8;

import lectures.lecture8HashTables.HashTable;

public class HashTableLinkedImpl<K, V> implements HashTable <K, V> {

    private final Item<K, V> emptyItem = new Item<>(null, null); //заглушка, которую используем при удалении

    static class Item<K, V> implements HashTable.Entry<K, V> {
        private final K key;
        private V value;
        private Item<K, V> nextItem;

        public Item<K, V> getNextItem() {
            return nextItem;
        }

        public void setNextItem(Item<K, V> nextItem) {
            this.nextItem = nextItem;
        }

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
            this.nextItem = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final Item<K, V>[] data;
    private int size;

    public HashTableLinkedImpl(int initialCapacity) {
        this.data = new Item[initialCapacity * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        if(data[index]==null || data[index]==emptyItem){
            data[index] = new Item<>(key, value);
            size++;
            return true;
        }else {
            Item<K, V> presentItem = data[index];
            while (presentItem.nextItem!=null){
                if(presentItem.getKey().equals(key)){
                    presentItem.setValue(value);
                    return true;
                }
                presentItem = presentItem.nextItem;
            }
            presentItem.setNextItem(new Item<>(key, value));
            return true;
        }
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (data[index].getKey().equals(key)) {
            return index != -1 ? data[index].getValue() : null;
        }
        Item<K, V> currentElement = data[index];
        while (currentElement.getNextItem()!=null){
            currentElement = currentElement.nextItem;
            if(currentElement.getKey().equals(key)){
               return currentElement.getValue();
            }
        }
        return null;
    }

    private int indexOf(K key){
        return hashFunc(key);
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1){
            return null;
        }

        Item<K, V> item = data[index];
        if(item.getKey().equals(key)){
            if(item.getNextItem()==null){
                data[index] = emptyItem;
                size--;
                return item.getValue();
            }else{
                data[index] = item.getNextItem();
                return item.getValue();
            }
        }else{
            Item<K, V> currentItem;
            while (item.getNextItem()!=null){
                currentItem = item.nextItem;
                if(currentItem.getKey().equals(key)){
                    if(currentItem.getNextItem() == null){
                        item.setNextItem(null);
                        return currentItem.getValue();
                    }else{
                        item.setNextItem(currentItem.getNextItem());
                        return currentItem.getValue();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void display() {
        System.out.println("----------------------");
        for (int i = 0; i < data.length; i++) {
            Item<K, V> item = data[i];
            if(data[i] == null || data[i].equals(emptyItem)){
                System.out.printf("%d = [%s]%n", i, item);
            } else if(item.getNextItem()!=null) {
                System.out.printf("%d = [%s] -> ", i, item);
                while (item.getNextItem() != null) {
                    System.out.printf("%d = [%s] -> ", i, item.getNextItem());
                    item = item.getNextItem();
                }
                System.out.printf("%d = [%s]%n", i, item.getNextItem());
            }else {
                System.out.printf("%d = [%s]%n", i, item);
            }
        }
        System.out.println("----------------------");

    }
}


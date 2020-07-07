package DataStructures.map.linkedHashMap;

import DataStructures.map.IMap;

public class MyLinkedHashMap<K, V> implements IMap<K, V> {
    private LinkedHashMapEntry[] table;
    // insertion order doubly linked list
    private LinkedHashMapEntry<K, V> inOrderHead;
    private LinkedHashMapEntry<K, V> inOrderTail;
    private static final int MAX_SIZE = 100;

    public MyLinkedHashMap() {
        table = new LinkedHashMapEntry[MAX_SIZE];
    }

    private int simpleHashFunction(K key) {
        return key.toString().length() % table.length;
    }

    @Override
    public boolean containsKey(K key) {
        int index = simpleHashFunction(key);
        LinkedHashMapEntry<K, V> head = table[index];

        while (head != null) {
            if (head.getKey().equals(key)) {
                return true;
            }
            head = head.getNext();
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = simpleHashFunction(key);
        LinkedHashMapEntry<K, V> head = table[index];

        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.getNext();
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int index = simpleHashFunction(key);
        LinkedHashMapEntry<K, V> head = table[index];

        LinkedHashMapEntry<K, V> newEntry = new LinkedHashMapEntry<>(key, value);
        if (head == null) {
            table[index] = newEntry;
        } else {
            LinkedHashMapEntry<K, V> current = head;

            while (head != null) {
                if (head.getKey().equals(key)) {
                    head.setValue(value);
                    return;
                } else {
                    current = head;
                    head = head.getNext();
                }
            }
            current.setNext(newEntry);
        }

        if (inOrderHead == null) {
            inOrderHead = inOrderTail = newEntry;
        } else if (inOrderHead == inOrderTail) {
            inOrderHead.setInOrderNext(newEntry);
            newEntry.setInOrderPrev(inOrderHead);
            inOrderTail = newEntry;
        } else {
            inOrderTail.setInOrderNext(newEntry);
            newEntry.setInOrderPrev(inOrderTail);
            inOrderTail = newEntry;
        }
    }

    @Override
    public void remove(K key) {
        int index = simpleHashFunction(key);
        LinkedHashMapEntry<K, V> head = table[index];

        if (head == null) {
            return;
        }

        if (head.getKey().equals(key)) {
            updateInsertionOrderListBeforeRemove(head);
            table[index] = head.getNext();
        } else {
            while (head.getNext() != null) {
                if (head.getNext().getKey().equals(key)) {
                    updateInsertionOrderListBeforeRemove(head.getNext());
                    head.setNext(head.getNext().getNext());
                    break;
                }
                head = head.getNext();
            }
        }
    }

    private void updateInsertionOrderListBeforeRemove(LinkedHashMapEntry<K, V> entryToRemove) {
        if (inOrderTail == inOrderHead) {
            inOrderHead = inOrderTail = null;
        } else if (inOrderHead == entryToRemove) {
            inOrderHead = inOrderHead.getInOrderNext();
            inOrderHead.setInOrderPrev(null);
        } else if (inOrderTail == entryToRemove) {
            inOrderTail = inOrderTail.getInOrderPrev();
            inOrderTail.setInOrderNext(null);
        } else {
            LinkedHashMapEntry<K, V> prev = entryToRemove.getInOrderPrev();
            LinkedHashMapEntry<K, V> next = entryToRemove.getInOrderNext();

            prev.setInOrderNext(next);
            next.setInOrderPrev(prev);
        }
    }

    public String printLinkedHashMap() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (LinkedHashMapEntry entry : table) {
            if (entry != null) {
                stringBuilder.append("{");
                while (entry != null) {
                    K key = (K) entry.getKey();
                    V value = (V) entry.getValue();
                    stringBuilder.append("(").append(key).append(",").append(value).append(")");
                    entry = entry.getNext();
                    stringBuilder.append(",");
                }
                stringBuilder.append("}");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    public String printEntriesInInsertionOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        LinkedHashMapEntry<K, V> current = inOrderHead;

        while (current != null) {
            K key = (K) current.getKey();
            V value = (V) current.getValue();
            stringBuilder.append("(").append(key).append(",").append(value).append(")");
            current = current.getInOrderNext();
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyLinkedHashMap<String, Integer> hashMap = new MyLinkedHashMap<>();
        hashMap.put("c", 1);
        hashMap.put("cat", 1);
        hashMap.put("bobo", 1);
        hashMap.put("dog", 1);

        System.out.println("Hashmap: ");
        System.out.println(hashMap.printLinkedHashMap());
        System.out.println("Entries in insertion order: ");
        System.out.println(hashMap.printEntriesInInsertionOrder());

        hashMap.remove("dog");
        System.out.println("Hashmap: ");
        System.out.println(hashMap.printLinkedHashMap());
        System.out.println("Entries in insertion order: ");
        System.out.println(hashMap.printEntriesInInsertionOrder());

        hashMap.put("log", 1);
        System.out.println("Hashmap: ");
        System.out.println(hashMap.printLinkedHashMap());
        System.out.println("Entries in insertion order: ");
        System.out.println(hashMap.printEntriesInInsertionOrder());

        System.out.println("done");
    }
}

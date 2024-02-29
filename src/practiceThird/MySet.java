package practiceThird;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet {
    private final Set<Object> synchronizedSet = new HashSet<>();

    public synchronized boolean add(Object element) {
        return synchronizedSet.add(element);
    }

    public synchronized boolean remove(Object element) {
        return synchronizedSet.remove(element);
    }

    public synchronized boolean contains(Object element) {
        return synchronizedSet.contains(element);
    }

    public synchronized int size() {
        return synchronizedSet.size();
    }

    public synchronized Iterator<Object> iterator() {
        return new HashSet<>(synchronizedSet).iterator();
    }

    public static void main(String[] args) {
        MySet synchronizedSetExample = new MySet();

        synchronizedSetExample.add("Element1");
        synchronizedSetExample.add("Element2");
        synchronizedSetExample.add("Element3");

        System.out.println("Set size: " + synchronizedSetExample.size());

        synchronizedSetExample.remove("Element2");

        System.out.println("Set size after removal: " + synchronizedSetExample.size());

        System.out.println("Set contains Element1: " + synchronizedSetExample.contains("Element1"));
        System.out.println("Set contains Element2: " + synchronizedSetExample.contains("Element2"));
    }
}


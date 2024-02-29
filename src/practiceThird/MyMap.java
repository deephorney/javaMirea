package practiceThird;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

interface ThreadSafeMap<K, V> {
    void put(K key, V value);
    V get(K key);
}

class SemaphoreThreadSafeMap<K, V> implements ThreadSafeMap<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public void put(K key, V value) {
        try {
            semaphore.acquire();
            map.put(key, value);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public V get(K key) {
        try {
            semaphore.acquire();
            return map.get(key);
        } catch (InterruptedException e) {
            System.out.println(e);
            return null;
        } finally {
            semaphore.release();
        }
    }
}

public class MyMap {
    public static void main(String[] args) {
        ThreadSafeMap<String, Integer> threadSafeMap = new SemaphoreThreadSafeMap<>();
        threadSafeMap.put("key1", 1);
        threadSafeMap.put("key2", 2);
        System.out.println("key1: " + threadSafeMap.get("key1"));
        System.out.println("key2: " + threadSafeMap.get("key2"));
    }
}

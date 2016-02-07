/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

public class LRUCache {
    DListNode sentinel;
    Map<Integer, DListNode> map;
    int count;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        sentinel = new DListNode(0, 0);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        count = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        reorder(key);
        return map.get(key).val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            reorder(key);
        } else {
            if (count == capacity) {
                map.remove(sentinel.prev.key);
                sentinel.prev = sentinel.prev.prev;
                sentinel.prev.next = sentinel;
                count--;
            }
            DListNode n = new DListNode(key, value);
            map.put(key, n);
            n.next = sentinel.next;
            n.prev = sentinel;
            sentinel.next.prev = n;
            sentinel.next = n;
            count++;
        }
    }

    private void reorder(int key) {
        DListNode n = map.get(key);
        if (sentinel.next == n)
            return;
        n.prev.next = n.next;
        n.next.prev = n.prev;

        n.prev = sentinel;
        n.next = sentinel.next;
        sentinel.next.prev = n;
        sentinel.next = n;
    }
}

class DListNode {
    public DListNode next;
    public DListNode prev;
    int key;
    int val;
    public DListNode(int k, int v) {
        key = k;
        val = v;
    }
}

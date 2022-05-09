package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
public class BST<K extends Comparable<K>, V>{
    private Node root;
    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int N;

        public Node(K key, V val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public K min() {
        if (isEmpty()) return null;
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    public K max() {
        if (isEmpty()) return null;
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else                 return max(x.right);
    }

    public void put(K key, V val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }


    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }
    private Node put(Node x, K key, V val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public V get(K key) {
        return get(root, key);
    }
    private V get(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public void deleteMin() {
        if (isEmpty()) throw new RuntimeException("underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new RuntimeException("underflow");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public Iterable<K> keys() {
        return keys(min(), max());
    }

    public Iterable<K> keys(K lo, K hi) {
        Queue<K> queue = new Queue<K>() {
            public int size() {
                return 0;
            }

            public boolean isEmpty() {
                return false;
            }

            public boolean contains(Object o) {
                return false;
            }

            public Iterator<K> iterator() {
                return null;
            }

            public Object[] toArray() {
                return new Object[0];
            }

            public <T> T[] toArray(T[] a) {
                return null;
            }

            public boolean add(K k) {
                return false;
            }

            public boolean remove(Object o) {
                return false;
            }

            public boolean containsAll(Collection<?> c) {
                return false;
            }

            public boolean addAll(Collection<? extends K> c) {
                return false;
            }

            public boolean removeAll(Collection<?> c) {
                return false;
            }

            public boolean retainAll(Collection<?> c) {
                return false;
            }

            public void clear() {

            }

            public boolean equals(Object o) {
                return false;
            }

            public int hashCode() {
                return 0;
            }

            public boolean offer(K k) {
                return false;
            }

            public K remove() {
                return null;
            }

            public K poll() {
                return null;
            }

            public K element() {
                return null;
            }

            public K peek() {
                return null;
            }
        };
        return queue;
    }

}

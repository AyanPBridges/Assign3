package com.company;

public class BST<K extends Comparable<K>, V>{
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val)
        {
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val){
        //code
    }
    public V get(K key){
        //code
    }
    public void delete(K key){
        //code
    }
    public Iterable<K> iterator(){
        //code
    }
}

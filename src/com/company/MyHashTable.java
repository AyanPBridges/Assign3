package com.company;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;
        final int hashCode;
        HashNode<K, V> next;
        public HashNode(K key, V value, HashNode<K,V> next, int hashCode)
        {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hashCode = hashCode;
        }
    }
    private int getIndex(K key){
        int hashCode = key.hashCode() % chainArray.length;
        if(hashCode < 0){
            hashCode += chainArray.length;
        }
        return hashCode;
    }

        private HashNode<K, V>[] chainArray;
        private int M=11;
        private int size;
        public MyHashTable(int M){
            chainArray = new HashNode[M];
        }
        public V put(K key, V value){
            int hashCode = getIndex(key);
            for(HashNode<K,V> node = chainArray[hashCode]; node != null; node = node.next){
                if((hashCode == node.hashCode) && key.equals(node.key)){
                    V oldValue = node.value;
                    node.value = value;
                    return oldValue;
                }
            }
            HashNode<K,V> node = new HashNode<K,V>(key, value, chainArray[hashCode], hashCode);
            chainArray[hashCode] = node;

            return null;
        }
        public V get(K key){
            int hashCode = getIndex(key);

            for(HashNode<K,V> node = chainArray[hashCode]; node != null; node = node.next){
                if(key.equals(node.key))
                    return node.value;
            }
            return null;
        }
        public boolean remove(K key){
            int hashCode = getIndex(key);
            HashNode<K,V> previous = null;
            for(HashNode<K,V> node = chainArray[hashCode]; node != null; node = node.next){
                if((hashCode == node.hashCode) && key.equals(node.key)){
                    if(previous != null){
                        previous.next = node.next;
                    }else{
                        chainArray[hashCode] = node.next;
                    }
                    return true;
                }
                previous = node;
            }
            return false;
        }
}

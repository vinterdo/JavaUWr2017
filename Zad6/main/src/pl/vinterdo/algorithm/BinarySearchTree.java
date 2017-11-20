package pl.vinterdo.algorithm;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>, V> extends Dictionary<K, V> {

    private int size;
    private Node root;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Enumeration<K> keys() {
        List<K> keys = new LinkedList<>();
        return null;
    }

    @Override
    public Enumeration<V> elements() {
        return null;
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            throw new NullPointerException();
        }
        return getClosest((K) key, root);
    }

    private V getClosest(K key, Node node) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare == 0) {
            return node.value;
        }
        return compare < 0 ? getClosest(key, node.lower) : getClosest(key, node.higher);
    }

    @Override
    public V put(K key, V value) {
        if(root == null) {
            root = new Node(key, value, null);
            size++;
            return null;
        }
        return putRec(key, value, root);
    }

    private V putRec(K key, V value, Node node) {
        int compare = key.compareTo(node.key);
        if(compare < 0) {
            if(node.lower == null) {
                node.lower = new Node(key,value, node);
                size++;
                return null;
            }
            else {
                return putRec(key, value, node.lower);
            }
        }
        if(compare > 0) {
            if(node.higher == null) {
                node.higher = new Node(key,value, node);
                size++;
                return null;
            }
            else {
                return putRec(key, value, node.higher);
            }
        }
        // compare == 0
        V toRet = node.value;
        node.value = value;
        return toRet;
    }

    @Override
    public V remove(Object key)
    {
        return removeRec((K)key, root);
    }

    private V removeRec(K key, Node node) {
        if(node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if(compare == 0) {
            V toReturn = node.value;
            Node lower = node.lower;
            Node higher = node.higher;

            if(lower != null && higher != null) {
                Node successor = min(node.higher);
                node.replaceWith(successor);
                node.lower = lower;
                node.higher = higher;
                removeRec(successor.key, node.higher);
                return toReturn;
            }
            if(lower == null && higher == null) {
                size--;
                if(node.parent.lower == node) {
                    node.parent.lower = null;
                    node.parent = null;
                    return toReturn;
                }
                if(node.parent.higher == node) {
                    node.parent.higher = null;
                    node.parent = null;
                    return toReturn;
                }
            }
            size--;
            Node replace = lower == null ? higher : lower;
            node.replaceWith(replace);

            return toReturn;
        }
        if(compare > 0) {
            return removeRec(key, node.higher);
        }
        if(compare < 0) {
            return removeRec(key, node.lower);
        }
        return null;
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node node) {
        Node n = node;
        while(n.lower != null) {
            n = n.lower;
        }
        return n;
    }

    public K max() {
        Node n = root;
        while(n.higher != null) {
            n = n.higher;
        }
        return n.key;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    private class Node {
        Node(K key, V value, Node parent) {
            this.value = value;
            this.key = key;
            this.parent = parent;
        }

        K key;
        V value;
        Node lower;
        Node higher;
        Node parent;

        void replaceWith(Node replace) {
            key = replace.key;
            value = replace.value;
            lower = replace.lower;
            higher = replace.higher;
        }
    }
}

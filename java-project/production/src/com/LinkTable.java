package com;

/**
 * Created on 2019-12-26.
 *
 * @author 迹_Jason
 */
public class LinkTable<T> {

    private Node<T> node = null;

    public static void main(String[] args) {
        LinkTable<String> linkTable = new LinkTable<>();
        linkTable.put("one");
        linkTable.put("two");
        linkTable.put("three");
        System.out.println(linkTable.getIndex("two"));
    }

    public void put(T value) {
        Node<T> nNode = new Node<>();
        nNode.value = value;
        if (node == null) {
            node = nNode;
        } else {
            // 重点
            nNode.next = node;
            node = nNode;
        }
    }

    public int getIndex(T value) {
        if (node != null) {
            int index = 0;
            while (node.next != null) {
                if (node.value.equals(value)) {
                    return index;
                }
                // 重点
                node = node.next;
                index++;
            }
            return -1;
        } else {
            return -1;
        }

    }

    static class Node<T> {
        T value;
        Node<T> next;
    }

}

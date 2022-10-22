package project2;

import java.util.ListIterator;

/**
 * This class represents a TreeList.
 * It is made in a Linked List format but does not directly implement LinkedList
 * This holds multiple Tree nodes that can be accessed through iteration and the java.util.ListIterator
 * @author Vishnu Matta
 *
 */
public class TreeList {

    private static ListIterator<String> listIterator;
    private Node head;
    private Node tail;
    private int size = 0;
    private int count = 0;

    private class Node {
        /**
         * This class represents a Node.
         * It contains a field that holds data as a tree file. It also contains a field that holds the Node next.
         */
        Tree data;
        Node next;

        /**
         * This represents a Node class constructor.
         * @param treeNode creates a data field populate with a Tree object and sets next to null
         */
        private Node(Tree treeNode) {
            data = treeNode;
            next = null;
        }
    }


    /**
     * This represents a constructor for a TreeList that creates an empty list with a head and tail equal to null
     */
    public TreeList() {

        head = null;
        tail = null;

    }

    /**
     * Adds a tree node to the TreeList
     * @param tr the parameter of class Tree that can be added to the list
     */
    public void add(Tree tr) throws IllegalArgumentException {
        Node test = new Node(tr);
        if (tr == null) {
            throw new IllegalArgumentException("Entered value CANNOT be null.. enter a valid Tree");
        }
        if (head == null) {
            head = test;
            tail = test;
            size++;
        } else {
            tail.next = test;
            tail = test;
            size++;
        }
    }


    /**
     * @return the total number of trees in the list
     */
    public int getTotalNumberOfTrees(){

        int size = 0;
        Node current = head;

        while(current != null){

            size++;
            current = current.next;


        }

        return size;
    }

    /**
     * @return the total number of trees in the list by CommonName
     */
    public int getCountByCommonName(String speciesName) {
        speciesName = speciesName.toLowerCase();
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data.getSpc_common().toLowerCase().equals(speciesName)) {
                count++;
            }
            current = current.next;
        }
        return count;

    }

    /**
     * @return the total number of trees in the list by LatinName
     */
    public int getCountByLatinName(String speciesName) {
        speciesName = speciesName.toLowerCase();
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data.getSpc_latin().toLowerCase().equals(speciesName)) {
                count++;
            }
            current = current.next;
        }
        return count;
    }


    /**
     * @return the total number of trees in the list based on the borough name
     */
    public int getCountByBorough(String boroName) {
        boroName = boroName.toLowerCase();
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data.getBoroname().toLowerCase().equals(boroName)) {
                count++;
            }
            current = current.next;
        }
        return count;

    }

    /**
     * @return the total number of trees in the list by CommonName in a particular borough
     */
    public int getCountByCommonNameBorough(String speciesName, String boroName) {
        speciesName = speciesName.toLowerCase();
        boroName = boroName.toLowerCase();
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data.getSpc_common().toLowerCase().equals(speciesName)) {
                if (current.data.getBoroname().toLowerCase().equals(boroName)) {
                    count++;
                }
            }
            current = current.next;
        }
        return count;
    }

    /**
     * @return the total number of trees in the list by Latin Name in a particular borough
     */
    public int getCountByLatinNameBorough(String speciesName, String boroName) {
        speciesName = speciesName.toLowerCase();
        boroName = boroName.toLowerCase();
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data.getSpc_latin().toLowerCase().equals(speciesName)) {
                if (current.data.getBoroname().toLowerCase().equals(boroName)) {
                    count++;
                }
            }
            current = current.next;
        }
        return count;
    }

    /**
     * @return the Tree name in a list of Strings
     */
    public String toString() {
        Node current = head;
        StringBuilder outputted = new StringBuilder();
        System.out.println("Trees");
        while (current != null) {
            outputted.append(current.data).append(", ");
            current = current.next;
        }
        return outputted.toString();
    }



}




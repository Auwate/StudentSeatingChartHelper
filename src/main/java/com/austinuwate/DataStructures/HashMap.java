package com.austinuwate.DataStructures;

import com.austinuwate.PersonClasses.Person;

/**
 * This class implements a HashMap to store and access Person objects.
 */
public class HashMap implements Map {

    /**
     * This will hold objects of Persons, just implemented as Objects.
     */
    private final LinkedNode[] personArray;
    private final double SEED;
    //private final int capacity; // -> Will be used in future resize method
    //static int size = 0; // -> Will be used in future resize method
    //static int RESIZE_FACTOR = 2; // -> Will be used in future resize method

    public HashMap () {

        this.SEED = 1+Math.random();
        this.personArray = new LinkedNode[100];
        //this.capacity = 100;

    }

    /**
     * Inserts a new Person object into table.
     *
     * If the head is empty or the location is unused, create a new LinkedList (LinkedNode)
     * If the head is not empty and the location is used, append to the bucket
     * @param SSN -> Uses the SSN of the person to hash the object into the table
     * @param object -> Actual piece of data
     */
    public boolean put (Object SSN, Object object) {

        if ( !(SSN instanceof String) || !(object instanceof Person) ) {
            return false;
        }

        int location = ( (int)(( SEED * Integer.parseInt((String)SSN) )) % 100);

        if (this.personArray[location] == null) {
            this.personArray[location] = new LinkedNode(object, (String)SSN);
        }
        else {
            this.personArray[location].add(object, (String)SSN);
        }

        /* if (size++ > capacity) {

            resize();

        } */

        return true;

    }

    /**
     * Returns the Person object given an SSN
     * @param key -> The individuals SSN / The key we will find data with
     * @return Object -> Person object
     *
     * If the SSN is not a String, return the SSN object.
     * If the hashmap cannot find the data, return a null
     */
    public Object get (Object key) {

        /*
        If the SSN is not a String, return the SSN. The method caller will check to see if
        the returned value is equal to the SSN.
         */
        if ( !(key instanceof String) ) {
            return null;
        }

        int location = ( (int)(( SEED * Integer.parseInt((String)key) )) % 100);

        if ( personArray[ location ] != null ) {
            return personArray[ location ].get((String)key);
        }

        return null;

    }

    /**
     * This method will remove a data, given a key
     * @param key -> Used to find the data
     * @return Object -> Instead of immediately deleting the data, the program will return
     * a copy of what the data was.
     *
     * If the SSN is not a String, return the SSN object.
     * If the hashmap cannot find the data, return a null
     */
    public Object remove (Object key) {

        /*
        If the SSN is not a String, return the SSN. The method caller will check to see if
        the returned value is equal to the SSN.
         */
        if ( !(key instanceof String) ) {
            return null;
        }

        int location = (int)(( SEED * Integer.parseInt((String)key) )) % 100;
        Object temp = null;

        if (personArray[ location ] != null) {

            temp = personArray [ location ].get((String)key);
            personArray[location].remove((String)key);

        }

        return temp;

    }

    /**
     * This method will allow a user to modify
     * @param key -> Used to find the data
     * @param object -> The new data
     * @return boolean -> Used to validate that the instructions were successful
     */
    public boolean modify (Object key, Object object) {

        /*
        This will tell the original method call that there was an issue
         */
        if ( !(key instanceof String) || !(object instanceof Person) ) {
            return false;
        }

        int location = (int)(( SEED * Integer.parseInt((String)key) )) % 100;

        return personArray[location] != null && personArray[location].modify(object, (String) key);

    }

    /**
     * After the table reaches full capacity, it will double in size. However, due to
     * time constraints, this will be implemented later.
     */
    /* private void resize () {

        LinkedNode[] tempTable = new LinkedNode[size * RESIZE_FACTOR];

        for (int i = 0; i < size; i++) {

            tempTable[i] = this.personArray[i];

        }

        this.personArray = tempTable;

    } */

    class LinkedNode {

        private Node head; // Used to reference first node

        /**
         * Constructor for LinkedNode. We will use buckets to avoid collisions.
         *
         * @param person -> Person object
         * @param SSN    ->  SSN key
         */
        public LinkedNode(Object person, String SSN) {

            this.head = new Node (person, SSN);

        }

        /*
         * Returns a 2d array of Objects, with each row being the next bucket
         *
         * @param list -> Current table of buckets holding objects
         * @return ObjectArrayForResizing -> A 2D array of Objects
         */
        /* public Object[][] getObjectListFromMap (LinkedNode[] list) {

            Object[][] ObjectArrayForResizing = new Object[list.length][list.length];
            Node node;
            int j;

            for (int i = 0; i < list.length; i++) {

                node = list[i].head;
                j = 0;

                while (node.next != null) {

                    ObjectArrayForResizing[i][j++] = node.person;
                    node = node.next;

                }

            }

            return ObjectArrayForResizing;

        } */

        /**
         * This method will take two parameters, person and SSN and modify a Node to the
         * current data
         * @param person -> The new data that will replace the old
         * @param SSN -> The key to find the data
         */
        public boolean modify (Object person, String SSN) {

            if (head == null) {

                return false;

            }

            Node node = head;

            while (node.next != null) {

                if (node.SSN.equals(SSN)) {

                    node.person = person;
                    node.SSN = SSN;
                    return true;

                }

                node = node.next;

            }

            return false;

        }

        /**
         * Inserts a new Node at the end of the LinkedNode
         * @param person -> Person object
         * @param SSN -> SSN key
         */
        public void add (Object person, String SSN) {

            if (head == null) {

                head = new Node (person, SSN);
                return;

            }

            Node node = head;

            /*
             * While loops finds the back of the LinkedNode
             */
            while (node.next != null) {

                node = node.next;

            }
            // Creates a new node at the end
            node.next = new Node (person, SSN);

        }

        /**
         * This finds a Person object, given an SSN key
         * @param SSN -> Key
         * @return node.person -> This is a Student or Auditor, wrapped in an Object.
         */
        public Object get (String SSN) {

            if (head == null) {

                return null;

            }

            Node node = head;

            while ( node.next != null && !node.SSN.equals(SSN) ){

                node = node.next;

            }

            return node.person;

        }

        /**
         * This method takes the SSN key and looks for a copy SSN. If it finds it, it will
         * dereference any pointers directed towards the copy. This lets the trash collector
         * deallocate the Node.
         * @param SSN -> Key to find specific Person object
         */
        public void remove (String SSN) {

            Node node = head;
            Node previous = null;

            while (node.next != null && !node.SSN.equals(SSN)) {

                previous = node;
                node = node.next;

            }

            // Checking for null means that the while loop actually ran. If it did not, then
            // The bucket is empty, and we just need to work with the head.
            if (previous != null && node.SSN.equals(SSN)) {

                previous.next = node.next;

            }

            else if (previous == null && head.SSN.equals(SSN)) {

                head = head.next;

            }

        }

        /**
         * Inner Node class
         *
         * This supports the bucket system for collision avoidance through the LinkedNode class
         */
        class Node {

            private Node next;
            private Object person;
            private String SSN;

            public Node (Object person, String SSN) {

                this.next = null;
                this.person = person;
                this.SSN = SSN;

            }

        }

    }

}

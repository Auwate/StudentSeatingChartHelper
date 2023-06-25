package com.austinuwate.DataStructures;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * This class implements a HashMap to store and access Person objects.
 */
public class HashMap {

    /**
     * This will hold objects of Persons, just implemented as Objects.
     */
    private LinkedNode[] personArray;
    private final double SEED;
    private final int capacity;
    static int size = 0;
    static int RESIZE_FACTOR = 2;

    public HashMap () {

        this.SEED = 1+Math.random();
        this.personArray = new LinkedNode[100];
        this.capacity = 100;

    }

    public HashMap (int capacity, double SEED) {

        this.SEED = SEED;
        this.personArray = new LinkedNode[capacity];
        this.capacity = capacity;

    }

    /**
     * Inserts a new Person object into table.
     *
     * If the head is empty or the location is unused, create a new LinkedList (LinkedNode)
     * If the head is not empty and the location is used, append to the bucket
     * @param SSN -> Uses the SSN of the person to hash the object into the table
     * @param object -> Actual piece of data
     */
    public void put (String SSN, Object object) {

        int location = (int)(( SEED * Integer.parseInt(SSN) ) % capacity);

        if (this.personArray[location] == null) {
            this.personArray[location] = new LinkedNode(object, SSN);
        }
        else {
            this.personArray[location].add(object, SSN);
        }
        size++;

    }

    /**
     * Returns the Person object given an SSN
     * @param SSN -> The individuals SSN
     * @return -> Person object
     */
    public Object get (String SSN) {

        int location = (int)(( SEED * Integer.parseInt(SSN) ) % capacity);

        if ( personArray[ location ] != null ) {
            return personArray[ location ].get(SSN);
        }

        return null;

    }

    /**
     * After the table reaches full capacity, it will double in size
     */
    private void resize () {

        HashMap copy = new HashMap(this.capacity * RESIZE_FACTOR, this.SEED );
        LinkedNode[] tempTable = new LinkedNode[size * 2];

        for (int i = 0; i < size; i++) {

            tempTable[i] = copy.personArray[i];

        }

        this.personArray = tempTable;

    }

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
            this.head = null;

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

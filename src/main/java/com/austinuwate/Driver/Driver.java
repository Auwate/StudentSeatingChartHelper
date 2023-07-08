package com.austinuwate.Driver;

import com.austinuwate.Test.TestHashMap;
import com.austinuwate.Test.TestSeatingHelperHashMap;

/**
 * PROGRAM EXPLANATION:
 *
 * Currently, SeatingHelperChart is a deep dive into abstraction and the use of interfaces in a program. This
 * utilizes a HashMap data structure to store all the data, as well as test classes to make sure the backend works.
 *
 * The basic synopsis is as follows: A person in a classroom can be a Student or an Auditor. These both implement
 * the Person interface, and are passed as Objects into the HashMap. When these objects are retrieved from the
 * HashMap, they are scanned to be either a Student or Auditor using the instanceof command and the key to finding
 * the Student/Auditor objects is their SSN.
 *
 * FURTHER DEVELOPMENT PLANNED:
 *
 * I plan on implementing a chart that allows you to review any student in a 10x10 grid. This would require implementing
 * a method in SeatingHelperHashMap (class) & SeatingHelper (interface) to accommodate this.
 */
public class Driver {

    public Driver () {

        new TestHashMap();
        new TestSeatingHelperHashMap();

    }

    public static void main (String[] args) {

        new Driver();

    }

}

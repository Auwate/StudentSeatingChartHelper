package com.austinuwate;

import java.util.Random;

public class SeatingHelper {

    /**
     * This checks for a test boolean, which will launch quickTest() if true. This helps
     * streamline tests.
     * @param isTest -> boolean parameter passed when constructing the object.
     */
    public SeatingHelper (boolean isTest) {

        if (isTest) {
            quickTest();
        }



    }

    /**
     * This method will immediately populate a class of 30 random individuals. These random
     * individuals could be Students or Auditors, although the chance for a Student is much
     * higher.
     */
    public void quickTest () {

        Random random = new Random ();

        for (int i = 0; i < 30; i++) {

            if (random.nextInt(6) < 5) {



            }

        }

    }

}

/**
 * TO-DO:
 *
 * 1. Implement Array & LinkedList Data Types
 * 2. Finish SeatingHelper quickTest() with Data Types in mind
 * 3. Finish SeatingHelper constructor
 *      - Use while loop for user-interface
 * 4. Complete Seating Helper class
 *      - Create helper methods for showing students and student arrangement
 * 5. Start developing algorithms for finding and rearranging
 *      - Finding (BFS, DFS, Linear Search, Binary Search, etc) Rearranging (Alphabetical, major,
 *      year, SSN)
 * 6. Learn and use persistence
 */
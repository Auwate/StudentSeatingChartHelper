package com.austinuwate.Driver;

import com.austinuwate.SeatingHelperClasses.SeatingHelperHashMap;
import com.austinuwate.Test.TestHashMap;

public class Driver {

    public static void main (String[] args) {

        /*
            Driver just calls a new SeatingHelperHashMap
         */

        new TestHashMap();
        new SeatingHelperHashMap();

        /*
            Done:
                PersonClasses Package
                DataStructures Package

                TestHashMap Class

            To-Do:
                SeatingHelperHashMap
                    - Acts as the interface between the HashMap and the User
                    - Will have more front-end design
                    - User friendly

         */

    }

}

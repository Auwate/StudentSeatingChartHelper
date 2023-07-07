package com.austinuwate.Driver;

import com.austinuwate.SeatingHelperClasses.SeatingHelperHashMap;
import com.austinuwate.Test.TestHashMap;
import com.austinuwate.Test.TestSeatingHelperHashMap;

public class Driver {

    public static void main (String[] args) {

        /*
            Driver just calls a new SeatingHelperHashMap
         */

        //new TestHashMap();
        new TestSeatingHelperHashMap();

        /*
            7/3/2023
            DONE:
                Map Interface
                    - Necessary for decoupling between packages
                    - Added modify & remove methods

            To-Do:
                SeatingHelperHashMap
                    - Acts as the interface between the HashMap and the User
                    - Will have more front-end design
                    - User friendly
                    - Uses the Map interface

         */

    }

}

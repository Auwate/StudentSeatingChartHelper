package com.austinuwate.Test;

import com.austinuwate.PersonClasses.Auditor;
import com.austinuwate.PersonClasses.Person;
import com.austinuwate.PersonClasses.Student;
import com.austinuwate.SeatingHelperClasses.SeatingHelperHashMap;

import java.util.Random;

public class TestSeatingHelperHashMap {

    private final int TEST_AMOUNT = 100; // Quickly change the amount you want to put/get
    // from the class. In addition, This will include random null values as part of testing.

    public TestSeatingHelperHashMap () {

        SeatingHelperHashMap test = new SeatingHelperHashMap();
        String[] arrayOfSSNs = new String[TEST_AMOUNT];

        addTest(test, arrayOfSSNs);
        getTest(test, arrayOfSSNs);
        modifyTest(test, arrayOfSSNs);
        removeTest(test, arrayOfSSNs);

    }

    /**
     * Tests the remove method of the SeatingHelperHashMap cass
     * @param test -> Object to test
     * @param arr -> Array of Strings that specify data in the hashMap
     */
    public void removeTest (SeatingHelperHashMap test, String[] arr) {

        System.out.println("SYSTEM ----------------------------------------------" +
                "\nStart of removeTest(test, arr) method.\n\n");

        long t1 = System.nanoTime();

        for (int i = 0; i < TEST_AMOUNT; i++) {

            test.remove(arr[i]);

        }

        System.out.println("SYSTEM ----------------------------------------------" +
                "\nremoveTest took " + (System.nanoTime()-t1) + " nanoseconds to complete.\n\n");

    }

    /**
     * Tests the modify method of the SeatingHelperHashMap class
     * @param test -> Object to test
     * @param arr -> Array of Strings that specify data in the hashMap
     */
    public void modifyTest (SeatingHelperHashMap test, String[] arr) {

        System.out.println("SYSTEM ----------------------------------------------" +
                "\nStart of modifyTest(test, arr) method.\n\n");


        long t1 = System.nanoTime();

        Random randomNumber = new Random ();
        int holder;
        int arrHolder;

        for (int i = 0; i < TEST_AMOUNT/2; i++) {

            arrHolder = randomNumber.nextInt(TEST_AMOUNT);

            /*
            This will find a number between 1-6. If the number is 6, then it will be an auditor.
            If the number is less than 6, it is a student. If it is 1, it is a null value
             */

            holder = randomNumber.nextInt(6)+1;

            if (holder == 6) {

                holder = randomNumber.nextInt( 888888888 ) + 111111111;
                test.modify(arrHolder, new Auditor("Name"+i, String.valueOf(holder),"fact"+i) );

            }

            else if (holder == 1) {

                test.modify(null, null);

            }

            else {

                holder = randomNumber.nextInt( 888888888 ) + 111111111;
                test.modify(arrHolder, new Student("Name"+i, String.valueOf(holder),"fact"+i, "Major"+i, randomNumber.nextInt(3)+1) );

            }

            arr[arrHolder] = String.valueOf(holder);

        }

        System.out.println("SYSTEM ----------------------------------------------" +
                "\nmodifyTest took " + (System.nanoTime()-t1) + " nanoseconds to complete.\n\n");

    }

    /**
     * Tests the add method of the SeatingHelperHashMap class
     * @param test -> Object to test
     * @param arr -> Array of Strings that specify data in the hashMap
     */
    public void addTest (SeatingHelperHashMap test, String[] arr) {

        System.out.println("SYSTEM ----------------------------------------------" +
                "\nStart of addTest(test, arr) method.\n\n");

        long t1 = System.nanoTime();

        Random randomNumber = new Random ();
        int holder;

        for (int i = 0; i < TEST_AMOUNT; i++) {

            /*
            This will find a number between 1-6. If the number is 6, then it will be an auditor.
            If the number is less than 6, it is a student. If it is 1, it is a null value
             */
            holder = randomNumber.nextInt(6)+1;

            if (holder == 6) {

                holder = randomNumber.nextInt( 888888888 ) + 111111111;
                test.add(String.valueOf(holder), new Auditor("Name"+i, String.valueOf(holder),"fact"+i) );

            }

            else if (holder == 1) {

                test.add(null, null);

            }

            else {

                holder = randomNumber.nextInt( 888888888 ) + 111111111;
                test.add(String.valueOf(holder), new Student("Name"+i, String.valueOf(holder),"fact"+i, "Major"+i, randomNumber.nextInt(3)+1) );

            }

            arr[i] = String.valueOf(holder);

        }

        System.out.println("SYSTEM ----------------------------------------------" +
                "\naddTest took " + (System.nanoTime()-t1) + " nanoseconds to complete.\n\n");

    }

    /**
     * Tests the get method of the SeatingHelperHashMap class
     * @param test -> Object to test
     * @param arr -> Array of Strings that specify data in the hashMap
     */
    public void getTest (SeatingHelperHashMap test, String[] arr) {

        System.out.println("SYSTEM ----------------------------------------------" +
                "\nStart of getTest(test, arr) method.\n\n");

        long t1 = System.nanoTime();

        Object person;

        for (int i = 0; i < TEST_AMOUNT; i++) {

            person = test.get(arr[i]);

            if (person == null) {
                continue;
            }

            if (person instanceof Student) {

                System.out.println("Student" + "\nName: " + ( (Student) person).getName()
                        + "\nSSN: " + ( (Student) person).getSSN() + "\nFact: " + ( (Student) person).getFact()
                        + "\nMajor: " + ( (Student) person).getMajor() + "\nYear: " + ( (Student) person).getYear()
                        + "\n");

            }

            else if (person instanceof Auditor) {

                System.out.println("Auditor" + "\nName: " + ((Person)person).getName()
                        + "\nSSN: " + ((Person)(person)).getSSN() + "\nFact: " + ((Person)person).getFact()
                        + "\n");

            }

        }

        System.out.println("SYSTEM ----------------------------------------------" +
                "\ngetTest took " + (System.nanoTime()-t1) + " nanoseconds to complete.\n\n");


    }

}

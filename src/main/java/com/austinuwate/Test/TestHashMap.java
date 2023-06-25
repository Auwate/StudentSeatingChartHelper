package com.austinuwate.Test;

import com.austinuwate.DataStructures.HashMap;
import com.austinuwate.PersonClasses.Person;
import com.austinuwate.PersonClasses.Student;
import com.austinuwate.PersonClasses.Auditor;
import java.util.Random;


/**
 * TestHashMap class
 *
 * Part of the Test package
 *
 * Tests the various parts of the in-house made HashMap
 */
public class TestHashMap {

    public TestHashMap () {

        HashMap hashMap = new HashMap();
        String[] arrayOfSSNs = new String[1000];
        putTest(hashMap, arrayOfSSNs);
        getTest(hashMap, arrayOfSSNs);

    }

    public void putTest (HashMap map, String[] arr) {

        Random randomNumber = new Random ();
        int holder;

        for (int i = 0; i < 100; i++) {

            /*
            This will find a number between 1-6. If the number is 6, then it will be an auditor.
            If the number is less than 6, it is a student.
             */
            holder = randomNumber.nextInt(6)+1;

            if (holder == 6) {

                holder = randomNumber.nextInt( 888888888 ) + 111111111;
                map.put(String.valueOf(holder), new Auditor ("Name"+i, String.valueOf(holder),"fact"+i) );

            }

            else {

                holder = randomNumber.nextInt( 888888888 ) + 111111111;
                map.put(String.valueOf(holder), new Student ("Name"+i, String.valueOf(holder),"fact"+i, "Major"+i, randomNumber.nextInt(3)+1) );

            }

            arr[i] = String.valueOf(holder);

        }

    }

    public void getTest (HashMap map, String[] arr) {

        Object person;

        for (int i = 0; i < 100; i++) {

            person = map.get(arr[i]);

            if (person instanceof Student) {

                System.out.println("Student SSN: " + ((Student) person).getSSN());

            }

            else if (person instanceof Auditor) {

                System.out.println("Auditor SSN: " + ((Auditor) person).getSSN());

            }

        }

    }

}

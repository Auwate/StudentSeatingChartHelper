package com.austinuwate.SeatingHelperClasses;

import com.austinuwate.DataStructures.HashMap;
import com.austinuwate.PersonClasses.Person;

/**
 * Methods with documentation are class specific
 * For basic method documentation, read @SeatingHelperTemplate
 */
public class SeatingHelperHashMap implements SeatingHelper {

    /*
    This implementation will use the HashMap to store and retrieve data
     */
    private final HashMap table;

    public SeatingHelperHashMap() {

        table = new HashMap ();

    }

    @Override
    public void add(String key, Object object) {

        if (! (object instanceof Person) ) {

            return;

        }

        this.table.put(key, object);

    }

    @Override
    public void remove(Object object) {

    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void get(Object object) {

    }
}

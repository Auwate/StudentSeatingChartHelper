package com.austinuwate.SeatingHelperClasses;

import com.austinuwate.DataStructures.HashMap;
import com.austinuwate.DataStructures.Map;
import com.austinuwate.PersonClasses.Person;

/**
 * Methods with documentation are class specific
 * For basic method documentation, read @SeatingHelperTemplate
 */
public class SeatingHelperHashMap implements SeatingHelper {

    /*
    Using the map interface, we will call the methods applied in the HashMap class
     */
    private final Map table;

    public SeatingHelperHashMap() {

        table = new HashMap ();

    }

    /**
     * This method will call the add method in the Map interface class
     * @param key -> The key allows for quick finding
     * @param object -> Allows for any variable to be passed in anticipation of future data
     */
    @Override
    public void add(String key, Object object) {

        /*
            The only circumstance where the method would return false is when key or object are not the correct types.
         */
        try {

            if (!this.table.put(key, object)) {

                throw new Exception (" --- key is not of type String or object is not of type Person.");

            }

        }
        /*
            Simple try-catch block. Perhaps a little unnecessary, but useful to also practice exceptions.
         */
        catch (Exception putException) {

            System.err.println("Map.put Exception:" + putException.getMessage());

        }

    }

    /**
     * This will call the remove method from the Map interface.
     * @param key -> Allows the method to find any element in the hashtable
     */
    @Override
    public Object remove(Object key) {

        Object data = null;

        /*
            The only circumstance where the method would return false is when the key is not of type String
         */
        try {

            if (key == null) {

                throw new NullPointerException (" --- key is not of type String.");

            }

            data = this.table.remove(key);

            if (data == null) {

                throw new Exception (" --- key is not found in hashmap");

            }

        }

        /*
           Simple try-catch block. Perhaps a little unnecessary, but useful to also practice exceptions.
         */
        catch (NullPointerException nullPointerException) {

            System.err.println("Map.remove Exception: Key points to a null value");

        }

        catch (Exception removeException) {

            System.err.println("Map.remove Exception:" + removeException.getMessage());
            return null;

        }

        return data;

    }

    /**
     *
     * @param key -> This allows the HashMap to find any element
     * @param object -> New data
     */
    @Override
    public void modify (Object key, Object object) {

        /*
            The only circumstance where the method would return false is when the key is not of type String
         */
        try {

            if (!this.table.modify(key, object)) {

                throw new Exception (" --- key is not of type String or object is not of type Person.");

            }

        }

        /*
           Simple try-catch block. Perhaps a little unnecessary, but useful to also practice exceptions.
         */
        catch (Exception modifyException) {

            System.err.println("Map.modify Exception:" + modifyException.getMessage());

        }

    }

    /**
     * This calls the Map interface's get function.
     * @param key -> Allows the HashMap to find any element
     */
    @Override
    public Object get(Object key) {

        Object data = null;

        /*
            The only circumstance where the method would return false is when the key is not of type String
         */
        try {

            if (key == null) {

                throw new Exception (" --- key is not of type String.");

            }

            data = this.table.get(key);

            if (data == null) {

                throw new Exception (" --- key is not found in hashmap");

            }

        }

        /*
           Simple try-catch block. Perhaps a little unnecessary, but useful to also practice exceptions.
         */
        catch (Exception getException) {

            System.err.println("Map.remove Exception:" + getException.getMessage());

        }

        return data;

    }
}

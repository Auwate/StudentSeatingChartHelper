package com.austinuwate.SeatingHelperClasses;

public interface SeatingHelper {

    /**
     * Add method is data type specific (for method of addition)
     * to appropriately maximize CRUD operation efficiency
     *
     * @param object -> Allows for any variable to be passed in anticipation of future data
     * @param key -> The key allows for quick finding
     */
    void add (String key, Object object);

    /**
     * Remove method is data type specific (for method of removal)
     * to appropriately maximize CRUD operation efficiency
     *
     * @param key -> Allows the method to find any element in the hashtable
     */
    Object remove (Object key);

    /**
     * Update method is data type specific (for method of finding/modifying)
     * to appropriately maximize CRUD operation efficiency
     *
     * @param key -> Allows the HashMap to find any element
     * @param object -> New data
     */
    void modify (Object key, Object object);


    /**
     * Read method is data type specific (for method of finding)
     * to appropriately maximize CRUD operation efficiency
     *
     * @param key -> Gets the value based on the key
     */
    Object get (Object key);

}
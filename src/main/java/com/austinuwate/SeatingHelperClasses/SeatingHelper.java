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
     * @param object -> Allows for any variable to be passed in anticipation of future data
     */
    void remove (Object object);

    /**
     * Update method is data type specific (for method of finding/modifying)
     * to appropriately maximize CRUD operation efficiency
     *
     * @param object -> Allows for any variable to be passed in anticipation of future data
     */
    void update (Object object);


    /**
     * Read method is data type specific (for method of finding)
     * to appropriately maximize CRUD operation efficiency
     *
     * @param object -> Gets the value based on the object
     */
    void get (Object object);

}
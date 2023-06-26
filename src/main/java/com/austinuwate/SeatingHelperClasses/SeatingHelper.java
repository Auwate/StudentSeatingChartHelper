package com.austinuwate.SeatingHelperClasses;

import java.util.Random;

public interface SeatingHelper {

    /**
     * Constructor:
     *
     * This checks for a test boolean, which will launch quickTest() if true. This helps
     * streamline tests.
     * @param isTest -> boolean parameter passed when constructing the object.
     */


    /**
     * Test Method:
     *
     * This method will immediately populate a class of 30 random individuals. These random
     * individuals could be Students or Auditors, although the chance for a Student is much
     * higher.
     */
    public void quickTest ();

    /**
     * Add method is data type specific (for method of addition)
     * to appropriately maximize CRUD operation efficiency
     *
     * @param object -> Allows for any variable to be passed in anticipation of future data
     */
    public void add (Object object);

    /**
     * Remove method is data type specific (for method of removal)
     * to appropriately maximize CRUD operation efficiency
     *
     * @param object -> Allows for any variable to be passed in anticipation of future data
     */
    public void remove (Object object);

    /**
     * Update method is data type specific (for method of finding/modifying)
     * to appropriately maximize CRUD operation efficiency
     *
     * @param object -> Allows for any variable to be passed in anticipation of future data
     */
    public void update (Object object);


    /**
     * Read method is data type specific (for method of finding)
     * to appropriately maximize CRUD operation efficiency
     *
     * @param object -> Gets the value based on the object
     */
    public void get (Object object);

}
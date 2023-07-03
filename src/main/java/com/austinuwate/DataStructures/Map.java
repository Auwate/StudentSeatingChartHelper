package com.austinuwate.DataStructures;

/**
 * This interface will be used instead of directly instantiating a HashMap object. This provides
 * a level of decoupling.
 */
public interface Map {

        /**
         * This method adds a new element into our map implementation
         * @param key -> Used to label the new element for future retrieval
         * @param object -> The data itself
         * @return boolean -> Used to validate that the instructions were successful
         */
        boolean put (Object key, Object object);

        /**
         * This method gets a piece of data, given a key
         * @param key -> Used to find the data
         * @return Object -> Will return a copy of the data in the hashmap
         *
         *
         */
        Object get (Object key);

        /**
         * This method will remove a piece of data from the table, given a key
         * @param key -> Used to find the data
         * @return Object -> Instead of immediately deleting the data, the program will return
         * a copy of what the data was.
         *
         *
         *
         *
         * !!! IMPORTANT
         * There were plans to implement a containsKey method, but the remove method will
         * fulfill its roll. By returning a NULL value if no values were removed, it
         * effectively becomes a containsKey method.
         */
        Object remove (Object key);

        /**
         * This method will edit a piece of data from the table, given a key
         * @param key -> Used to find the data
         * @param object -> The new data
         * @return boolean -> Used to validate that the instructions were successful
         */
        boolean modify (Object key, Object object);

}

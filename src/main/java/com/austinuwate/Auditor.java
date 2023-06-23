package com.austinuwate;

/**
 * This class reflects the real life occurrence of people auditing a class. They are not Students,
 * but instead just individuals looking to learn something new. Thus, they implement the Person
 * class, and do not contain the major and year fields.
 */
public class Auditor implements Person {

    private String name;
    private String SSN;
    private String fact;

    /**
     * Main constructor for the Auditor class.
     * Utilizes 3 parameters  to fill its various fields.
     * @param name -> name field
     * @param SSN -> SSN field
     * @param fact -> fact field
     */
    public Auditor ( String name, String SSN, String fact ) {

        this.name = name;
        this.SSN = SSN;
        this.fact = fact;

    }

    /**
     * All classes under this are general purpose accessor and mutator methods.
     */

    @Override
    public String getFact () {

        return this.fact;

    }

    @Override
    public String getSSN () {

        return this.SSN;

    }

    @Override
    public String getName () {

        return this.name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}

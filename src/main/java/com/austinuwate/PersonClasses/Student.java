package com.austinuwate.PersonClasses;

import com.austinuwate.PersonClasses.Person;

/**
 * This class will be the most common class used, as a classroom predominantly has Students,
 * rather than Auditors. In addition, a Student has a major and year designation, and thus
 * will contain 2 more fields than the Auditor class.
 */
public class Student implements Person {

    private String name;
    private String SSN;
    private String fact;
    private String major;
    private int year;

    /**
     * Main constructor for this class.
     * Utilizes 5 parameters to fill in its various fields.
     *
     * @param name -> name field
     * @param SSN -> SSN field
     * @param fact -> fact field
     * @param major -> Student exclusive field. Specifies the student's major
     * @param year -> Student exclusive field. Specifies the student's year
     */
    public Student ( String name, String SSN, String fact, String major, int year ) {

        this.name = name;
        this.SSN = SSN;
        this.fact = fact;
        this.major = major;
        this.year = year;

    }

    /**
     * All classes under this are general purpose accessor and mutator methods.
     */

    public int getYear () {

        return this.year;

    }

    public String getMajor () {

        return this.major;

    }

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

    public void setMajor(String major) {
        this.major = major;
    }

    public void setYear(int year) {
        this.year = year;
    }

}

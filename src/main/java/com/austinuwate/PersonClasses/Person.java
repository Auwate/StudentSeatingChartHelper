package com.austinuwate.PersonClasses;

/**
 * This class tries to implement the Interface Segregation Principle and Dependency Inversion
 * Principle.
 *
 * As for the context of the class itself, both Students and Auditors can be PEOPLE, thus having
 * a common interface could be useful.
 */
public interface Person {

    public String getName ();
    public String getSSN ();
    public String getFact ();
    public void setFact (String fact);
    public void setSSN (String SSN);
    public void setName (String name);

}

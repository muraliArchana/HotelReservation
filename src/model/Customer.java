package model;

import java.util.regex.Pattern;

public class Customer {

    /**
     * variables used in the customer class
     */
    private String firstName;
    private String lastName;
    private String email;

    private final String emailRegex="^(.+)@(.+).(.com)$";
    private final Pattern pattern=Pattern.compile(emailRegex);

    /**
     *Getters and setters for the variables
     * */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This is a constructor to initialize the object of customer class
     * @param firstName
     * @param lastName
     * @param email
     */
    public Customer(String firstName,String lastName,String email)
    {
        if(firstName==null || firstName==""|| lastName==null ||lastName==""||email==null ||email==""|| !(pattern.matcher(email).matches()))
        {
            throw new IllegalArgumentException("Invalid data.Please enter details");
        }

        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
    @Override
    public String toString()
    {
      return "Customer Name: "+firstName+" "+lastName+", Email: "+email;
    }

}

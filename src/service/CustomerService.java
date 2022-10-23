package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomerService {
    /**
     * variables used in the customerservice
     */
    private Map<String , Customer> mapOfCustomer=new HashMap<>();
    private boolean isEmailExist=false;
    Customer customer;
    /**
     * Creating a static reference for singleton object
     */
    private static CustomerService instance=new CustomerService();
    private CustomerService(){}
    public static CustomerService getInstance(){ return instance;}

    /**
     * Getters and setters to access and set variables
     * @return
     */
    public boolean isEmailExist() {
        return isEmailExist;
    }

    public void setEmailExist(boolean emailExist) {
        isEmailExist = emailExist;
    }

    public void setMapOfCustomer(Map<String, Customer> mapOfCustomer) {
        this.mapOfCustomer = mapOfCustomer;
    }

    /**
     * this method adding new customers into system after checking they exist or not
     * @param firstName
     * @param lastName
     * @param email
     */
    public void addCustomer(String firstName,String lastName,String email)
    {
        if(!isCustomerEmailExist(email)) {
            customer = new Customer(firstName, lastName, email);
            mapOfCustomer.put(customer.getEmail(), customer);
        }
        else
        {
            System.out.println("Email already existed");
        }
    }

    /**
     * Getting customer details correspond to the given email
     * @param customerEmail
     * @return
     */
    public Customer getCustomer(String customerEmail)
    {
        customer=mapOfCustomer.get(customerEmail);
        return customer;
    }

    /**
     * This method return all the customers registered in the system
     * @return
     */
    public Map<String, Customer> getAllCustomers() {
        return mapOfCustomer;
    }

    /**
     * Checking whether customer is already registered in the system or not
     * @param email
     * @return
     */
     public boolean isCustomerEmailExist(String email)
     {

         if(mapOfCustomer.containsKey(email))
         {
             isEmailExist=true;
         }
         return isEmailExist;
     }
}

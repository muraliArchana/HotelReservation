package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;


public class AdminResource {

    //Static reference to the class
    private static AdminResource instance=new AdminResource();
    private AdminResource(){}
    public static AdminResource getInstance()
    {
        return instance;
    }

    /**
     * This method returns details of registered customer passing email as parameter
     * @param customerEmail
     * @return
     */
    public Customer getCustomer(String customerEmail)
    {
        return CustomerService.getInstance().getCustomer(customerEmail);
    }

    /**
     * Adding a new room into the system
     * @param rooms
     */
    public void addRoom(IRoom rooms)
    {
        try {
            ReservationService.getInstance().addRoom(rooms);
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println(ex.getLocalizedMessage());
        }

    }

    /**
     * This method returns details of all rooms
     * @return
     */
    public ArrayList<IRoom> getAllRooms()
    {
        return ReservationService.getInstance().getAllRooms();
    }

    /**
     * This method returns details of all customers registered in the system
     * @return
     */
    public ArrayList<Customer>getAllCustomers()
    {
        return CustomerService.getInstance().getAllCustomers();
    }

    /**
     * This method display details of all rooms booked
     */
    public void displayAllReservations()
    {
        ReservationService.getInstance().getAllReservation();
    }
}

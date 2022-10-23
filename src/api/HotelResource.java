package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Date;

public class HotelResource {

    //Adding static reference
    private static HotelResource instance =new HotelResource();
    private HotelResource(){}
    public static HotelResource getInstance(){
        return instance;
    }

    Customer customer;
    IRoom room;
    Reservation reservation;

    /**
     * This method returning customer details according to the email
     * @param email
     * @return
     */
    public Customer getCustomer(String email)
    {
        try {
            if (email!=null && email !="")
            {
                customer= CustomerService.getInstance().getCustomer(email);
            }
        }catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        return customer;
    }

    /**
     * This me
     * @param email
     * @param firstName
     * @param lastName
     */
    public void createACustomer(String email,String firstName,String lastName)
    {
        try {
            CustomerService.getInstance().addCustomer(firstName,lastName,email);

        }catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

    /**
     * This method returns room details according to the room number passed
     * @param roomNumber
     * @return
     */
    public IRoom getRoom(String roomNumber)
    {
        try {
            room= ReservationService.getInstance().getARoom(roomNumber);

        }catch (Exception e)
        {
            System.out.println("Something went wrong please try one more time");
        }
        return room;
    }

    /**
     * This method book a room for customer for the given dates
     * @param customerEmail
     * @param roomNumber
     * @param checkInDate
     * @param checkOutDate
     * @return
     */
    public Reservation bookARoom(Customer customerEmail, IRoom roomNumber, Date checkInDate, Date checkOutDate)
    {
        try {
            reservation=ReservationService.getInstance().reserveARoom(customerEmail,roomNumber,checkInDate,checkOutDate);
        }catch (Exception e)
        {
            System.out.println("Something went wrong please try one more time");
        }
        return reservation;
    }
}

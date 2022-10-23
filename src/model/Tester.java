package model;

import api.HotelResource;
import service.CustomerService;
import service.ReservationService;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        Room room=new Room("123",RoomType.DOUBLE,140.0);
       // FreeRoom freeRoom=new FreeRoom("344",RoomType.DOUBLE);

        //System.out.println(room);

       // System.out.println(freeRoom);
        /*
        try {
            Customer customer=new Customer("Archana","Murali","an@hmk");
            System.out.println(customer);
        }
       catch (IllegalArgumentException ex){
           System.out.println(ex.getLocalizedMessage());
       }*/
       try {


           CustomerService.getInstance().addCustomer("ammu", "aswathi", "Ammu@gmail.com");
           CustomerService.getInstance().addCustomer("kummu", "2", "kummu@gmail.com");
           CustomerService.getInstance().addCustomer("chimmu", "3", "chimmu@gmail.com");
           // System.out.println(CustomerService.getInstance().getCustomer("Ammu@gmail.com"));
           // System.out.println(CustomerService.getInstance().getAllCustomers());
           // System.out.println(CustomerService.getInstance().isCustomerEmailExist("Ammu@gmail.com"));
           ReservationService.getInstance().addingRoom();

          // System.out.println(ReservationService.getInstance().getARoom("238"));
           //Date start = new Date();
           Calendar calendar = Calendar.getInstance();
           calendar.set(2022, 5, 8);
           Date start = calendar.getTime();
           calendar.set(2022,5,12);
           Date end=calendar.getTime();
           calendar.set(2022,6,2);
           Date start2=calendar.getTime();
           calendar.set(2022,6,4);
           Date end2=calendar.getTime();
           calendar.set(2022,3,2);
           Date start3=calendar.getTime();
           calendar.set(2022,3,4);
           Date end3=calendar.getTime();

           Customer cust=CustomerService.getInstance().getCustomer("Ammu@gmail.com");
           Customer cust1=CustomerService.getInstance().getCustomer("kummu@gmail.com");

           IRoom roo1=ReservationService.getInstance().getARoom("232");
           IRoom roo=ReservationService.getInstance().getARoom("238");
           IRoom roo2=ReservationService.getInstance().getARoom("236");


           ReservationService.getInstance().reserveARoom(cust,roo,start,end);
           ReservationService.getInstance().reserveARoom(cust1,roo1,start2,end2);
           ReservationService.getInstance().reserveARoom(cust,roo2,start,end);



          // System.out.println(ReservationService.getInstance().getListOfReservedRoom(start2,end2));
          // ReservationService.getInstance().getAllReservation();
         // System.out.println(ReservationService.getInstance().getCustomersReservation(cust));


          // System.out.println(ReservationService.getInstance().findRooms(start,end).toString());
           HotelResource.getInstance().getCustomer("Ammu@gmail.com");
           System.out.println( HotelResource.getInstance().getCustomer("Ammu@gmail.com"));
       }
       catch (IllegalArgumentException ex){
           System.out.println(ex.getLocalizedMessage());
       }
    }
}

package model;

import java.util.Date;

public class Reservation {

    //Variables of Reservation class
    public Customer customer;
    public IRoom room;
    private Date checkInDate;
    private Date checkOutDate;


    //Getters And Setters for accessing and modifying variables

    public Date getCheckInDate() {
        return checkInDate;
    }
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation Details-- " +
                "" + customer +
                "," + room +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }

    /**
     * Using this method administers can add new room into system
     * @param room
     */
    public Reservation(Customer customer,IRoom room,Date checkInDate,Date checkOutDate)
    {
        this.customer=customer;
        this.room=room;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;

    }

}

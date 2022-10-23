package model;

public class Room implements IRoom{
    //Variables for Room class
    private String roomNumber;
    private Double price;
    private RoomType roomType;
    private Boolean isBooked;
    private Boolean isFreeRoom;

    //Getters and Setters for accessing and modifying variables

    public String getRoomNumber()
    {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /** this method returning price of the room
     */
    public Double getRoomPrice()
    {
        return price;
    }

    /**
    this method returning room free or not
     */
    public boolean isFree()
    {
        return isFreeRoom;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public RoomType getRoomType()
    {
        return roomType;
    }

    public void setRoomsType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Boolean isBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }
    public void setFreeRoom(Boolean isFreeRoom)
    {
        this.isFreeRoom=isFreeRoom;
    }

    /**
     * this is a constructor to initialize variables
     * @param roomNumber
     * @param roomType
     * @param price
     */
   public Room(String roomNumber,RoomType roomType,Double price)
   {
       this.roomNumber=roomNumber;
       this.roomType=roomType;
       this.price=price;
       this.isBooked=false;
       this.isFreeRoom=false;

   }

    /**
     * Default constructor
     */
   public Room()
   {

   }

   @Override
   public String toString()
   {
       if(roomType==RoomType.SINGLE) {
           return "Room Number:" + roomNumber+" Single Bed Room "+"Price: $"+price;
      }
       else
       {
           return "Room Number:" + roomNumber + " Double Bed Room " + "Price: $" + price;
       }

   }

}

package service;

import model.*;

import java.util.*;

public class ReservationService {
    Room roomObj;
    Reservation reservation;
    private Map<String ,Room> mapOfRooms=new HashMap<>();
    private ArrayList<Reservation> listOfReservation=new ArrayList<>();
    private ArrayList<Reservation> listOfCustomerReservations=new ArrayList<>();
    private ArrayList<Reservation> listOfReservedRooms=new ArrayList<>();

    private ArrayList<IRoom> listOfAvailableRooms=new ArrayList<>();
    private boolean isRoomExist=false;

    public Map<String, Room> getMapOfRooms() {
        return mapOfRooms;
    }

    public void setMapOfRooms(Map<String, Room> mapOfRooms) {
        this.mapOfRooms = mapOfRooms;
    }

    /**
     * Adding static reference
     */
    private static ReservationService instance =new ReservationService();
    private ReservationService(){}
    public static ReservationService getInstance(){
        return instance;
    }
    /**
     * Adding a new room into the system
     * @param room
     */
    public void addRoom(IRoom room)
    {
        if(!isRoomNumberExist(room.getRoomNumber())) {
            roomObj = new Room(room.getRoomNumber(), room.getRoomType(), room.getRoomPrice());
            mapOfRooms.put(roomObj.getRoomNumber(), roomObj);
        }
    }

    /**
     * Method to check room number exist or not
     * @param roomNumber
     * @return
     */
    public boolean isRoomNumberExist(String roomNumber)
    {
        if(mapOfRooms.containsKey(roomNumber))
        {
            isRoomExist=true;
        }
        return isRoomExist;
    }

    /**
     * method returns room details correspond to the roomId
     * @param roomId
     * @return
     */
    public IRoom getARoom(String roomId)
    {
       IRoom roomData=mapOfRooms.get(roomId);
       return roomData;

    }
    /**
     * This method reserve a room for a customer
     * @param customer
     * @param room
     * @param checkInDate
     * @param checkOutDate
     * @return
     */
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate,Date checkOutDate)
    {
        if(CustomerService.getInstance().isCustomerEmailExist(customer.getEmail()) && isRoomNumberExist(room.getRoomNumber())) {
            reservation = new Reservation(customer, room, checkInDate, checkOutDate);
            listOfReservation.add(reservation);
        }
        else {
            System.out.println("Please enter correct mail id and room number");
        }
       return reservation;
    }

    /**
     * This method returns list of rooms booked in given dates
     * @param checkInDate
     * @param checkOutDate
     * @return
     */
    public ArrayList<Reservation> getListOfReservedRoom(Date checkInDate,Date checkOutDate)
    {
        for (Reservation reservedRooms:listOfReservation
             ) {
            if(reservedRooms.getCheckInDate().equals(checkInDate) && reservedRooms.getCheckOutDate().equals(checkOutDate))
            {
                listOfReservedRooms.add(reservedRooms);
            }
        }
        return listOfReservedRooms;
    }

    /**
     * This method lists all available rooms for given dates
     * @param checkInDate
     * @param checkOutDate
     * @return
     */
    public ArrayList<IRoom> findRooms(Date checkInDate,Date checkOutDate)
    {
        ArrayList<Reservation> list=getListOfReservedRoom(checkInDate,checkOutDate);
        Map<String ,Room> roomSearchMap=new HashMap<>();
        roomSearchMap.putAll(mapOfRooms);

        for (String roomId:mapOfRooms.keySet()
             ) {
            for (Reservation items:list
                 ) {
                if(items.room.getRoomNumber().equals(roomId))
                {
                    roomSearchMap.remove(roomId);
                }
            }
        }
        Collection<Room> values = roomSearchMap.values();
        listOfAvailableRooms=new ArrayList<IRoom>(values);
        return listOfAvailableRooms;
    }


    /**
     * This method display list of all Room reservations
     */
    public void getAllReservation()
    {

            System.out.println(listOfReservation.toString());
    }

    /**
     * This method returns list of reservations done by a customer
     * @param customers
     * @return
     */
   public ArrayList<Reservation> getCustomersReservation(Customer customers)
   {
       for (Reservation list:listOfReservation
            ) {
           if(list.customer.getEmail().equals(customers.getEmail()))
           {
               listOfCustomerReservations.add(list);
           }
       }
       return listOfCustomerReservations;
   }

   public void addingRoom()
   {
       roomObj=new Room("232", RoomType.SINGLE,230.);
      Room roomObj1=new Room("234", RoomType.SINGLE,230.);
      Room roomObj2=new Room("236", RoomType.DOUBLE,430.);
      Room roomObj3=new Room("238", RoomType.DOUBLE,430.);
      mapOfRooms.put(roomObj.getRoomNumber(),roomObj);
       mapOfRooms.put(roomObj1.getRoomNumber(),roomObj1);
       mapOfRooms.put(roomObj2.getRoomNumber(),roomObj2);
       mapOfRooms.put(roomObj3.getRoomNumber(),roomObj3);
   }
}

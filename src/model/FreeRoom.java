package model;

public class FreeRoom extends Room{

    public FreeRoom(String roomNumber,RoomType roomType)
    {
        super(roomNumber, roomType, 0.0);
        super.setFreeRoom(true);
    }
    @Override
    public String toString()
    {
        return super.toString()+ " Yes! This Room is absolutely free now";
    }
}

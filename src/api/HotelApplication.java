package api;

public class HotelApplication {
    public static void main(String[] args) {
        System.out.println("hello");
       // MainMenu menus=new MainMenu();
        //menus.displayMainMenu();
        HotelResource.getInstance().createACustomer("Ach@gma.com","dd","ach@dm.com");
        HotelResource.getInstance().createACustomer("chuch@gma.com","dd","ach@dm.com");
       // HotelResource.getInstance().createACustomer("Ach@gma.com","dd","ach@dm.com");
        System.out.println("HHray!!"+AdminResource.getInstance().getAllCustomers());

    }
}

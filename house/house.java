package house;

public class house {
    String address;
    int price;
    int size;
    boolean isSold;

    public house() {

        address = "1234 Hello St.";
        price = 12345;
        size = 12;
        isSold = true;
    
    }
    public boolean equals(house house2){
return house2.address.equals(address)&&house2.price==price&&house2.size==size&&house2.isSold==isSold;
    }
}

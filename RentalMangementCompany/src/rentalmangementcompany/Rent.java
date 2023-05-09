package rentalmangementcompany;

import java.io.Serializable;

public class Rent{

   
    private int rent_id;
    private int owner_id;
    private String place;
    private double price_for_sell;
    private double price_for_rent;
    private int num_of_room;
    private String date;
    private int rate;
    private float area;
    private String description;

    public Rent(int rent_id, int owner_id, String place, double price_for_sell, double price_for_rent, int num_of_room, String date, int rate, float area, String description) {
        this.rent_id = rent_id;
        this.owner_id = owner_id;
        this.place = place;
        this.price_for_sell = price_for_sell;
        this.price_for_rent = price_for_rent;
        this.num_of_room = num_of_room;
        this.date = date;
        this.rate = rate;
        this.area = area;
        this.description = description;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public float getArea() {
        return area;
    }
    
    public int getRent_id() {
        return rent_id;
    }

    public String getPlace() {
        return place;
    }

    public double getPrice_for_rent() {
        return price_for_rent;
    }

    public int getNum_of_room() {
        return num_of_room;
    }

    public String getDate() {
        return date;
    }
    
    public int getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }

     @Override
    public String toString() {//addd
        return rent_id + "|" + owner_id + "|" + place + "|" + price_for_sell + "|" + price_for_rent + "|" + num_of_room + "|" + date + "|" + rate + "|" + area + "|" + description ;
    }
   
   
    

   
}

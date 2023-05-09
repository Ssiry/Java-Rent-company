
package rentalmangementcompany;

public class Favourite {

 
    private int favourite_id;
    private int customer_id;
    private int rent_id;
    
    public Favourite(int favourite_id, int customer_id, int rent_id) {
        this.favourite_id = favourite_id;
        this.customer_id = customer_id;
        this.rent_id = rent_id;
    }
    
       public int getFavourite_id() {
        return favourite_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getRent_id() {
        return rent_id;
    }

    @Override
    public String toString() {
        return  favourite_id + "|" + customer_id + "|" + rent_id ;
    }
    
   
    
}

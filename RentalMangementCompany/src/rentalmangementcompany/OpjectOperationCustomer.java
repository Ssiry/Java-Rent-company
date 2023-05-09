
package rentalmangementcompany;

import java.util.ArrayList;


public interface OpjectOperationCustomer {
    public boolean addToFavourite(int customer_id,int rent_id);
    public ArrayList<Favourite> viewFavourites();
    public boolean removeFromFavourite(int rent_id);
    public boolean rentRent(Rent rent, int customerId,String endDay) ;
    
}

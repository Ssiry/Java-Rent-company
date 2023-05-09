
package rentalmangementcompany;

import java.util.ArrayList;


public interface ObjectOperationOwner {
    
    public boolean addRent(Rent rent);
    public boolean updateRent(int IDRent,Rent rent);
    public boolean deletRent(int IDRent);
    public ArrayList<Rent> viewRents(int owner_id);
 
}

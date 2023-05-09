
package rentalmangementcompany;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author hassanassiry
 */
public class OperrationRent {

    public ArrayList<Rent> viewRents() {
                File rentFile = new File("rent.txt");// to use file to rent ojects
                 ArrayList<Rent> listRents = new ArrayList<Rent>();// to create list of rent ojects
         try {
             Scanner read=new Scanner(rentFile);//read all rent spechile owner
             while(read.hasNext()){
                 String[] arrayrent=read.nextLine().split("\\|");// to splite rent.toString()
                    int rent_id=Integer.valueOf(arrayrent[0]);
                    int owner_id = Integer.valueOf(arrayrent[1]);
                    String place = arrayrent[2];
                    double price_for_sell = Double.valueOf(arrayrent[3]);
                    double price_for_rent = Double.valueOf(arrayrent[4]);
                    int num_of_room = Integer.valueOf(arrayrent[5]);
                    String date = arrayrent[6];
                    int rate = Integer.valueOf(arrayrent[7]);
                    float area = Float.valueOf(arrayrent[8]);
                    String description= arrayrent[9]; 
                   
                    Rent rentOwner = new Rent(rent_id, owner_id, place, price_for_sell, price_for_rent, num_of_room, date, rate, area, description);
                    listRents.add(rentOwner);
                
             }
         } catch (Exception ex) {
             System.out.println("error in viewRent"+ex);
         }
        return listRents;
    }
   
    ArrayList<Rent> sortByRate()
    {
        ArrayList<Rent> rentlist=viewRents();
        int sizelist = rentlist.size();
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < sizelist-1; i++)
        {
            // Find the minimum element in unsorted array
            int max_idx = i;
            for (int j = i+1; j < sizelist; j++){
                if (rentlist.get(j).getRate() > rentlist.get(max_idx).getRate()){
                    max_idx = j;
                }
            }
            // Swap the found minimum element with the first
            Rent temp = rentlist.get(max_idx);
            rentlist.set(max_idx,rentlist.get(i));
            rentlist.set(i,temp);
        }
        return rentlist;
    }
     ArrayList<Rent> sortByPriceHighToLow()
    {
        ArrayList<Rent> rentlist = viewRents();
        int sizelist = rentlist.size();
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < sizelist-1; i++)
        {
            // Find the minimum element in unsorted array
            int max_idx = i;
            for (int j = i+1; j < sizelist; j++){
                if (rentlist.get(j).getPrice_for_rent() > rentlist.get(max_idx).getPrice_for_rent()){
                    max_idx = j;
                }
            }
            // Swap the found minimum element with the first
            // element
            Rent temp = rentlist.get(max_idx);
            rentlist.set(max_idx,rentlist.get(i));
            rentlist.set(i,temp);
        }
        return rentlist;
    }
     ArrayList<Rent> sortByPriceLowToHigh()
    {
          ArrayList<Rent> rentlist = viewRents();
        int sizelist = rentlist.size();
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < sizelist-1; i++)
        {
            // Find the minimum element in unsorted array
            int max_idx = i;
            for (int j = i+1; j < sizelist; j++){
                if (rentlist.get(j).getPrice_for_rent() < rentlist.get(max_idx).getPrice_for_rent()){
                    max_idx = j;
                }
            }
            // Swap the found minimum element with the first
            // element
            Rent temp = rentlist.get(max_idx);
            rentlist.set(max_idx,rentlist.get(i));
            rentlist.set(i,temp);
        }
        return rentlist;
    }


}

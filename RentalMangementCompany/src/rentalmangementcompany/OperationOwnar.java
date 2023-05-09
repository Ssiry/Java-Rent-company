
package rentalmangementcompany;

import java.io.*;
import java.util.*;

public class OperationOwnar implements ObjectOperationOwner {

    private File rentFile = new File("rent.txt");// path or create 
    private ArrayList<Rent> rentOwnerList = new ArrayList<Rent>();
     private static OperrationRent operrationRent = new OperrationRent(); // Create Obj to use fuction viewRent() return ArrayLinst<Rent>

    @Override
    public boolean addRent(Rent rent) {
        try {
            rentOwnerList = operrationRent.viewRents();
            PrintWriter write = new PrintWriter(rentFile);// input data into rentfile
            for (Rent rent1 : /*allRent*/rentOwnerList) { // to store old rent data
                write.println(rent1);
            }
            write.println(rent);//Store new rent in file RentFile
            write.close();
            //  System.out.println("the Rent added successfully .");
            return true;

        } catch (Exception ex) {

            System.out.println("we cannot add Rent");
            return false;
        }

    }

    @Override
    public boolean updateRent(int IDRent, Rent rent) {
        
        if (deletRent(IDRent)==true){
            if(addRent(rent) == true) {
            System.out.println("the Rent successfully updated");
                       return true;
            }else{
                return false;
            }
        } 
        else {
            return false;
        }
   }

    @Override
    public boolean deletRent(int IDRent) {
        ArrayList<Rent> listRentDelet=operrationRent.viewRents();

         try {
              PrintWriter write = new PrintWriter(rentFile);// input data into rentfile
          int index=0;
             for (Rent rent : listRentDelet) {// this for each doing check the rent_id
            if (IDRent == rent.getRent_id()) {// do not delete all data 
                listRentDelet.remove(index);
                break;
            }// only data that we want
            index++;
        }
            for (Rent rent1 : /*allRent*/listRentDelet) { // to store old rent data
                write.println(rent1);
            }
        
            write.close();
            //  System.out.println("the Rent added successfully .");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public ArrayList<Rent> viewRents(int owner_id) {
        rentOwnerList.clear();
        try {
            Scanner read = new Scanner(rentFile);//read all rent to one owner
            while (read.hasNext()) {
                String rentLine = read.nextLine();
                String[] arrayrent = rentLine.split("\\|");//to split and store in array 
                int Owner_id = Integer.valueOf(arrayrent[1]);
                if (Owner_id == owner_id) {
                    int rent_id = Integer.valueOf(arrayrent[0]);
                    String place = arrayrent[2];
                    double price_for_sell = Double.valueOf(arrayrent[3]);
                    double price_for_rent = Double.valueOf(arrayrent[4]);
                    int num_of_room = Integer.valueOf(arrayrent[5]);
                    String date = arrayrent[6];
                    int rate = Integer.valueOf(arrayrent[7]);
                    float area = Float.valueOf(arrayrent[8]);
                    String description = arrayrent[9];

                    Rent rentOwner = new Rent(rent_id, owner_id, place, price_for_sell, price_for_rent, num_of_room, date, rate, area, description);
                    rentOwnerList.add(rentOwner);
                } /*else {
                }*/

            }
        } catch (FileNotFoundException ex) {
            System.out.println("error to show");
        }
        return rentOwnerList;
    }

 
}

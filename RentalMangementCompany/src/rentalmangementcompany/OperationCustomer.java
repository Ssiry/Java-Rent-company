package rentalmangementcompany;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationCustomer implements OpjectOperationCustomer {

    int Customer_id;
    int Rent_id;
   
    //arrayList creating
    private ArrayList<Contract> contractList = new ArrayList<>();
    private ArrayList<Rent> listRents = new ArrayList<Rent>();// to create list of rent ojects
    private ArrayList<Favourite> listFavourites = new ArrayList<>();// to create list of favourite ojects
    // file creating
    static File rentFile = new File("rent.txt");// to use file to rent ojects
    static File fileFavourite = new File("favourite.txt");// to create file to favourites ojects
    static File ContractFile = new File("contract.txt");
    
    public int getCustomer_id() {
        return Customer_id;
    }

    public int getRent_id() {
        return Rent_id;
    }
    @Override
    public boolean addToFavourite(int customer_id, int rent_id) {
        try {
            boolean check=true;
            listFavourites.clear();
            Scanner scanner = new Scanner(fileFavourite);
                while (scanner.hasNext()) { 

                String[] FavouriteArray=scanner.nextLine().split("\\|");

                 
                     int idRent=Integer.valueOf(FavouriteArray[0]);
                     int customerId=Integer.valueOf(FavouriteArray[1]);
                     int OwnerId=Integer.valueOf(FavouriteArray[2]);
                     Favourite favourite=new Favourite(idRent,customerId,OwnerId);
                      listFavourites.add(favourite);
            }
            scanner.close();

            PrintWriter AddFavourite = new PrintWriter(fileFavourite);// to intialize writer 
            for(Favourite favourite1:listFavourites){
                if(rent_id==favourite1.getRent_id())
                    check=false;
                 AddFavourite.println(favourite1);//to write the new fav object 
            }
            if (check==false) {
                System.out.println("Rent is exist in Favourite");
                return false;
            }else{
             int newFavouriteID = new Random(System.currentTimeMillis()).nextInt(999999);// return last idFav and plust 1
           Favourite favourite = new Favourite(newFavouriteID, customer_id, rent_id);// to add new object of favourite
           AddFavourite.println(favourite);
            AddFavourite.close();// to close writer after wrtting
            return true;
            }
        
        } catch (Exception e) {
            System.out.println("Error in adding Rent to favourite");
            return false;
        }
    }

    @Override
    public ArrayList<Favourite> viewFavourites() {
        try {
            listFavourites.clear();
            Scanner getDataFavouriteCustomer = new Scanner(fileFavourite);
            while (getDataFavouriteCustomer.hasNext()) {
                String favouriteString = getDataFavouriteCustomer.nextLine();
                String[] arrayfavourite = favouriteString.split("\\|");// to split and store string date in arrayFavourite
                int favouriteId = Integer.valueOf(arrayfavourite[0]);//to custing data to the right value
                int customerId = Integer.valueOf(arrayfavourite[1]);//to custing data to the right value
                int rentId = Integer.valueOf(arrayfavourite[2]);//to custing data to the right value
                    listFavourites.add(new Favourite(favouriteId, customerId, rentId));//to store favourite data if it's customer_id == prameters's coustemr_id
            }
            getDataFavouriteCustomer.close();
        } catch (Exception e) {
            System.out.println("Error to view favourite Rents");//to check error

        }
        return listFavourites;
    }

    @Override
    public boolean removeFromFavourite(int rent_id) {
          ArrayList<Favourite> listFavourites=viewFavourites();

         try {
              PrintWriter write = new PrintWriter(fileFavourite);
              int i=0;
             for (Favourite favourite : listFavourites) {
            if (rent_id == favourite.getRent_id()) {
                listFavourites.remove(i);
                
            }// only data that we want
            i++;
        }
            for (Favourite rent1 : listFavourites) {
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
    public boolean rentRent(Rent rent, int customerId,String endDay) {
        try {
           int fee_=4;
            Scanner scanner = new Scanner(ContractFile);
            while (scanner.hasNext()) { 
                String[] ContractArray=scanner.nextLine().split("\\|");
                     int contract_id=Integer.valueOf(ContractArray[0]);
                     int owner_id=Integer.valueOf(ContractArray[1]);
                     int customer_id=Integer.valueOf(ContractArray[2]);
                     int rent_id=Integer.valueOf(ContractArray[3]);
                     String feesss=ContractArray[4];
                     String start_day=ContractArray[5];
                     Contract contract;
                     contract=new Contract(contract_id, owner_id, customer_id, rent_id, 4, start_day, "");
                      contractList.add(contract);
            }
            scanner.close();
            PrintWriter printWriter=new PrintWriter(ContractFile);
            for(Contract contract:contractList)
                printWriter.println(contract);
            LocalDate localDate = LocalDate.now(); // Create a date object
            Contract newConract=new Contract(new Random(System.currentTimeMillis()).nextInt(999999), rent.getOwner_id(), customerId,  rent.getRent_id(),fee_, (""+localDate.toString()), endDay);
            printWriter.println(newConract);
            printWriter.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }

} 


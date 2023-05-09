package rentalmangementcompany;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class RentalMangementCompany {

    static int Rent_id;
    static int Rent_id1;
    static Scanner input = new Scanner(System.in);
    static String Name = "";
    static String Email_SignIn_Customer = "";
    static String Name1 = "";
    static String Email1 = "";
    static String Password = "";
    static String Password1 = "";
    static String Email2 = "";
    static String Password_SignIn_Customer = "";
    static int Age = 0;
    static int Id_card = 0;
    static int Phone = 0;
    static String City = "";
    static int Age1 = 0;
    static int Id_card1 = 0;
    static int Phone1 = 0;
    static String City1 = "";
    static Sign sign = new Sign();
    static Owner owner;
    static Customer customer;
    static Rent rent;
    static File RentFile = new File("rent.txt");
    static File CustomerFile = new File("customer.txt");
    static File OwnerFile = new File("owner.txt");
    static OperrationRent operrationRent = new OperrationRent();
    static File ContractFile = new File("contract.txt");
    static File fileFavourite = new File("favourite.txt");// to create file to favourites ojects

    public static void main(String[] args) throws IOException {

        CustomerFile.createNewFile();// create new File in Package
        OwnerFile.createNewFile();// create new File in Package
        ContractFile.createNewFile();// create new File in Package
        fileFavourite.createNewFile();// create new File in Package
        System.out.println("Welcome in Rentology Aswan Company \n -------------------------\nChoose \n1_To Enter As Owner \n2_To Enter As Customer\n->");
        int choose_Owner_Or_Customer = input.nextInt();

        while (choose_Owner_Or_Customer != 1 && choose_Owner_Or_Customer != 2) {
            System.out.println("number is not valid!!");
            System.out.print("Choose \n1_To Enter As Owner \n2_To Enter As Customer\n-> ");
            choose_Owner_Or_Customer = input.nextInt();
        }

        choose_Owner_Or_Customer(choose_Owner_Or_Customer);

    }

    public static void choose_Owner_Or_Customer(int choose_Owner_Or_Customer) {

        System.out.print("Choose \n1_To SignUP \n2_To SignIn\n-> ");
        int choose_SignIn_Or_SignUp = input.nextInt();
        while (choose_SignIn_Or_SignUp != 1 & choose_SignIn_Or_SignUp != 2) {// to limit input between (1,2)
            System.out.println("number is not valid!!");
            System.out.print("Choose \n1_To SignUP \n2_To SignIn\n-> ");
            choose_SignIn_Or_SignUp = input.nextInt();
        }
        switch (choose_Owner_Or_Customer) {// Choose Owner Or Customer
            case 1: //Owner

                switch (choose_SignIn_Or_SignUp) {
                    case 1: //SignUp Owner
                        System.out.print("Hello new Owner\nEnter Name : ");
                        Name1 = input.next();
                        System.out.print("Enter Email : ");
                        Email1 = input.next();
                        System.out.print("Enter Password : ");
                        Password1 = input.next();
                        System.out.print("Enter Age : ");
                        Age1 = input.nextInt();
                        System.out.print("Enter ID card : ");
                        Id_card1 = input.nextInt();
                        System.out.print("Enter Phone :  +201");
                        Phone1 = input.nextInt();
                        System.out.print("Enter City : ");
                        City1 = input.next();
                        Owner owner;
                        owner = new Owner(new Random(System.currentTimeMillis()).nextInt(999999),
                                Name1, Email1, Password1, Age1, Id_card1, Phone1, City1);
                        System.out.println("***************************************");
                        if (sign.ownerSignUp(owner) == true) {
                            System.out.println("Email is exists Or error please try agein ");
                        } else {

                            System.out.println("Email is Created Successfuly");
                        }
                        System.out.println("***************************************");
                        break;

                    case 2: //SignIn owner
                        boolean check_signIn_owner = false;
                        while (check_signIn_owner == false) {
                            System.out.print("Enter Email : ");
                            Email1 = input.next();
                            System.out.print("Enter Password : ");
                            Password1 = input.next();

                            if (sign.SignInOwner(Email1, Password1) == true) {
                                check_signIn_owner = true;
                                break;
                            } else {
                                System.out.println("TRY AGAIN !!");
                            }
                        }

                        if (check_signIn_owner == true) {
                            show_OptionOwner();
                        }

                        break;
                    default:

                        System.out.println("Error in owner signIn");
                }
                break;

            case 2://Customer

                switch (choose_SignIn_Or_SignUp) {

                    case 1: //SignUp Customer
                        System.out.print("Hello new Customer\nEnter Name : ");
                        Name = input.next();
                        System.out.print("Enter Email : ");
                        Email_SignIn_Customer = input.next();
                        System.out.print("Enter Password : ");
                        Password = input.next();
                        System.out.print("Enter Age : ");
                        Age = input.nextInt();
                        System.out.print("Enter ID card : ");
                        Id_card = input.nextInt();
                        System.out.print("Enter Phone :  +201");
                        Phone = input.nextInt();
                        System.out.print("Enter City : ");
                        City = input.next();

                        Customer customer1;
                        customer1 = new Customer(new Random(System.currentTimeMillis()).nextInt(999999), Name, Email_SignIn_Customer, Password, Age, Id_card, Phone, City);
                        System.out.println("------------");
                        if (sign.customerSignUp(customer1) == true) {
                            System.out.println("Email is exists Or error please try agein ");
                        } else {
                            System.out.println("Email is Created Successfuly");
                            show_OptionCustomer();
                        }
                        System.out.println("------------");
                        break;

                    case 2: //SignIn Customer
                        boolean check_signIn_customer = false;
                        while (check_signIn_customer == false) {
                            System.out.print("Enter Email : ");
                            Email_SignIn_Customer = input.next();
                            System.out.print("Enter Password : ");
                            Password_SignIn_Customer = input.next();
                            if (sign.SignInCustomer(Email_SignIn_Customer, Password_SignIn_Customer) == true) {//to check customer exist and break if it true
                                check_signIn_customer = true;
                                int index = 1;
                                System.out.println("what are you doing today!!");
                                System.out.println("-------------------");
                                System.out.println("All Rent....");
                                System.out.println("-------------------");
                                show_OptionCustomer();
                                break;
                            } else {
                                System.out.println("TRY AGAIN!!");
                            }
                        }
                        break;
                    default:
                        System.out.println("error to choose owner or customer");
                }
            default:
        }

    }

    public static void show_OptionOwner() {
        OperationOwnar operationOwnar = new OperationOwnar();
        int ownerChooseOperation = 0;

        while (ownerChooseOperation != 1 && ownerChooseOperation != 2 && ownerChooseOperation != 3) {
            int index = 1;
            ArrayList<Rent> rentList = operationOwnar.viewRents(sign.getIdOwner());
            for (Rent rent : rentList) {
                System.out.println(index++ + ")" + " Place : " + rent.getPlace() + " ,Price : " + rent.getPrice_for_rent()
                        + " , Rate : " + rent.getRate() + " ,Room : " + rent.getNum_of_room() + " ,Date : " + rent.getDate());
                System.out.println("------------------------------");

            }
            System.out.println("------------------------------");
            System.out.println("1_Add Rent\n2_Update Rent\n3_Remove Rent");
            System.out.print("Enter number : ");
            ownerChooseOperation = input.nextInt();

            switch (ownerChooseOperation) {

                case 1://add rent
                    System.out.print("Enter Rent Place : ");
                    String place = input.next();
                    System.out.print("Enter price for Rent : ");
                    double price = input.nextDouble();
                    System.out.print("Enter number of Rooms : ");
                    int number_of_room = input.nextInt();
                    LocalDate localDate = LocalDate.now(); // Create a date object
                    System.out.print("Enter Rent Rate : ");
                    int rate = input.nextInt();
                    while (rate < 1 || rate > 5) {// to limit rate 1..5
                        System.out.print("Enter Rent Rate : ");
                        rate = input.nextInt();
                    }
                    System.out.print("Enter Rent Area : ");
                    float area = input.nextFloat();
                    System.out.print("Enter Rent Description : ");
                    String description = input.next();
                    // create object to store it into add rent 
                    rent = new Rent(new Random(System.currentTimeMillis()).nextInt(999999), sign.getIdOwner(), place, 30000.0, price, number_of_room, localDate.toString(), rate, area, description);
                    operationOwnar.addRent(rent);
                    System.out.println("RENT SUCCESSFULY ADDED");
                    break;
                case 2://update rent
                    System.out.print("Enter number to update : ");
                    int indexnuberToUpdateFromListRent = input.nextInt();
                    System.out.print("Enter Rent Place : ");
                    String place_update = input.next();
                    System.out.print("Enter price for Rent : ");
                    double price_update = input.nextDouble();
                    System.out.print("Enter number of Rooms : ");
                    int number_of_room_update = input.nextInt();
                    LocalDate localDate_update = LocalDate.now(); // Create a date object
                    System.out.print("Enter Rent Rate : ");
                    int rate_update = input.nextInt();
                    while (rate_update < 1 || rate_update > 5) {// to limit rate 1..5
                        System.out.print("Enter Rent Rate : ");
                        rate_update = input.nextInt();
                    }
                    System.out.print("Enter Rent Area : ");
                    float area_update = input.nextFloat();
                    System.out.print("Enter Rent Description : ");
                    String description_update = input.next();
                    // create object to store it into add rent 
                    Rent rent_Update = new Rent(new Random(System.currentTimeMillis()).nextInt(999999), sign.getIdOwner(), place_update, 30000.0, price_update, number_of_room_update, localDate_update.toString(), rate_update, area_update, description_update);

                    int rentId = operrationRent.viewRents().get(indexnuberToUpdateFromListRent - 1).getRent_id();

                    if (operationOwnar.updateRent(rentId, rent_Update) == true) {
                        System.out.println("RENT SUCCESSFULY UPDATED");
                    } else {
                        System.out.println("Rent not Updated!!");
                    }
                    break;
                case 3:// Remove rent
                    int index_delete_rent;
                    System.out.print("Enter number of Rent to remove : ");
                    index_delete_rent = input.nextInt();
                    if (operrationRent.viewRents().isEmpty()) {
                        System.out.println("Not Found Any Rent!!");
                        System.out.println("*********************");
                    } else {
                        int rentID_toRemove = operrationRent.viewRents().get(index_delete_rent - 1).getRent_id();

                        if (operationOwnar.deletRent(rentID_toRemove) == true) {
                            System.out.println("RENT SUCCESSFULY DELETED");
                        } else {
                            System.out.println("Rent not Deleted!!");
                        }
                    }
                    break;
                default:
            }
            ownerChooseOperation = 0;
        }
    }

    public static void show_OptionCustomer() {
        int index = 1;

        for (Rent rent : operrationRent.viewRents()) {
            System.out.println("------------------------------");
            System.out.println(index++ + ")" + " Place : " + rent.getPlace() + " ,Price : " + rent.getPrice_for_rent()
                    + " , Rate : " + rent.getRate() + " ,Room : " + rent.getNum_of_room() + " ,Date : " + rent.getDate());
            System.out.println("------------------------------");

        }

        OperrationRent operrationRent = new OperrationRent();
        OperationCustomer operationCustomer = new OperationCustomer();

        int choose_number = 0;

        while (choose_number != 5) {
            System.out.println("*********************************");
            System.out.println("Choose\n1_Rent Rent\n2_View Favourite List\n3_Add Favourite\n4_To sort\n5_LogOut");
            System.out.print("Choose Number : ");
            choose_number = input.nextInt();
            if (choose_number == 5) {
                System.out.println("LogOut");
                break;
            } else {
                switch (choose_number) {

                    case 1: //Rent Rent
                        System.out.print("Enter number Rent : ");
                        int indexRent = input.nextInt();
                        while (indexRent < 1 & operrationRent.viewRents().size() <= indexRent) {
                            System.out.println("number is mistake try again!!");
                            System.out.print("Enter number Rent : ");
                            indexRent = input.nextInt();
                        }
                        System.out.print("Enter End Day Rent : ");
                        String endDay = input.next();
                        Rent rent = operrationRent.viewRents().get(indexRent - 1);
                        if (operationCustomer.rentRent(rent, sign.getIdCustomer(), endDay)) {

                            System.out.println("Rented!!");

                        }
                        break;
                    case 2://View Favourite
                        if (operationCustomer.viewFavourites().isEmpty()) {
                            System.out.println("Not Found Any Favourite Rent");
                        } else {
                            int indexFav = 1;
                            for (Favourite Fav : operationCustomer.viewFavourites()) {
                                if (Fav.getCustomer_id() == sign.getIdCustomer()) {
                                    for (Rent rentFav : operrationRent.viewRents()) {
                                        if (Fav.getRent_id() == rentFav.getRent_id()) {
                                            System.out.println("------------------------------");
                                            System.out.println(indexFav++ + ")" + " Place : " + rentFav.getPlace() + " ,Price : " + rentFav.getPrice_for_rent()
                                                    + " , Rate : " + rentFav.getRate() + " ,Room : " + rentFav.getNum_of_room() + " ,Date : " + rentFav.getDate());
                                            System.out.println("------------------------------");
                                            break;

                                        }
                                    }
                                }
                            }
                            System.out.println("Do You Want Remove Any Favourite Rent?\n1_Yes\n2_No");
                            System.out.print("->> ");
                            int checkremove = input.nextInt();
                            if (checkremove == 1) {

                                System.out.print("Enter number Rent : ");
                                int numberremove = input.nextInt();
                                operationCustomer.removeFromFavourite(operrationRent.viewRents().get(numberremove - 1).getRent_id());

                                while (numberremove < 1 & operrationRent.viewRents().size() <= numberremove) {
                                    System.out.println("number is mistake try again!!");
                                    System.out.print("Enter Number You want to remove : ");
                                    numberremove = input.nextInt();
                                    operationCustomer.removeFromFavourite(operrationRent.viewRents().get(numberremove - 1).getRent_id());
                                    System.out.println("Rent removed from Favourite!!");
                                    System.out.println("***********************************");
                                }
                            }
                        }

                        break;
                    case 3://Add Favourite

                        System.out.print("Enter number Rent : ");
                        int indexRentFav = input.nextInt();
                        while (indexRentFav < 1 & operrationRent.viewRents().size() < indexRentFav) {
                            System.out.println("number is mistake try again!!");
                            System.out.print("Enter number Rent : ");
                            indexRentFav = input.nextInt();
                        }
                        boolean checkaddFavRent = operationCustomer.addToFavourite(sign.getIdCustomer(),
                                operrationRent.viewRents().get(indexRentFav - 1).getRent_id());
                        if (checkaddFavRent == true) {
                            System.out.println("Add Fav Succesful");
                        }

                        break;

                    case 4:
                        int index1 = 1;
                        System.out.println("Enter\n1_To sort by Rate\n2_To sort by Price from High to Low\n3_To sort by price from Low to High");
                        int sort_choose = input.nextInt();
                        while (sort_choose < 1 || sort_choose > 3) {
                            System.out.println("1_To sort by Rate\n2_To sort by Price from High to Low\n3_To sort by price from Low to High");
                            sort_choose = input.nextInt();
                        }
                        switch (sort_choose) {
                            case 1:
                                int Index4 = 0;
                                int counter = 1;
                                operrationRent.sortByRate();
                                for (Rent rent1 : operrationRent.viewRents()) {
                                    System.out.println("------------------------------");
                                    System.out.println((counter) + ")" + " Place : " + operrationRent.sortByRate().get(Index4).getPlace() + " ,Price : " + operrationRent.sortByRate().get(Index4).getPrice_for_rent()
                                            + " , Rate : " + operrationRent.sortByRate().get(Index4).getRate() + " ,Room : " + operrationRent.sortByRate().get(Index4).getNum_of_room() + " ,Date : " + operrationRent.sortByRate().get(Index4).getDate());
                                    Index4++;
                                    counter++;
                                    System.out.println("------------------------------");
                                }
                                break;
                            case 2:
                                int counter2 = 1;
                                int Index2 = 0;
                                operrationRent.sortByPriceHighToLow();
                                for (Rent rent2 : operrationRent.viewRents()) {
                                    System.out.println("------------------------------");
                                    System.out.println((counter2) + ")" + " Place : " + operrationRent.sortByRate().get(Index2).getPlace() + " ,Price : " + operrationRent.sortByRate().get(Index2).getPrice_for_rent()
                                            + " , Rate : " + operrationRent.sortByRate().get(Index2).getRate() + " ,Room : " + operrationRent.sortByRate().get(Index2).getNum_of_room() + " ,Date : " + operrationRent.sortByRate().get(Index2).getDate());
                                    Index2++;
                                    counter2++;
                                    System.out.println("------------------------------");
                                }
                                break;
                            case 3:
                                int Index3 = 0;
                                int counter3 = 1;
                                operrationRent.sortByPriceLowToHigh();
                                for (Rent rent3 : operrationRent.viewRents()) {
                                    System.out.println("------------------------------");
                                    System.out.println((counter3) + ")" + " Place : " + operrationRent.sortByRate().get(Index3).getPlace() + " ,Price : " + operrationRent.sortByRate().get(Index3).getPrice_for_rent()
                                            + " , Rate : " + operrationRent.sortByRate().get(Index3).getRate() + " ,Room : " + operrationRent.sortByRate().get(Index3).getNum_of_room() + " ,Date : " + operrationRent.sortByRate().get(Index3).getDate());
                                    Index3++;
                                    counter3++;
                                    System.out.println("------------------------------");
                                }
                                break;
                            default:
                             
                        }
                        break;

                    default:
                        choose_number = 0;

                }
            }

        }
    }

}

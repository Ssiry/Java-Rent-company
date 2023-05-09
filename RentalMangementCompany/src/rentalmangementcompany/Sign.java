
package rentalmangementcompany;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Sign {

   File CustomerFile = new File("customer.txt");
   File OwnerFile = new File("owner.txt");

    private Customer customer;
    private Owner owner;
    private static int Id_Owner;
    private static int Id_Customer;
    
    
    public boolean SignInCustomer(String Email, String Password) {
        boolean checkSign = false;
        try {
            Scanner readCustomerData = new Scanner(CustomerFile);
            
            while (readCustomerData.hasNext()) {
                
                String[] customer_data = readCustomerData.nextLine().split("\\|");
                
                int cutomer_id = Integer.valueOf(customer_data[0]);
                String name = customer_data[1];
                String e_mail = customer_data[2];
                String password = customer_data[3];
                int age = Integer.valueOf(customer_data[4]);
                int idCard = Integer.valueOf(customer_data[5]);
                int phone = Integer.valueOf(customer_data[6]);
                String city = customer_data[7];
                if (Email.equals(e_mail) && Password.equals(password)) {
                System.out.println("*---------------------*\nWElCOME "+name.toUpperCase());
                checkSign = true;
                Id_Customer = cutomer_id;
                    break;
                }
            }
            
             if (checkSign==true) {
                return true;
            }else{
                 return false;
                 }
        } catch (Exception e) {
            System.out.println("you are robot");
        }
           return checkSign;
    }

    public boolean SignInOwner(String Email, String Password) {
        boolean checkSign = false;
        try {
            Scanner readOwnerData = new Scanner(OwnerFile);
                     
            while (readOwnerData.hasNext()) {
                
                String[] owner_data = readOwnerData.nextLine().split("\\|");
                int owner_id = Integer.valueOf(owner_data[0]);
                String name = owner_data[1];
                String e_mail = owner_data[2];
                String password = owner_data[3];
                int age = Integer.valueOf(owner_data[4]);
                int idCard = Integer.valueOf(owner_data[5]);
                int phone = Integer.valueOf(owner_data[6]);
                String city = owner_data[7];
                
                if (Email.equals(e_mail) && Password.equals(password)) {
                System.out.println("     *---------------------*\n         WElCOME "+name.toUpperCase());
                checkSign = true;
                Id_Owner=owner_id;
                    break;
                }

            }
                 if (checkSign==true) {
                     
                return true;
            }else{
                 return false;
                 }
        } 
        catch (Exception e) {
            System.out.println("error in login owner");
            return false;
        }
    }

    public boolean customerSignUp(Customer customer) {
            ArrayList<Customer> customerList=new ArrayList<Customer>();
        try {
            boolean checkcondtion1 = false;
            Scanner readCustomerData = new Scanner(CustomerFile);
            while (readCustomerData.hasNext()) {
                String[] customer_data = readCustomerData.nextLine().split("\\|");
                int cutomer_id = Integer.valueOf(customer_data[0]);
                String name = customer_data[1];
                String e_mail = customer_data[2];
                String password = customer_data[3];
                int age = Integer.valueOf(customer_data[4]);
                int idCard = Integer.valueOf(customer_data[5]);
                int phone = Integer.valueOf(customer_data[6]);
                String city = customer_data[7];
                customerList.add(new Customer(cutomer_id,name,e_mail,password,age,idCard,phone,city));
            if (customer.getE_mail().equals(e_mail)) 
                {
                    checkcondtion1 = true;
                    break;
                } else {
                    checkcondtion1 = false;
                }
            }
             if (checkcondtion1==true) {
                System.out.println("error , User is exist");
                return true;
            } else {
                PrintWriter customerwriter = new PrintWriter(CustomerFile);
                for(Customer customerObject : customerList){
                    customerwriter.println(customerObject);// save old data customer
                }
                customerwriter.println(customer);// Save new Data Customer when SignUp

                customerwriter.close();
                return false; 
            }
             
        } catch (Exception e) {
            System.out.println("error in singup check customer data");
            return false;
        }

    }

    public boolean ownerSignUp(Owner owner) {
        ArrayList<Owner> listOwner = new ArrayList<>();
        try {
            boolean checkcondtion = false;
            Scanner readOwnerData = new Scanner(OwnerFile);
            while (readOwnerData.hasNext()) {
                String[] owner_data = readOwnerData.nextLine().split("\\|");
                int owner_id = Integer.valueOf(owner_data[0]);
                String name = owner_data[1];
                String e_mail = owner_data[2];
                String password = owner_data[3];
                int age = Integer.valueOf(owner_data[4]);
                int idCard = Integer.valueOf(owner_data[5]);
                int phone = Integer.valueOf(owner_data[6]);
                String city = owner_data[7];
                listOwner.add(new Owner(owner_id,name, e_mail, password, age, idCard, phone, city));
                if (owner.getE_mail().equals(e_mail)) 
                {
                    checkcondtion = true;
                    break;
                } 
                else {
                    checkcondtion = false;
                }
            }
            if (checkcondtion==true) {// the person is already exist
                System.out.println("ERROR, USER IS ALREADY EXIST");
                    return true;
            } else {// the person is not exist
                PrintWriter ownerWriter = new PrintWriter(OwnerFile);
                 for(Owner ownerObject : listOwner){
                     ownerWriter.println(ownerObject);
                 }
                ownerWriter.println(owner);
                ownerWriter.close();
                   return false;
            }
               
            ///*************************
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public int getIdOwner(){
        return Id_Owner;
    }
    public int getIdCustomer(){
        return Id_Customer;
    }
}

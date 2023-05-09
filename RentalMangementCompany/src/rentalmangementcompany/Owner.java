
package rentalmangementcompany;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Owner extends ParentClass {
    private  int owner_id;
    
    public Owner(String name, String e_mail, String passowrd, int age, int id_card, int phone, String city) {
        super(name, e_mail, passowrd, age, id_card, phone, city);
    }

    public Owner(int owner_id, String name, String e_mail, String passowrd, int age, int id_card, int phone, String city) {
        super(name, e_mail, passowrd, age, id_card, phone, city);
        this.owner_id = owner_id;
    }

    public String getName() {
        return name;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public int getAge() {
        return age;
    }

    public int getId_card() {
        return id_card;
    }

    public int getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }
    
    public int getOwner_id() {
        return owner_id;
    }

    @Override
    public String toString() {
        return  owner_id + "|" + name + "|" + e_mail + "|" + passowrd + "|" + age + "|" + id_card + "|" + phone + "|" + city;
    }
     


   
 



  
    
}

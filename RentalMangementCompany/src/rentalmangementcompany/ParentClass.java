
package rentalmangementcompany;


public class ParentClass {

     
   protected String name;
   protected String e_mail;
   protected String passowrd;
   protected int age;
   protected int id_card;
   protected int phone;
   protected String city;
    
   public ParentClass(String name, String e_mail, String passowrd, int age, int id_card, int phone,String city) {
        this.name = name;
        this.e_mail = e_mail;
        this.passowrd = passowrd;
        this.age = age;
        this.id_card = id_card;
        this.phone = phone;
        this.city = city;
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
}



package rentalmangementcompany;

public class Customer extends ParentClass{
      
    private int  customer_id;
    
    public Customer(int customer_id, String name, String e_mail, String passowrd, int age, int id_card, int phone, String city) {
        super(name, e_mail, passowrd, age, id_card, phone, city);
        this.customer_id = customer_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    @Override
    public String toString() {
        return  customer_id + "|" + name + "|" + e_mail + "|" + passowrd + "|" + age + "|" + id_card + "|" + phone + "|" + city;
    }
 
}

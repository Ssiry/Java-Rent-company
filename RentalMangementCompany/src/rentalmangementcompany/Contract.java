
package rentalmangementcompany;

import java.time.LocalDate;

public class Contract {
    private int contract_id;
    private int owner_id;
    private int customer_id;
    private int rent_id;
    private int fee;
    private String start_day;
    private String end_day;
    
    public Contract(int contract_id, int owner_id, int customer_id, int rent_id, int fee, String start_day, String end_day) {
        this.contract_id = contract_id;
        this.owner_id = owner_id;
        this.customer_id = customer_id;
        this.rent_id = rent_id;
        this.fee = fee;
        this.start_day = start_day;
        this.end_day = end_day;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getRent_id() {
        return rent_id;
    }

    public void setRent_id(int rent_id) {
        this.rent_id = rent_id;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getStart_day() {
        return start_day;
    }

    public void setStart_day(String start_day) {
        this.start_day = start_day;
    }

    public String getEnd_day() {
        return end_day;
    }

    public void setEnd_day(String end_day) {
        this.end_day = end_day;
    }

    @Override
    public String toString() {
        return contract_id + "|" + owner_id + "|"+ rent_id+"|"+fee+"|"+ start_day +"|"+end_day;
    }
}

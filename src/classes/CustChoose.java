package classes;

public class CustChoose {
    private String credit_card_no;
    private String transaction_type;
    private double transaction_value;

    public CustChoose(String credit_card_no, String transaction_type, double transaction_value){
        this.credit_card_no = credit_card_no;
        this.transaction_type = transaction_type;
        this.transaction_value = transaction_value;
    }

    public String getCredit_card_no() {
        return credit_card_no;
    }

    public void setCredit_card_no(String credit_card_no) {
        this.credit_card_no = credit_card_no;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public double getTransaction_value() {
        return transaction_value;
    }

    public void setTransaction_value(double transaction_value) {
        this.transaction_value = transaction_value;
    }
}

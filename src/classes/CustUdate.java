package classes;

public class CustUdate {
    private String first_name;
    private String middle_name;
    private String last_name;
    private int ssn;
    private String credit_card_no;
    private int apt_no;
    private String street_name;
    private String cust_city;
    private String cust_state;
    private String cust_country;
    private String zip_code;
    private String phone;
    private String email;

    public CustUdate(String first_name, String middle_name, String last_name, int ssn, String credit_card_no, int apt_no, String street_name, String cust_city, String cust_state, String cust_country, String zip_code, String phone, String email){
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.ssn = ssn;
        this.credit_card_no =credit_card_no;
        this.apt_no = apt_no;
        this.street_name = street_name;
        this.cust_city = cust_city;
        this.cust_state = cust_state;
        this.cust_country = cust_country;
        this.zip_code = zip_code;
        this.phone = phone;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getCredit_card_no() {
        return credit_card_no;
    }

    public void setCredit_card_no(String credit_card_no) {
        this.credit_card_no = credit_card_no;
    }

    public int getApt_no() {
        return apt_no;
    }

    public void setApt_no(int apt_no) {
        this.apt_no = apt_no;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCust_city() {
        return cust_city;
    }

    public void setCust_city(String cust_city) {
        this.cust_city = cust_city;
    }

    public String getCust_state() {
        return cust_state;
    }

    public void setCust_state(String cust_state) {
        this.cust_state = cust_state;
    }

    public String getCust_country() {
        return cust_country;
    }

    public void setCust_country(String cust_country) {
        this.cust_country = cust_country;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

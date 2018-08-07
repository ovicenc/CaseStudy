package classes;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Data {
    private int maxTransactions = 1000;
    private CreditCard myCreditCards[] = new CreditCard[maxTransactions];
    private int countCreditCard = 0;
    private TransType myTransType[] = new TransType[maxTransactions];
    private int countTransType = 0;
    //private String transactionType;
    private TransState myTransState[] = new TransState[maxTransactions];
    private int countTransState = 0;
    //private String transactionState;

    private int maxCustumerAccounts = 1000;
    private CustAccount myCustAccount[] = new CustAccount[maxCustumerAccounts];
    private int countCustAccount = 0;

    private int maxCustMonthlyBill = 1000;
    private CustMonthly myCustMonthlyBill[] = new CustMonthly[maxCustMonthlyBill];
    private int countCustMonthlyBill = 0;

    private int maxCustChoose = 1000;
    private CustChoose myCustChoose[] = new CustChoose[maxCustChoose];
    private int countCustChoose = 0;


    public Data(){
            //loadCreditCard(55044, 3, 2018);

        }

        public boolean validateUser(String user, String key){
            if(user.equalsIgnoreCase("admin") && key.equals("1234"))
                return true;
            else
                return false;
        }

        public void loadQueryTransByType(String transactionType){
        //this.transactionType = transactionType;
            try {
                DBConnection conn = new DBConnection();
                //PreparedStatement statement = conn.getConnection().prepareStatement("SELECT '"+transactionType+"', SUM('"+transactionType+"') AS SUM_TRANS_VALUE,  COUNT(*) AS COUNT_TRANS FROM CDW_SAPP_CREDITCARD GROUP BY '"+transactionType+"';");
                PreparedStatement statement = conn.getConnection().prepareStatement("SELECT COUNT(CDW_SAPP_CREDITCARD.TRANSACTION_VALUE), SUM(CDW_SAPP_CREDITCARD.TRANSACTION_VALUE) FROM CDW_SAPP_CREDITCARD WHERE CDW_SAPP_CREDITCARD.TRANSACTION_TYPE ='"+transactionType+"';");
                //PreparedStatement statement = conn.getConnection().prepareStatement("SELECT TRANSACTION_TYPE , SUM(TRANSACTION_VALUE) AS SUM_TRANS_VALUE,  COUNT(*) AS COUNT_TRANS FROM CDW_SAPP_CREDITCARD GROUP BY '"+transactionType+"';");
                ResultSet result = statement.executeQuery();
                TransType transType_1;

                    while(result.next()) {
                        int count_trans = result.getInt("COUNT(CDW_SAPP_CREDITCARD.TRANSACTION_VALUE)");
                        int sum_trans = result.getInt("SUM(CDW_SAPP_CREDITCARD.TRANSACTION_VALUE)");
                        System.out.println(transactionType);
                        System.out.println(count_trans);
                        System.out.println(sum_trans);
                        transType_1 = new TransType(count_trans, sum_trans);
                        myTransType[countTransType] = transType_1;
                        countTransType++;
                    }
                }catch(Exception e){
                    System.out.println(e);
            }

        }

        public int getNumberTransType(){
            return countTransType;
        }

        public TransType[] getTransType(){
            return myTransType;
        }

        public int clearTransType(){
            return countTransType=0;
        }


        public void loadAccountDetails(int customer_ss, String customer_email ){
            try {
                DBConnection conn = new DBConnection();
                PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM CDW_SAPP_CUSTOMER WHERE CDW_SAPP_CUSTOMER.SSN = '"+customer_ss+"' OR CDW_SAPP_CUSTOMER.CUST_EMAIL = '"+customer_email+"'; ");
                //PreparedStatement statement = conn.getConnection().prepareStatement("SELECT TRANSACTION_TYPE , SUM(TRANSACTION_VALUE) AS SUM_TRANS_VALUE,  COUNT(*) AS COUNT_TRANS FROM CDW_SAPP_CREDITCARD GROUP BY '"+transactionType+"';");
                ResultSet result = statement.executeQuery();
                CustAccount custAccount_1;

                while(result.next()) {
                    String first_name = result.getString("FIRST_NAME");
                    String  middle_name = result.getString("MIDDLE_NAME");
                    String  last_name = result.getString("LAST_NAME");
                    int ssn = result.getInt("SSN");
                    String  credit_card_no = result.getString("CREDIT_CARD_NO");
                    int apt_no = result.getInt("APT_NO");
                    String street_name = result.getString("STREET_NAME");
                    String cust_city = result.getString("CUST_CITY");
                    String cust_state = result.getString("CUST_STATE");
                    String cust_country = result.getString("CUST_COUNTRY");
                    int cust_zip = result.getInt("CUST_ZIP");
                    int cust_phone = result.getInt("CUST_PHONE");
                    String cust_email = result.getString("CUST_EMAIL");

                    custAccount_1 = new CustAccount(first_name, middle_name, last_name, ssn, credit_card_no, apt_no, street_name, cust_city, cust_state, cust_country, cust_zip, cust_phone, cust_email);
                    myCustAccount[countCustAccount] = custAccount_1;
                    countCustAccount++;
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }

    public int getNumberCustAccount(){
        return countCustAccount;
    }

    public CustAccount[] getCustAccount(){
        return myCustAccount;
    }

    public int clearCustAccount(){
        return countCustAccount=0;
    }



        public void loadQueryTransByState(String transactionState){
            //this.transactionType = transactionType;
            try {
                DBConnection conn = new DBConnection();
                //PreparedStatement statement = conn.getConnection().prepareStatement("SELECT '"+transactionType+"', SUM('"+transactionType+"') AS SUM_TRANS_VALUE,  COUNT(*) AS COUNT_TRANS FROM CDW_SAPP_CREDITCARD GROUP BY '"+transactionType+"';");
                PreparedStatement statement = conn.getConnection().prepareStatement("SELECT COUNT(CDW_SAPP_CREDITCARD.TRANSACTION_VALUE), SUM(CDW_SAPP_CREDITCARD.TRANSACTION_VALUE) FROM CDW_SAPP_CREDITCARD INNER JOIN CDW_SAPP_BRANCH ON CDW_SAPP_CREDITCARD.BRANCH_CODE=CDW_SAPP_BRANCH.BRANCH_CODE AND BRANCH_STATE='"+transactionState+"' GROUP BY TRANSACTION_TYPE;");
                //PreparedStatement statement = conn.getConnection().prepareStatement("SELECT TRANSACTION_TYPE , SUM(TRANSACTION_VALUE) AS SUM_TRANS_VALUE,  COUNT(*) AS COUNT_TRANS FROM CDW_SAPP_CREDITCARD GROUP BY '"+transactionType+"';");
                ResultSet result = statement.executeQuery();
                TransState transState_1;

                while(result.next()) {
                    int count_trans = result.getInt("COUNT(CDW_SAPP_CREDITCARD.TRANSACTION_VALUE)");
                    int sum_trans = result.getInt("SUM(CDW_SAPP_CREDITCARD.TRANSACTION_VALUE)");
                    System.out.println(transactionState);
                    System.out.println(count_trans);
                    System.out.println(sum_trans);
                    transState_1 = new TransState(count_trans, sum_trans);
                    myTransState[countTransState] = transState_1;
                    countTransState++;
                }
            }catch(Exception e){
                System.out.println(e);
            }


        }

        public int getNumberTransState(){
            return countTransState;
        }

        public TransState[] getTransState(){
            return myTransState;
        }

        public int clearTransState(){
            return countTransState=0;
        }


        public void loadCreditCard(int zipCode_, int month_, int year_){
            try{
                //Connection conn = getConnection();
                DBConnection conn = new DBConnection();
                PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM CDW_SAPP_CREDITCARD INNER JOIN CDW_SAPP_BRANCH ON CDW_SAPP_CREDITCARD.BRANCH_CODE = CDW_SAPP_BRANCH.BRANCH_CODE AND CDW_SAPP_BRANCH.BRANCH_ZIP='"+zipCode_+"' AND CDW_SAPP_CREDITCARD.MONTH = '"+month_+"' AND CDW_SAPP_CREDITCARD.YEAR = '"+year_+"' ORDER BY CDW_SAPP_CREDITCARD.DAY DESC;");
                ResultSet result = statement.executeQuery();
                CreditCard creditCard_1;
                //ArrayList<String> array = new ArrayList<String>();

                while(result.next()){
                    int trans_id = result.getInt("transaction_id");
                    int day = result.getInt("day");
                    int month = result.getInt("month");
                    int year = result.getInt("year");
                    String credit_card_no = result.getString("credit_card_no");
                    int cust_ssn = result.getInt("cust_ssn");
                    int branch_code = result.getInt("branch_code");
                    String trans_type = result.getString("transaction_type");
                    double trans_value = result.getDouble("transaction_value");

                    creditCard_1 = new CreditCard(trans_id, day, month, year, credit_card_no,cust_ssn, branch_code,trans_type, trans_value);
                    myCreditCards[countCreditCard] = creditCard_1;
                    countCreditCard++;

                }
                //System.out.println("All records have been selected");
            } catch(Exception e){
                System.out.println(e);
            }

        }


        public int getNumberCreditCards(){
            return countCreditCard;
        }

        public CreditCard[] getCreditCards(){
            return myCreditCards;
        }

        public int clearCreditCards(){
            return countCreditCard=0;
        }


    public void loadCustMonthlyBill(String credit_card_no, int month, int year){
        try{
            //Connection conn = getConnection();
            DBConnection conn = new DBConnection();
            //PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM CDW_SAPP_CREDITCARD INNER JOIN CDW_SAPP_BRANCH ON CDW_SAPP_CREDITCARD.BRANCH_CODE = CDW_SAPP_BRANCH.BRANCH_CODE AND CDW_SAPP_BRANCH.BRANCH_ZIP='"+zipCode_+"' AND CDW_SAPP_CREDITCARD.MONTH = '"+month_+"' AND CDW_SAPP_CREDITCARD.YEAR = '"+year_+"';");

            PreparedStatement statement = conn.getConnection().prepareStatement("SELECT CREDIT_CARD_NO, TRANSACTION_TYPE, TRANSACTION_VALUE FROM  CDW_SAPP_CREDITCARD WHERE cdw_sapp_creditcard.CREDIT_CARD_NO= '"+credit_card_no+"' AND cdw_sapp_creditcard.MONTH = '"+month+"' AND cdw_sapp_creditcard.YEAR  = '"+year+"';");
            ResultSet result = statement.executeQuery();
            CustMonthly custMonthly_1;
            //ArrayList<String> array = new ArrayList<String>();

            while(result.next()){
                String credit_card_no_ = result.getString("CREDIT_CARD_NO");
                String trans_type = result.getString("TRANSACTION_TYPE");
                double trans_value = result.getDouble("TRANSACTION_VALUE");

                custMonthly_1 = new CustMonthly(credit_card_no_,trans_type, trans_value);
                myCustMonthlyBill[countCustMonthlyBill] = custMonthly_1;
                countCustMonthlyBill++;

            }
            //System.out.println("All records have been selected");
        } catch(Exception e){
            System.out.println(e);
        }

    }


    public int getNumberCustMonthlyBill(){
        return countCustMonthlyBill;
    }

    public CustMonthly[] getCustMonthlyBill(){
        return myCustMonthlyBill;
    }

    public int clearCustMonthlyBill(){
        return countCustMonthlyBill=0;
    }


    public void loadCustChoose(String credit_card_no, int start_year, int start_month, int start_day, int end_year, int end_month, int end_day){
        try{
            //Connection conn = getConnection();
            DBConnection conn = new DBConnection();
            //PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM CDW_SAPP_CREDITCARD INNER JOIN CDW_SAPP_BRANCH ON CDW_SAPP_CREDITCARD.BRANCH_CODE = CDW_SAPP_BRANCH.BRANCH_CODE AND CDW_SAPP_BRANCH.BRANCH_ZIP='"+zipCode_+"' AND CDW_SAPP_CREDITCARD.MONTH = '"+month_+"' AND CDW_SAPP_CREDITCARD.YEAR = '"+year_+"';");

            //PreparedStatement statement = conn.getConnection().prepareStatement("SELECT CREDIT_CARD_NO, TRANSACTION_TYPE, TRANSACTION_VALUE FROM  CDW_SAPP_CREDITCARD WHERE cdw_sapp_creditcard.CREDIT_CARD_NO= '"+credit_card_no+"' AND cdw_sapp_creditcard.MONTH = '"+month+"' AND cdw_sapp_creditcard.YEAR  = '"+year+"';");

            PreparedStatement statement = conn.getConnection().prepareStatement("SELECT CREDIT_CARD_NO, TRANSACTION_TYPE, TRANSACTION_VALUE FROM cdw_sapp_creditcard WHERE cdw_sapp_creditcard.CREDIT_CARD_NO = '"+credit_card_no+"' AND cdw_sapp_creditcard.YEAR BETWEEN '"+start_year+"' AND '"+end_year+"' AND cdw_sapp_creditcard.MONTH BETWEEN '"+start_month+"' AND '"+end_month+"' AND cdw_sapp_creditcard.DAY BETWEEN '"+start_day+"' AND '"+end_day+"';");
            ResultSet result = statement.executeQuery();
            CustChoose custChoose_1;
            //ArrayList<String> array = new ArrayList<String>();

            while(result.next()){
                String credit_card_no_ = result.getString("CREDIT_CARD_NO");
                String trans_type = result.getString("TRANSACTION_TYPE");
                double trans_value = result.getDouble("TRANSACTION_VALUE");

                custChoose_1 = new CustChoose(credit_card_no_,trans_type, trans_value);
                myCustChoose[countCustChoose] = custChoose_1;
                countCustChoose++;

            }
            //System.out.println("All records have been selected");
        } catch(Exception e){
            System.out.println(e);
        }

    }

    public int getNumberCustChoose(){
        return countCustChoose;
    }

    public CustChoose[] getCustChoose(){
        return myCustChoose;
    }

    public int clearCustChoose(){
        return countCustChoose=0;
    }


    public void loadCustUpdate(String first_name, String middle_name, String last_name, int ssn, String credit_card_no, int apt_no, String street_name, String cust_city, String cust_state, String cust_country, String zip_code, String phone, String email){
        try{
            //Connection conn = getConnection();
            DBConnection conn = new DBConnection();
            //PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM CDW_SAPP_CREDITCARD INNER JOIN CDW_SAPP_BRANCH ON CDW_SAPP_CREDITCARD.BRANCH_CODE = CDW_SAPP_BRANCH.BRANCH_CODE AND CDW_SAPP_BRANCH.BRANCH_ZIP='"+zipCode_+"' AND CDW_SAPP_CREDITCARD.MONTH = '"+month_+"' AND CDW_SAPP_CREDITCARD.YEAR = '"+year_+"';");

            //PreparedStatement statement = conn.getConnection().prepareStatement("SELECT CREDIT_CARD_NO, TRANSACTION_TYPE, TRANSACTION_VALUE FROM  CDW_SAPP_CREDITCARD WHERE cdw_sapp_creditcard.CREDIT_CARD_NO= '"+credit_card_no+"' AND cdw_sapp_creditcard.MONTH = '"+month+"' AND cdw_sapp_creditcard.YEAR  = '"+year+"';");

            PreparedStatement statement = conn.getConnection().prepareStatement("UPDATE CDW_SAPP_CUSTOMER SET cdw_sapp_customer.FIRST_NAME = '"+first_name+"', cdw_sapp_customer.MIDDLE_NAME = '"+middle_name+"', cdw_sapp_customer.LAST_NAME = '"+last_name+"', cdw_sapp_customer.SSN = '"+ssn+"', cdw_sapp_customer.CREDIT_CARD_NO = '"+credit_card_no+"', cdw_sapp_customer.APT_NO = '"+apt_no+"', cdw_sapp_customer.STREET_NAME = '"+street_name+"',  cdw_sapp_customer.CUST_CITY = '"+cust_city+"', cdw_sapp_customer.CUST_STATE = '"+cust_state+"',  cdw_sapp_customer.CUST_COUNTRY = '"+cust_country+"', cdw_sapp_customer.CUST_ZIP = '"+zip_code+"',   cdw_sapp_customer.CUST_PHONE = '"+phone+"', cdw_sapp_customer.CUST_EMAIL = '"+email+"';");

            ResultSet result = statement.executeQuery();
            JOptionPane.showMessageDialog(null, "Customer Updated ");

        } catch(Exception e){
            System.out.println(e);
        }

    }


}

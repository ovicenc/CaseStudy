package forms;

import classes.Data;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class frmByCustomer extends JInternalFrame {
    //Objects
    private JLabel lblZipCode;
    private JLabel lblYear;
    private JLabel lblMessage;
    private JTextField txtZipCode;
    private JTextField txtYear;
    private JTextField txtMessage;
    private JLabel lblMonth;
    private JComboBox cmbMonth;
    private JButton btnSearch;
    private JButton btnClear;
    private JTable tblTable;
    private JScrollPane scrTable;



    //Atributes
    private Data myData;
    private DefaultTableModel myTable;
    private int transAct = 0;
    private String months[] = {"Choose month: ","1 - January", "2 - February", "3 - March", "4 - April", "5 - May", "6 - June", "7 - July", "8 - August", "9 - September", "10 - October", "11 - November", "12 - December"};


    //Methods
    public void setData(Data data){
        myData = data;
    }


    //Constructor
    public frmByCustomer() {
        //From properties
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setTitle("Transaction by Customer");
        setLayout(null);
        setSize(970, 450);



        //Forms Objects
        lblZipCode = new JLabel("Zip Code: ");
        txtZipCode = new JTextField(5);
        lblMonth = new JLabel("Month: ");
        cmbMonth = new JComboBox(months);
        lblYear = new JLabel("Year: ");
        txtYear = new JTextField(4);
        lblMessage = new JLabel("Fill the boxes");
        btnSearch = new JButton("Search");
        btnClear = new JButton("Clear");
        tblTable = new JTable();
        scrTable = new JScrollPane();

        //Object properties
        btnSearch.setToolTipText("Search Transaction");
        btnClear.setToolTipText("Clear table");

        //Link table to scroll
        scrTable.setViewportView(tblTable);

        //Add objects to form
        add(lblZipCode);
        add(txtZipCode);
        add(lblMonth);
        add(cmbMonth);
        add(lblYear);
        add(txtYear);
        add(lblMessage);
        add(btnSearch);
        add(btnClear);
        add(scrTable);

        //Object localization
        lblMessage.reshape(20, 0, 110, 20);
        lblZipCode.reshape(20, 40, 110, 20);
        txtZipCode.reshape(130, 40, 150, 20);
        lblMonth.reshape(20, 70, 110, 20);
        cmbMonth.reshape(130, 70, 150, 20);
        lblYear.reshape(300, 70, 130, 20);
        txtYear.reshape(340, 70, 150, 20 );

        btnSearch.reshape(20, 100, 65, 35);
        btnClear.reshape(100, 100, 65, 35);

        scrTable.reshape(20, 145, 900, 250);

        //Form events
        addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
                forminternalFrameOpened(e);

            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {

            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {

            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchActionPerformed(e);
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnClearActionPerformed(e);
            }
        });

    }

    private void forminternalFrameOpened(InternalFrameEvent e){
        //loadTable();
        //showRegister();
        enableFields();

    }

    private void loadTable(){
        String titles[] = {"Trans_Id","Day", "Month", "Year", "Credit Card No", "Cust SSN", "Branch code", "Trans_Type", "Trans_Value"};
        String regiter[] = new String[9];
        myTable = new DefaultTableModel(null, titles);

        for(int i = 0; i < myData.getNumberCreditCards(); i++){
            regiter[0] = "" + myData.getCreditCards()[i].getTransaction_id();
            regiter[1] = "" + myData.getCreditCards()[i].getDay();
            regiter[2] = name_month(myData.getCreditCards()[i].getMonth());
            regiter[3] = "" + myData.getCreditCards()[i].getYear();
            regiter[4] = myData.getCreditCards()[i].getCredit_card_no();
            regiter[5] = "" + myData.getCreditCards()[i].getCust_ssn();
            regiter[6] = "" + myData.getCreditCards()[i].getBranch_code();
            regiter[7] = myData.getCreditCards()[i].getTransaction_type();
            regiter[8] = "" + myData.getCreditCards()[i].getTransaction_value();
            myTable.addRow(regiter);
        }


        tblTable.setModel(myTable);
    }

    private void disableFields(){
        btnSearch.setEnabled(false);

        txtZipCode.setEnabled(false);
        txtYear.setEnabled(false);

    }

    private void enableFields(){
        btnSearch.setEnabled(true);

        txtZipCode.setEnabled(true);
        txtYear.setEnabled(true);

    }

    private void showRegister(){
    }


    private String name_month(int month){
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default: return "Error";

        }
    }

    private void btnSearchActionPerformed(ActionEvent e) {
        //enableFields();

        //Validate fields
        if (txtZipCode.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type a zip code");
            txtZipCode.requestFocusInWindow();
            return;
        }
        if (txtYear.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a year");
            txtYear.requestFocusInWindow();
            return;
        }
        myData.loadCreditCard(Integer.parseInt(txtZipCode.getText()),cmbMonth.getSelectedIndex(),Integer.parseInt(txtYear.getText()));
        loadTable();
    }

    private void btnClearActionPerformed(ActionEvent e) {
        //enableFields();
        DefaultTableModel model = (DefaultTableModel) tblTable.getModel();
        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
            }
        }
        ((DefaultTableModel)tblTable.getModel()).setRowCount(0);
        myData.clearCreditCards();

    }


}

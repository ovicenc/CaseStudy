package forms;

import classes.Data;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMonthlyBill extends JInternalFrame{
    //Objects
    private JLabel lblCreditCardNumber;
    private JLabel lblYear;
    private JLabel lblMessage;
    private JTextField txtCreditCardNumber;
    private JTextField txtYear;
    private JLabel lblMonth;
    private JComboBox cmbMonth;
    private JButton btnSearch;
    private JButton btnClear;
    private JTable tblTable;
    private JScrollPane scrTable;

    //Atributes
    private Data myData;
    private DefaultTableModel myTable;
    private String months[] = {"Choose month: ","1 - January", "2 - February", "3 - March", "4 - April", "5 - May", "6 - June", "7 - July", "8 - August", "9 - September", "10 - October", "11 - November", "12 - December"};


    //Methods
    public void setData(Data data){
        myData = data;
    }

    //Constructor
    public frmMonthlyBill() {
        //From properties
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setTitle("Monthly Bill");
        setLayout(null);
        setSize(970, 450);

        //Forms Objects
        lblCreditCardNumber = new JLabel("Credit Card No: ");
        txtCreditCardNumber = new JTextField(16);
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
        btnSearch.setToolTipText("Search Monthly Bill");
        btnClear.setToolTipText("Clear table");

        //Link table to scroll
        scrTable.setViewportView(tblTable);

        //Add objects to form
        add(lblCreditCardNumber);
        add(txtCreditCardNumber);
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
        lblCreditCardNumber.reshape(20, 40, 110, 20);
        txtCreditCardNumber.reshape(130, 40, 150, 20);
        lblMonth.reshape(20, 70, 110, 20);
        cmbMonth.reshape(130, 70, 150, 20);
        lblYear.reshape(300, 70, 130, 20);
        txtYear.reshape(340, 70, 150, 20);

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

            enableFields();
    }

    private void loadTable() {
        String titles[] = {"Credit Card No", "Transaction Type", "Transaction Value"};
        String regiter[] = new String[3];
        myTable = new DefaultTableModel(null, titles);

        for (int i = 0; i < myData.getNumberCustMonthlyBill(); i++) {
            regiter[0] = "" + myData.getCustMonthlyBill()[i].getCredit_card_no();
            regiter[1] = "" + myData.getCustMonthlyBill()[i].getTransaction_type();
            regiter[2] = "" + myData.getCustMonthlyBill()[i].getTransaction_value();
            myTable.addRow(regiter);
        }
        tblTable.setModel(myTable);
    }


    private void enableFields(){
        btnSearch.setEnabled(true);

        txtCreditCardNumber.setEnabled(true);
        txtYear.setEnabled(true);

    }

    private void btnSearchActionPerformed(ActionEvent e) {
        //enableFields();

        //Validate fields
        if (txtCreditCardNumber.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type credit card number");
            txtCreditCardNumber.requestFocusInWindow();
            return;
        }
        if (txtYear.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a year");
            txtYear.requestFocusInWindow();
            return;
        }
        myData.loadCustMonthlyBill(txtCreditCardNumber.getText(),cmbMonth.getSelectedIndex(),Integer.parseInt(txtYear.getText()));
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
        myData.clearCustMonthlyBill();
    }

}

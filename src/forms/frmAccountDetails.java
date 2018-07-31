package forms;

import classes.Data;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAccountDetails extends JInternalFrame {
    private JLabel lblSsn;
    private JLabel lblEmail;
    private JLabel lblMessage;
    private JTextField txtSsn;
    private JTextField txtEmail;
    private JButton btnSearch;
    private JButton btnClear;
    private JTable tblTable;
    private JScrollPane scrTable;

    private Data myData;
    private DefaultTableModel myTable;
    private int transAct = 0;

    public void setData(Data data) {myData = data;}

    public frmAccountDetails(){
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setTitle("Customer Account Details");
        setLayout(null);
        setSize(970, 450);

        lblSsn = new JLabel("SSN: ");
        txtSsn = new JTextField(9);
        lblEmail = new JLabel("Email: ");
        txtEmail = new JTextField(25);
        lblMessage = new JLabel("Enter the SSN or email of a customer");
        btnSearch = new JButton("Search");
        btnClear = new JButton("Clear");
        tblTable = new JTable();
        scrTable = new JScrollPane();

        btnSearch.setToolTipText("Search Transaction");
        btnClear.setToolTipText("Clear table");

        scrTable.setViewportView(tblTable);

        add(lblSsn);
        add(txtSsn);
        add(lblEmail);
        add(txtEmail);
        add(lblMessage);
        add(btnSearch);
        add(btnClear);
        add(scrTable);

        lblMessage.reshape(20, 0, 300, 20);
        lblSsn.reshape(20, 40, 110, 20);
        txtSsn.reshape(130, 40, 150, 20);
        lblEmail.reshape(20, 70, 110, 20);
        txtEmail.reshape(130, 70, 200, 20);
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
        String titles[] = {"First name", "Middle","Last name", "SSN", "Credit Card", "APT No", "Street", "City", "State","Country", "Zip code", "Phone", "Email"};
        String regiter[] = new String[13];
        myTable = new DefaultTableModel(null, titles);

        for(int i = 0; i < myData.getNumberCustAccount(); i++) {
            regiter[0] = "" + myData.getCustAccount()[i].getFirstName();
            regiter[1] = "" + myData.getCustAccount()[i].getMiddleName();
            regiter[2] = "" + myData.getCustAccount()[i].getLastName();
            regiter[3] = "" + myData.getCustAccount()[i].getSsn();
            regiter[4] = "" + myData.getCustAccount()[i].getCreditCardNumber();
            regiter[5] = "" + myData.getCustAccount()[i].getApt();
            regiter[6] = "" + myData.getCustAccount()[i].getStreet();
            regiter[7] = "" + myData.getCustAccount()[i].getCity();
            regiter[8] = "" + myData.getCustAccount()[i].getState();
            regiter[9] = "" + myData.getCustAccount()[i].getCountry();
            regiter[10] = "" + myData.getCustAccount()[i].getZip();
            regiter[11] = "" + myData.getCustAccount()[i].getPhone();
            regiter[12] = "" + myData.getCustAccount()[i].getEmail();
            myTable.addRow(regiter);
        }
        tblTable.setModel(myTable);
    }

    private void enableFields(){
        btnSearch.setEnabled(true);
        btnClear.setEnabled(true);
        txtSsn.setEnabled(true);
        txtEmail.setEnabled(true);

    }

    private void btnSearchActionPerformed(ActionEvent e) {
        //enableFields();
        if (txtSsn.getText().equals("") && txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type SSN or enter an email");
            txtSsn.requestFocusInWindow();
            return;
        }
        myData.loadAccountDetails(Integer.parseInt(txtSsn.getText()), txtEmail.getText());
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
        myData.clearCustAccount();

    }




}

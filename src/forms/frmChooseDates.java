package forms;

import classes.Data;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmChooseDates extends JInternalFrame{
    private JLabel lblMessage;
    private JLabel lblMessage2;
    private JLabel lblMessage3;
    private JLabel lblCreditCardNumber;
    private JLabel lblStartYear;
    private JLabel lblStartMonth;
    private JLabel lblStartDay;
    private JLabel lblEndYear;
    private JLabel lblEndMonth;
    private JLabel lblEndDay;
    private JTextField txtCreditCardNumber;
    private JTextField txtStartYear;
    private JTextField txtStartMonth;
    private JTextField txtStartDay;
    private JTextField txtEndYear;
    private JTextField txtEndMonth;
    private JTextField txtEndDay;
    private JButton btnSearch;
    private JButton btnClear;
    private JTable tblTable;
    private JScrollPane scrTable;

    private Data myData;
    private DefaultTableModel myTable;

    public void setData(Data data){
        myData = data;
    }

    public frmChooseDates(){
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setTitle("Transactions between two dates");
        setLayout(null);
        setSize(970, 550);

        lblMessage = new JLabel("Type a credit card no and an start date and end date ");
        lblMessage2 = new JLabel("Type the starting date ");
        lblMessage3 = new JLabel("Type the ending date ");
        lblCreditCardNumber = new JLabel("Credit Card No: ");
        txtCreditCardNumber = new JTextField(16);
        lblStartYear = new JLabel("Year: ");
        txtStartYear = new JTextField(4);
        lblStartMonth = new JLabel("Month: ");
        txtStartMonth = new JTextField(2);
        lblStartDay = new JLabel("Day: ");
        txtStartDay = new JTextField(2);
        lblEndYear = new JLabel("Year: ");
        txtEndYear = new JTextField(4);
        lblEndMonth = new JLabel("Month: ");
        txtEndMonth = new JTextField(2);
        lblEndDay = new JLabel("Day: ");
        txtEndDay = new JTextField(2);
        btnSearch = new JButton("Search");
        btnClear = new JButton("Clear");
        tblTable = new JTable();
        scrTable = new JScrollPane();

        //Object properties
        btnSearch.setToolTipText("Search Transactions between two dates");
        btnClear.setToolTipText("Clear table");

        //Link table to scroll
        scrTable.setViewportView(tblTable);

        //Add objects to form
        add(lblMessage);
        add(lblMessage2);
        add(lblMessage3);
        add(lblCreditCardNumber);
        add(txtCreditCardNumber);
        add(lblStartYear);
        add(txtStartYear);
        add(lblStartMonth);
        add(txtStartMonth);
        add(lblStartDay);
        add(txtStartDay);
        add(lblEndYear);
        add(txtEndYear);
        add(lblEndMonth);
        add(txtEndMonth);
        add(lblEndDay);
        add(txtEndDay);
        add(btnSearch);
        add(btnClear);
        add(scrTable);

        lblMessage.reshape(20, 0, 400, 20);
        lblCreditCardNumber.reshape(20, 40, 110, 20);
        txtCreditCardNumber.reshape(130, 40, 150, 20);
        lblMessage2.reshape(20, 75, 400, 20);
        lblStartYear.reshape(20, 100, 50, 20);
        txtStartYear.reshape(90, 100, 150, 20);
        lblStartMonth.reshape(270, 100, 50, 20);
        txtStartMonth.reshape(320, 100, 150, 20);
        lblStartDay.reshape(500, 100, 50, 20);
        txtStartDay.reshape(550, 100, 150, 20);
        lblMessage3.reshape(20, 135, 400, 20);
        lblEndYear.reshape(20, 160, 150, 20);
        txtEndYear.reshape(90, 160, 150, 20);
        lblEndMonth.reshape(270, 160, 50, 20);
        txtEndMonth.reshape(320, 160, 150, 20);
        lblEndDay.reshape(500, 160, 50, 20);
        txtEndDay.reshape(550, 160, 150, 20);

        btnSearch.reshape(20, 210, 65, 35);
        btnClear.reshape(100, 210, 65, 35);

        scrTable.reshape(20, 260, 900, 230);

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

        for (int i = 0; i < myData.getNumberCustChoose(); i++) {
            regiter[0] = "" + myData.getCustChoose()[i].getCredit_card_no();
            regiter[1] = "" + myData.getCustChoose()[i].getTransaction_type();
            regiter[2] = "" + myData.getCustChoose()[i].getTransaction_value();
            myTable.addRow(regiter);
        }
        tblTable.setModel(myTable);
    }

    private void enableFields(){
        btnSearch.setEnabled(true);
        txtCreditCardNumber.setEnabled(true);
        txtStartYear.setEnabled(true);
        txtStartMonth.setEnabled(true);
        txtStartDay.setEnabled(true);
        txtEndYear.setEnabled(true);
        txtEndMonth.setEnabled(true);
        txtEndDay.setEnabled(true);

    }

    private void btnSearchActionPerformed(ActionEvent e) {
        //enableFields();

        //Validate fields
        if (txtCreditCardNumber.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type credit card number");
            txtCreditCardNumber.requestFocusInWindow();
            return;
        }
        if (txtStartYear.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a year");
            txtStartYear.requestFocusInWindow();
            return;
        }
        if (txtStartMonth.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a month");
            txtStartMonth.requestFocusInWindow();
            return;
        }
        if (txtStartDay.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a day");
            txtStartDay.requestFocusInWindow();
            return;
        }
        if (txtEndYear.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a year");
            txtStartYear.requestFocusInWindow();
            return;
        }
        if (txtEndMonth.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a month");
            txtStartMonth.requestFocusInWindow();
            return;
        }
        if (txtEndDay.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a day");
            txtStartDay.requestFocusInWindow();
            return;
        }

        myData.loadCustChoose(txtCreditCardNumber.getText(),Integer.parseInt(txtStartYear.getText()),Integer.parseInt(txtStartMonth.getText()),Integer.parseInt(txtStartDay.getText()),Integer.parseInt(txtEndYear.getText()),Integer.parseInt(txtEndMonth.getText()),Integer.parseInt(txtEndDay.getText()));
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
        myData.clearCustChoose();

    }

}

package forms;

import classes.Data;
import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmUpdateUser extends JInternalFrame{
    private JLabel lblMessage;
    private JLabel lblFirstName;
    private JTextField txtFirstName;
    private JLabel lblMiddleName;
    private JTextField txtMiddleName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblSsn;
    private JTextField txtSsn;
    private JLabel lblCreditCardNumber;
    private JTextField txtCreditCardNumber;
    private JLabel lblAptNo;
    private JTextField txtAptNo;
    private JLabel lblStreetName;
    private JTextField txtStreetName;
    private JLabel lblCustCity;
    private JTextField txtCustCity;
    private JLabel lblCustState;
    private JTextField txtCustState;
    private JLabel lblCustCountry;
    private JTextField txtCustCountry;
    private JLabel lblCustZip;
    private JTextField txtCustZip;
    private JLabel lblCustPhone;
    private JTextField txtCustPhone;
    private JLabel lblCustEmail;
    private JTextField txtCustEmail;
    private JLabel lblLasUpdate;
    private JTextField txtLastUpdate;
    private JButton btnUpdate;

    private Data myData;
    public void setData(Data data){myData = data;}

    public frmUpdateUser() {
        //From properties
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setTitle("Update User");
        setLayout(null);
        setSize(500, 600);

        lblMessage = new JLabel("Update a User");
        lblFirstName = new JLabel("First Name: ");
        txtFirstName = new JTextField();
        lblMiddleName = new JLabel("Middle Name: ");
        txtMiddleName = new JTextField();
        lblLastName = new JLabel("Last Name: ");
        txtLastName = new JTextField();
        lblSsn = new JLabel("SSN: ");
        txtSsn = new JTextField();
        lblCreditCardNumber = new JLabel("Credit Card No: ");
        txtCreditCardNumber = new JTextField();
        lblAptNo = new JLabel("Apt No: ");
        txtAptNo = new JTextField();
        lblStreetName = new JLabel("Street Name: ");
        txtStreetName = new JTextField();
        lblCustCity = new JLabel("Cust. City: ");
        txtCustCity = new JTextField();
        lblCustState = new JLabel("Cust. State: ");
        txtCustState = new JTextField();
        lblCustCountry = new JLabel("Cust. City: ");
        txtCustCountry = new JTextField();
        lblCustZip = new JLabel("Cust. Zip: ");
        txtCustZip = new JTextField();
        lblCustPhone = new JLabel("Cust. Phone: ");
        txtCustPhone = new JTextField();
        lblCustEmail = new JLabel("Cust. Email: ");
        txtCustEmail = new JTextField();
        btnUpdate = new JButton("Update");

        btnUpdate.setToolTipText("Update Customer");

        add(lblMessage);
        add(lblFirstName);
        add(txtFirstName);
        add(lblMiddleName);
        add(txtMiddleName);
        add(lblLastName);
        add(txtLastName);
        add(lblSsn);
        add(txtSsn);
        add(lblCreditCardNumber);
        add(txtCreditCardNumber);
        add(lblAptNo);
        add(txtAptNo);
        add(lblStreetName);
        add(txtStreetName);
        add(lblCustCity);
        add(txtCustCity);
        add(lblCustState);
        add(txtCustState);
        add(lblCustCountry);
        add(txtCustCountry);
        add(lblCustZip);
        add(txtCustZip);
        add(lblCustPhone);
        add(txtCustPhone);
        add(lblCustEmail);
        add(txtCustEmail);
        add(btnUpdate);

        lblMessage.reshape(20, 0, 110, 20);
        lblFirstName.reshape(20, 40, 110, 20);
        txtFirstName.reshape(130, 40, 150, 20);
        lblMiddleName.reshape(20, 70, 110, 20);
        txtMiddleName.reshape(130, 70, 150, 20);
        lblLastName.reshape(20, 100, 110, 20);
        txtLastName.reshape(130, 100, 150, 20);
        lblSsn.reshape(20, 130, 110, 20);
        txtSsn.reshape(130, 130, 150, 20);
        lblCreditCardNumber.reshape(20, 160, 110, 20);
        txtCreditCardNumber.reshape(130, 160, 150, 20);
        lblAptNo.reshape(20, 190, 110, 20);
        txtAptNo.reshape(130, 190, 150, 20);
        lblStreetName.reshape(20, 220, 110, 20);
        txtStreetName.reshape(130, 220, 150, 20);
        lblCustCity.reshape(20, 250, 110, 20);
        txtCustCity.reshape(130, 250, 150, 20);
        lblCustState.reshape(20, 280, 110, 20);
        txtCustState.reshape(130, 280, 150, 20);
        lblCustCountry.reshape(20, 310, 110, 20);
        txtCustCountry.reshape(130, 310, 150, 20);
        lblCustZip.reshape(20, 340, 110, 20);
        txtCustZip.reshape(130, 340, 150, 20);
        lblCustPhone.reshape(20, 370,110, 20);
        txtCustPhone.reshape(130, 370, 150, 20);
        lblCustEmail.reshape(20, 400,110, 20);
        txtCustEmail.reshape(130, 400, 150, 20);
        btnUpdate.reshape(20, 470, 65, 35);

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

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdateActionPerformed(e);
            }
        });

    }

    private void forminternalFrameOpened(InternalFrameEvent e){
        enableFields();
    }

    private void enableFields(){
        btnUpdate.setEnabled(true);
        txtFirstName.setEnabled(true);
        txtMiddleName.setEnabled(true);
        txtLastName.setEnabled(true);
        txtSsn.setEnabled(true);
        txtCreditCardNumber.setEnabled(true);
        txtAptNo.setEnabled(true);
        txtStreetName.setEnabled(true);
        txtCustCity.setEnabled(true);
        txtCustState.setEnabled(true);
        txtCustCountry.setEnabled(true);
        txtCustZip.setEnabled(true);
        txtCustPhone.setEnabled(true);
        txtCustEmail.setEnabled(true);

    }

    private void btnUpdateActionPerformed(ActionEvent e) {
        //enableFields();

        //Validate fields
        if (txtFirstName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type first name");
            txtFirstName.requestFocusInWindow();
            return;
        }
        if (txtMiddleName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type middle name");
            txtMiddleName.requestFocusInWindow();
            return;
        }
        if (txtLastName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type last name");
            txtLastName.requestFocusInWindow();
            return;
        }
        if (txtSsn.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type SSN");
            txtSsn.requestFocusInWindow();
            return;
        }
        if (txtCreditCardNumber.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type credit card number");
            txtCreditCardNumber.requestFocusInWindow();
            return;
        }
        if (txtAptNo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type Apartment No");
            txtAptNo.requestFocusInWindow();
            return;
        }
        if (txtStreetName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type Street name");
            txtStreetName.requestFocusInWindow();
            return;
        }
        if (txtCustCity.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type a city");
            txtCustCity.requestFocusInWindow();
            return;
        }
        if (txtCustState.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type a state");
            txtCustState.requestFocusInWindow();
            return;
        }
        if (txtCustCountry.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type a country");
            txtCustCountry.requestFocusInWindow();
            return;
        }
        if (txtCustZip.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type zip code");
            txtCustZip.requestFocusInWindow();
            return;
        }
        if (txtCustPhone.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type a phone number");
            txtCustPhone.requestFocusInWindow();
            return;
        }
        if (txtCustEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please type an email");
            txtCustEmail.requestFocusInWindow();
            return;
        }
        myData.loadCustUpdate(txtFirstName.getText(), txtMiddleName.getText(), txtLastName.getText(), Integer.parseInt(txtSsn.getText()), txtCreditCardNumber.getText(), Integer.parseInt(txtAptNo.getText()), txtStreetName.getText(), txtCustCity.getText(), txtCustState.getText(), txtCustCountry.getText(), txtCustZip.getText(), txtCustPhone.getText(), txtCustEmail.getText());

    }



}

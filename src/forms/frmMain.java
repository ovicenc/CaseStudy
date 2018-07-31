package forms;

import classes.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMain extends JFrame {

    //Objects
    private JMenuBar mnbBankSystem;
    private JMenu mnuTransaction;
    private JMenu mnuCustomer;
    private JMenu mnuHelp;
    private JMenuItem mnuTransactionByCustomer;
    private JMenuItem mnuTransactionGivenType;
    private JMenuItem mnuTransactionGivenState;
    private JSeparator mnuTransactionSeparator1;
    private JMenuItem mnuTransactionExit;
    private JMenuItem mnuCustomerDetails;
    private JMenuItem mnuCustomerMonthlyBill;
    private JMenuItem mnuCustomerUpdate;
    private JMenuItem mnuCustomerTransactionBetweenTwoDays;
    private JSeparator mnuCustomerSeparator1;
    private JMenuItem mnuCustomerExit;
    private JMenuItem mnuHelpAbout;
    private JMenuItem mnuHelpHelp;
    private JDesktopPane dpnDesktop;

    //Atributes
    private Data myData;

    //Methods
    public void setData(Data data){
        myData = data;
    }


    //Constructor
    public frmMain(){
        // Form properties
        setTitle("Bank System");
        setResizable(true);
        setSize(1300, 900);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Objects
        mnbBankSystem = new JMenuBar();
        mnuTransaction = new JMenu("Transaction");
        mnuCustomer = new JMenu("Customer");
        mnuHelp = new JMenu("Help");
        mnuTransactionByCustomer = new JMenuItem("By customer");
        mnuTransactionGivenType = new JMenuItem("By given type");
        mnuTransactionGivenState = new JMenuItem("By given state");
        mnuTransactionSeparator1 = new JSeparator();
        mnuTransactionExit = new JMenuItem("Exit");
        mnuCustomerDetails = new JMenuItem("Account details");
        mnuCustomerUpdate= new JMenuItem("Update user info");
        mnuCustomerMonthlyBill = new JMenuItem("Monthly bill");
        mnuCustomerTransactionBetweenTwoDays = new JMenuItem("Choose dates");
        mnuCustomerSeparator1 = new JSeparator();
        mnuCustomerExit = new JMenuItem("Exit");
        mnuHelpAbout = new JMenuItem("About");
        mnuHelpHelp = new JMenuItem("Help");
        dpnDesktop = new JDesktopPane();

        //Create Menu
        mnuTransaction.add(mnuTransactionByCustomer);
        mnuTransaction.add(mnuTransactionGivenType);
        mnuTransaction.add(mnuTransactionGivenState);
        mnuTransaction.add(mnuTransactionSeparator1);
        mnuTransaction.add(mnuTransactionExit);
        mnbBankSystem.add(mnuTransaction);

        mnuCustomer.add(mnuCustomerDetails);
        mnuCustomer.add(mnuCustomerUpdate);
        mnuCustomer.add(mnuCustomerMonthlyBill);
        mnuCustomer.add(mnuCustomerTransactionBetweenTwoDays);
        mnuCustomer.add(mnuCustomerSeparator1);
        mnuCustomer.add(mnuCustomerExit);
        mnbBankSystem.add(mnuCustomer);

        mnuHelp.add(mnuHelpAbout);
        mnuHelp.add(mnuHelpHelp);
        mnbBankSystem.add(mnuHelp);

        // Form properties
        setJMenuBar(mnbBankSystem);
        setContentPane(dpnDesktop);

        //Menu events
        mnuTransactionByCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuTransactionByCustomerActionPerformed(e);
            }
        });
        mnuTransactionGivenType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuTransactionGivenTypeActionPerformed(e);
            }
        });
        mnuTransactionGivenState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuTransactionGivenStateActionPerformed(e);
            }
        });
        mnuTransactionExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuTransactionExitTypeActionPerformed(e);
            }
        });

        mnuCustomerDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuCustomerDetailsActionPerformed(e);
            }
        });
        mnuCustomerUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuCustomerUpdateActionPerformed(e);
            }
        });
        mnuCustomerMonthlyBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuCustomerMonthlyBillActionPerformed(e);
            }
        });
        mnuCustomerTransactionBetweenTwoDays.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuCustomerTransactionBetweenTwoDaysActionPerformed(e);
            }
        });
        mnuCustomerExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuCustomerExitActionPerformed(e);
            }
        });
        mnuHelpAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuHelpAboutActionPerformed(e);
            }
        });
        mnuHelpHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuHelpHelpActionPerformed(e);
            }
        });

    }

    private void mnuTransactionByCustomerActionPerformed(ActionEvent e){
        frmByCustomer myByCustomer = new frmByCustomer();
        dpnDesktop.add(myByCustomer);
        myByCustomer.setData(myData);
        myByCustomer.show();

    }

    private void mnuTransactionGivenTypeActionPerformed(ActionEvent e){
        frmByGivenType myByGivenType = new frmByGivenType();
        dpnDesktop.add(myByGivenType);
        myByGivenType.setData(myData);
        myByGivenType.show();

    }

    private void mnuTransactionGivenStateActionPerformed(ActionEvent e){
        frmByGivenState myByGivenState = new frmByGivenState();
        dpnDesktop.add(myByGivenState);
        myByGivenState.setData(myData);
        myByGivenState.show();

    }

    private void mnuTransactionExitTypeActionPerformed(ActionEvent e){
        // End the app
        System.exit(0);

    }

    private void mnuCustomerDetailsActionPerformed(ActionEvent e){
        frmAccountDetails myAccountDetails = new frmAccountDetails();
        dpnDesktop.add(myAccountDetails);
        myAccountDetails.setData(myData);
        myAccountDetails.show();

    }

    private  void mnuCustomerUpdateActionPerformed(ActionEvent e){

    }

    private void mnuCustomerMonthlyBillActionPerformed(ActionEvent e){

    }

    private void mnuCustomerTransactionBetweenTwoDaysActionPerformed(ActionEvent e){

    }

    private void mnuCustomerExitActionPerformed(ActionEvent e){
        // End the app
        System.exit(0);

    }

    private void mnuHelpAboutActionPerformed(ActionEvent e){
        frmAbout myAbout = new frmAbout();
        dpnDesktop.add(myAbout);
        //myAbout(myData);
        myAbout.show();

    }

    private void mnuHelpHelpActionPerformed(ActionEvent e){
        frmHelp myHelp = new frmHelp();
        dpnDesktop.add(myHelp);
        myHelp.show();

    }

}

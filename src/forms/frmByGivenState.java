package forms;

import classes.Data;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmByGivenState extends JInternalFrame {
    private JLabel txtMessage;
    private JLabel lblTransactionState;
    private JComboBox cmbTransactionState;
    private JButton btnSearch;
    private JButton btnClear;
    private JTable tblTable;
    private JScrollPane scrTable;

    //Atributes
    private Data myData;
    private DefaultTableModel myTable;
    private int transAct = 0;
    private String TransactionState[] = {"Choose a State: ","AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

    //Methods
    public void setData(Data data){
        myData = data;
    }


    public frmByGivenState() {
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setTitle("Transaction by a Given State for branches");
        setLayout(null);
        setSize(560, 290);

        lblTransactionState = new JLabel("Transaction State:");
        cmbTransactionState = new JComboBox(TransactionState);
        txtMessage = new JLabel("Choose a Transaction State");
        btnSearch = new JButton("Search");
        btnClear = new JButton("Clear");
        tblTable = new JTable();
        scrTable = new JScrollPane();

        //Object properties
        btnSearch.setToolTipText("Search Transaction");
        btnClear.setToolTipText("Clear table");

        //Link table to scroll
        scrTable.setViewportView(tblTable);

        add(lblTransactionState);
        add(cmbTransactionState);
        add(txtMessage);
        add(btnSearch);
        add(btnClear);
        add(scrTable);

        //Object localization
        txtMessage.reshape(20, 0, 200, 20);
        lblTransactionState.reshape(20, 40, 150, 20);
        cmbTransactionState.reshape(180, 40, 150, 20);
        btnSearch.reshape(20, 80, 65, 35);
        btnClear.reshape(100, 80, 65, 35);

        scrTable.reshape(20, 125, 500, 100);

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
        String titles[] = {"Sum of Trans Value", "Count of Trans"};
        String regiter[] = new String[2];
        myTable = new DefaultTableModel(null, titles);

        for(int i = 0; i < myData.getNumberTransState(); i++) {
            regiter[0] = "" + myData.getTransState()[i].getSum_trans();
            regiter[1] = "" + myData.getTransState()[i].getCount_trans();
            myTable.addRow(regiter);
        }
        tblTable.setModel(myTable);
    }

    private void enableFields(){
        btnSearch.setEnabled(true);
        btnClear.setEnabled(true);

    }

    private void btnSearchActionPerformed(ActionEvent e) {
        //enableFields();
        myData.loadQueryTransByState((String)cmbTransactionState.getSelectedItem());
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
        myData.clearTransState();

    }

}
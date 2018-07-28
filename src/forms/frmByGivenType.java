package forms;

import classes.Data;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmByGivenType extends JInternalFrame {
    private JLabel txtMessage;
    private JLabel lblTransactionType;
    private JComboBox cmbTransactionType;
    private JButton btnSearch;
    private JButton btnClear;
    private JTable tblTable;
    private JScrollPane scrTable;

    //Atributes
    private Data myData;
    private DefaultTableModel myTable;
    private int transAct = 0;
    private String TransactionType[] = {"Choose a type: ","Bills", "Education", "Entertainment", "Gas", "Grocery", "Healthcare", "Test"};

    //Methods
    public void setData(Data data){
        myData = data;
    }



    public frmByGivenType() {
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setTitle("Transaction by a Given Type");
        setLayout(null);
        setSize(560, 290);

        lblTransactionType = new JLabel("Transaction Type:");
        cmbTransactionType = new JComboBox(TransactionType);
        txtMessage = new JLabel("Choose a Transaction type");
        btnSearch = new JButton("Search");
        btnClear = new JButton("Clear");
        tblTable = new JTable();
        scrTable = new JScrollPane();

        //Object properties
        btnSearch.setToolTipText("Search Transaction");
        btnClear.setToolTipText("Clear table");

        //Link table to scroll
        scrTable.setViewportView(tblTable);

        add(lblTransactionType);
        add(cmbTransactionType);
        add(txtMessage);
        add(btnSearch);
        add(btnClear);
        add(scrTable);

        //Object localization
        txtMessage.reshape(20, 0, 200, 20);
        lblTransactionType.reshape(20, 40, 150, 20);
        cmbTransactionType.reshape(180, 40, 150, 20);
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

        for(int i = 0; i < myData.getNumberTransType(); i++) {
            regiter[0] = "" + myData.getTransType()[i].getSum_trans();
            regiter[1] = "" + myData.getTransType()[i].getCount_trans();
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
        myData.loadQueryTransByType((String)cmbTransactionType.getSelectedItem());
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
        myData.clearTransType();

    }


}

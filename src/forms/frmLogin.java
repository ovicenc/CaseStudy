package forms;

import classes.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmLogin extends JFrame {
    //Object of the form
    private JLabel lblUser;
    private JLabel lblKey;
    private JLabel lblImage;
    private JTextField txtUser;
    private JPasswordField txtKey;
    private JButton btnSignIn;
    private JButton btnCancelar;

    //Atributes
    private Data myData;

    //Methods
    public void setData(Data data){
        myData = data;
    }


    //Constructor
    public frmLogin(){
        // Form properties
        setTitle("Login to the System");
        setResizable(false);
        setSize(390, 160);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Icons

        // Form Objects
        lblUser = new JLabel("User:");
        txtUser = new JTextField(10);
        lblKey = new JLabel("Password:");
        txtKey = new JPasswordField(10);
        btnSignIn = new JButton("Log in");
        btnCancelar = new JButton("Cancelar");

        btnSignIn.setToolTipText("Log into the system");
        btnSignIn.setToolTipText("Cancel and close");

        //Object to the form
        add(lblUser);
        add(txtUser);
        add(lblKey);
        add(txtKey);
        add(btnSignIn);
        add(btnCancelar);

        //Find objects to the form
        lblUser.reshape(20, 20, 100, 20);
        txtUser.reshape(120, 20, 250, 20);

        lblKey.reshape(20, 45, 100, 20);
        txtKey.reshape(120, 45, 250, 20);

        btnSignIn.reshape(20, 85, 90, 35);
        btnCancelar.reshape(150, 85, 90, 35);

        //Button events
        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSignInActionPerformed(e);
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelarActionPerformed(e);
            }
        });

    }

    private void btnSignInActionPerformed(ActionEvent e){
        if(!myData.validateUser(txtUser.getText(), new String(txtKey.getPassword()))){
            JOptionPane.showMessageDialog(null, "Invalid user or password");
            txtUser.setText("");
            txtKey.setText("");
            txtUser.requestFocusInWindow();
            return;
        }

        frmMain myMain = new frmMain();
        setVisible(false);
        myMain.setData(myData);
        myMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myMain.setVisible(true);


    }

    private void btnCancelarActionPerformed(ActionEvent e){
        //End the app
        System.exit(0);

    }
}

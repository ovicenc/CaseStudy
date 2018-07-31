package forms;

import javax.swing.*;


public class frmAbout extends JInternalFrame{
    private JTextArea lblMessage;

    public frmAbout(){
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setTitle("About ...");
        setLayout(null);
        setSize(210, 130);

        lblMessage = new JTextArea("Case Study of a Bank System \nPerScholas \nData Engineering Course \nOmar Vicencio \n2018");

        add(lblMessage);

        lblMessage.reshape(0, 0, 200, 100);
    }
}

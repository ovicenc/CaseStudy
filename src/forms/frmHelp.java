package forms;

import javax.swing.*;

public class frmHelp extends JInternalFrame{
    private JTextArea lblMessage;

    public frmHelp(){
        setClosable(true);
        setIconifiable(false);
        setResizable(false);
        setTitle("Help ...");
        setLayout(null);
        setSize(200, 100);

        lblMessage = new JTextArea("Java 9 \nIntelliJ IDEA");

        add(lblMessage);

        lblMessage.reshape(0, 0, 200, 100);
    }
}

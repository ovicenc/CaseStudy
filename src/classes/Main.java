package classes;

import forms.frmLogin;

public class Main {
    public static void main(String args[]){
        Data myData = new Data();
        frmLogin myLogin = new frmLogin();
        myLogin.setData(myData);
        myLogin.setLocationRelativeTo(null);
        myLogin.setVisible(true);

    }
}

package Case_modul2.model;

import java.io.Serializable;

public class Account implements Serializable {
    private String name;
    private String pass;
    private boolean role;

    public Account(String name, String pass, boolean role) {
        this.name = name;
        this.pass = pass;
        this.role = role;
    }

    public Account() {
    }

    public Account(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", role=" + role +
                '}';
    }
}

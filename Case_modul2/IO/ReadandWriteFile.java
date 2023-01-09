package Case_modul2.IO;

import Case_modul2.model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadandWriteFile {
    public void writefile(List<Account> accounts){
        try {
            FileOutputStream fileOutputStream= new FileOutputStream("filenhiphan.txt");
            ObjectOutputStream obj=new ObjectOutputStream(fileOutputStream);
            obj.writeObject(accounts);
            obj.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Account> readfile(){
        List<Account> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream= new FileInputStream("D:\\untitled4\\modul2\\Case-study\\filenhiphan.txt");
            ObjectInputStream ob= new ObjectInputStream(fileInputStream);
            list = (List<Account>) ob.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("-----------------");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


}

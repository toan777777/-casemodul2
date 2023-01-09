package Case_modul2.IO;

import Case_modul2.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoCart {
    public void writeCart(List<Product> carts){
        try {
            FileOutputStream fileOutputStream= new FileOutputStream("D:\\untitled4\\modul2\\Case-study\\src\\Case_modul2\\Cart.txt");
            ObjectOutputStream ob=new ObjectOutputStream(fileOutputStream);
            ob.writeObject(carts);
            ob.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Product> readCart(){
     List<Product>cart= new ArrayList<>();

        try {
            FileInputStream fileInputStream= new FileInputStream("D:\\untitled4\\modul2\\Case-study\\src\\Case_modul2\\Cart.txt");
            ObjectInputStream obi=new ObjectInputStream(fileInputStream);
            cart=(List<Product>) obi.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("-------------");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }return cart;

    }
}

package Case_modul2.IO;

import Case_modul2.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOproduct {
    public void writeProduct(List<Product> products){
        try {
            FileOutputStream fout=new FileOutputStream("D:\\untitled4\\modul2\\Case-study\\src\\product.txt");
            ObjectOutputStream obi=new ObjectOutputStream(fout);
            obi.writeObject(products);
            obi.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Product> readProduct(){
        List<Product> productList= new ArrayList<>();
        try {
            FileInputStream fint= new FileInputStream("D:\\untitled4\\modul2\\Case-study\\src\\product.txt");
            ObjectInputStream obj= new ObjectInputStream(fint);
            productList=(List<Product>) obj.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("------------");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }return productList;

    }
}

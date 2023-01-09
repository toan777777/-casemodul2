package Case_modul2.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOquantity {
    public void writeQuantity(List<Integer> quantity){
        try {
            FileOutputStream fileOutputStream= new FileOutputStream("D:\\untitled4\\modul2\\Case-study\\src\\Case_modul2\\quantity.txt");
            ObjectOutputStream ob= new ObjectOutputStream(fileOutputStream);
            ob.writeObject(quantity);
            ob.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Integer> readQuantity(){
        List<Integer> quantiti= new ArrayList<>();
        try {
            FileInputStream fileInputStream= new FileInputStream("D:\\untitled4\\modul2\\Case-study\\src\\Case_modul2\\quantity.txt");
            ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);
            quantiti=(List<Integer>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("-----");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }return quantiti;
    }
}

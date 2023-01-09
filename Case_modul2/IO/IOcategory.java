package Case_modul2.IO;

import Case_modul2.model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOcategory {
    public void writeCategory(List<Category> categories){
        try {
            FileOutputStream out= new FileOutputStream("D:\\untitled4\\modul2\\Case-study\\src\\Case_modul2\\category.txt");
            ObjectOutputStream ob=new ObjectOutputStream(out);
            ob.writeObject(categories);
            ob.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Category> readCategory(){
        List<Category>cate=new ArrayList<>();
        try {
            FileInputStream in=new FileInputStream("D:\\untitled4\\modul2\\Case-study\\src\\Case_modul2\\category.txt");
            ObjectInputStream obj=new ObjectInputStream(in);
            cate=(List<Category>) obj.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("---------");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }return cate;
    }
}

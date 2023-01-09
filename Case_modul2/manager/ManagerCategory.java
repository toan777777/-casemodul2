package Case_modul2.manager;

import Case_modul2.IO.IOcategory;
import Case_modul2.model.Category;

import java.util.*;

public class ManagerCategory {
    IOcategory iOcategory = new IOcategory();
    List<Category> listCategory=new ArrayList<>();

    public ManagerCategory() {
        listCategory = iOcategory.readCategory();
        if(listCategory.size() == 0){
            listCategory.add(new Category(1,"hàng tiêu dùng"));
        }

    }
    Scanner scanner = new Scanner(System.in);

    public Category creatCategory() {
        System.out.println(" nhập mã id cho Category");
      int id= Integer.parseInt(scanner.nextLine());
        System.out.println("nhập loại sản phẩm:");
        String loai = scanner.nextLine();
        Category category = new Category(id, loai);
        listCategory.add(category);
        iOcategory.writeCategory(listCategory);
        return category;
    }
    public void showCategory(){
        for (Category c :
                listCategory) {
            System.out.println(c);
        }
    }


}

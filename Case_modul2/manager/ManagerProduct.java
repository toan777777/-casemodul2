package Case_modul2.manager;

import Case_modul2.IO.IOproduct;
import Case_modul2.model.Category;
import Case_modul2.model.Product;

import java.util.*;

public class ManagerProduct {
    Category category = new Category();
    ManagerCategory managerCategory = new ManagerCategory();
    List<Product> listProduct;

    public ManagerProduct() {
        listProduct = new ArrayList<>();
        listProduct = ioProduct.readProduct();
    }

    int id = 0;
    IOproduct ioProduct = new IOproduct();

    Scanner scanner = new Scanner(System.in);


    public Product creatProduct() {
        int quantity;
        double price;
        int id = findIDmax();
        id++;
        System.out.println("Enter name product");
        String name = scanner.nextLine();
        System.out.println(" Enter quantity product");
        do {
            try {
                 quantity = Integer.parseInt(scanner.nextLine());
                break;

            }catch (NumberFormatException e){
                System.out.println("vui lòng nhập số");
            }
        }while (true);

        System.out.println(" Enter price product");
        do {
            try {
                price = Double.valueOf(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println(" phải nhập sô");
            }
        }while (true);


        Category category = chooseCategory();
        Product product = new Product(id, name, quantity, price, category);
        return product;
    }

    public Category chooseCategory() {
        managerCategory.showCategory();
        System.out.println("0. tạo mới categorry");
        System.out.println("---------------------");
        System.out.println(" nhập mã Category");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        Category category = null;
        for (int i = 0; i < managerCategory.listCategory.size(); i++) {
            if (managerCategory.listCategory.get(i).getId() == id) {
                category = managerCategory.listCategory.get(i);
                check = true;
                break;
            }
        }
        if (check == false) {
            category = managerCategory.creatCategory();
        }
        return category;
    }


    public int findIDmax() {
        int maxId = -1;
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() > maxId) {
                maxId = listProduct.get(i).getId();
            }

        }
        return maxId;
    }


    public void addProduct() {
        Product product = creatProduct();
        listProduct.add(product);
        ioProduct.writeProduct(listProduct);
    }

    public void showProduct() {
        System.out.println("                              LisProduct:\n");
        for (int i = 0; i < listProduct.size(); i++) {
            System.out.println(listProduct.get(i).toString());
        }
    }


    public int findProductByID() {
        showProduct();
        int id;
        System.out.println(" nhập id Product");
        do {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("nhập sô");
            }
        }while (true);


        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void editProduct() {
        int index = findProductByID();
        System.out.println(" nhập ID Product");
        if (index == -1) {
            System.out.println(" sản phẩm không tồn tại");
        } else {
            System.out.println("muốn sửa gì?????");
            System.out.println("1:  sửa tên");
            System.out.println("2: sửa số lượng");
            System.out.println("3: sửa giá sp");
            int choi = Integer.parseInt(scanner.nextLine());
            switch (choi) {
                case 1:
                    System.out.println("Nhập tên muốn sửa");
                    String newname = scanner.nextLine();
                    listProduct.get(index).setName(newname);
                    ioProduct.writeProduct(listProduct);
                    break;
                case 2:
                    int newquantity;
                    System.out.println(" nhập số lượng");
                    do {
                        try {
                            newquantity = Integer.parseInt(scanner.nextLine());
                            break;
                        }catch (NumberFormatException e){
                            System.out.println(" vui  lòng nhập số");
                        }
                    }while (true);
                    listProduct.get(index).setQuantity(newquantity);
                    ioProduct.writeProduct(listProduct);
                    break;
                case 3:
                    double newprice;
                    System.out.println(" nhập giá");
                    do {
                        try {
                            newprice = Double.parseDouble(scanner.nextLine());
                            break;
                        }catch (NumberFormatException e){
                            System.out.println(" vui lòng nhập số");
                        }
                    }while (true);
                    listProduct.get(index).setPrice(newprice);
                    ioProduct.writeProduct(listProduct);
                    break;
            }
        }
    }

    public void updateProduct() {

        int index = findProductByID();
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(index).getQuantity() == 0) {
                System.out.println("bạn có muốn nhập thêm số lượng không");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("n")) {
                    System.out.println("không cập nhật số lượng");
                    break;
                } else if (option.equalsIgnoreCase("y")) {
                    System.out.println(" mời nhập số lượng sản phẩm");
                    listProduct.get(index).setQuantity(Integer.parseInt(scanner.nextLine()));
                    System.out.println(" cập nhật số lượng thành công");
                    ioProduct.writeProduct(listProduct);
                }
            }


        }
        System.out.println("số lượng vẫn còn:");
    }
    public void deletePoduct(){
        int index=findProductByID();
        if(index==-1){
            System.out.println(" không có sản phẩm cần tìm");
        }
        else {
            listProduct.remove(index);
            System.out.println(" xóa sản phẩm thành công");
            ioProduct.writeProduct(listProduct);
        }
    }
    public void sort(){
            Collections.sort(listProduct, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice()- o2.getPrice());
                }
            });

            }
        }

package Case_modul2.manager;

import Case_modul2.IO.IOproduct;
import Case_modul2.IO.IOquantity;
import Case_modul2.IO.IoCart;

import Case_modul2.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerShopping {
    ManagerProduct managerProduct = new ManagerProduct();
    IOproduct iOproduct = new IOproduct();
    IoCart ioCart = new IoCart();
    IOquantity iOquantity= new IOquantity();
    static Scanner scanner = new Scanner(System.in);
    List<Product> giohang=new ArrayList<>();
    List<Integer> soluong=new ArrayList<>();


    public ManagerShopping() {

    giohang=ioCart.readCart();
    soluong=iOquantity.readQuantity();
    }

    public int findProductByID() {
        managerProduct.showProduct();
        System.out.println(" nhập mã hàng muốn tìm");
        int masp = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < managerProduct.listProduct.size(); i++) {
            if (managerProduct.listProduct.get(i).getId() == masp) {
                System.out.println(managerProduct.listProduct.get(i).toString());
                return i;
            }
        }
        System.out.println(" không có sản phẩm trong danh sách");
        System.out.println(" mời nhập mã khác");
        return -1;
    }

    public void showCart() {
        for (int i = 0; i < giohang.size(); i++) {
            System.out.println("id = " + giohang.get(i).getId() + " name = " + giohang.get(i).getName() + " soluong = " + soluong.get(i));
        }
    }

    public void deleteProductCart() {
        showCart();
        int masp = seachProductinCart();
        giohang.remove(masp);
        soluong.remove(masp);
        System.out.println(" xóa sản phẩm thành công");
        System.out.println(" sản phẩm còn lại trong giỏ hàng: " + giohang.size() + "");
        ioCart.writeCart(giohang);
        iOquantity.writeQuantity(soluong);
    }

    public int seachProductinCart() {
        System.out.println(" nhập mã sản phẩm muốn xóa");
        int masp = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < giohang.size(); i++) {
            if (giohang.get(i).getId() == masp) {
                return i;
            }
        }
        return -1;

    }

    public void showbill() {
        System.out.println(" sản phẩm bạn gồm có");
        showCart();
        Double total = 0.0;
        Double money;
        for (int i = 0; i < giohang.size(); i++) {
            money = giohang.get(i).getQuantity() * giohang.get(i).getPrice();
            total += money;

        }
        System.out.println(" số tiền sản phẩm là: " + total + " đồng");

    }


    public void addProducttoCart() {
        int index=findProductByID();
        System.out.println(" nhập số lượng muốn thêm");
        int number= Integer.parseInt(scanner.nextLine());

        int sl=managerProduct.listProduct.get(index).getQuantity();
        if(number>sl){
            System.out.println(" số lượng không đủ");
        }
        else {
           giohang.add(managerProduct.listProduct.get(index));
           soluong.add(number);
            System.out.println("add thành công");

           managerProduct.listProduct.get(index).setQuantity(sl-number);

           ioCart.writeCart(giohang);
           iOquantity.writeQuantity(soluong);
           iOproduct.writeProduct(managerProduct.listProduct);

        }

    }

    public void seachCatagory() {
        managerProduct.showProduct();
        System.out.println(" nhập loại muốn tìm");
        int loai = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < managerProduct.listProduct.size(); i++) {
            if (managerProduct.listProduct.get(i).getCategory().getId() == loai) {
                System.out.println(managerProduct.listProduct.get(i));
            }
        }
    }

    public void seachPrice() {
        System.out.println(" nhập giá nhỏ nhất");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.println(" nhập giá lớn nhất");
        double max = Double.parseDouble(scanner.nextLine());
        for (int i = 0; i < managerProduct.listProduct.size(); i++) {
            if (managerProduct.listProduct.get(i).getPrice() >= min && managerProduct.listProduct.get(i).getPrice() <= max) {
                System.out.println(managerProduct.listProduct.get(i).toString());
            }
        }

    }
}






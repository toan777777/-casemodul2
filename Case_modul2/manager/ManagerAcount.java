package Case_modul2.manager;

import Case_modul2.IO.ReadandWriteFile;
import Case_modul2.model.Account;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManagerAcount {
    public ManagerAcount() {
        listAccount.add(new Account("toan", "7777", true));
    }
    static ReadandWriteFile readandWriteFile = new ReadandWriteFile();
    static Scanner scanner = new Scanner(System.in);
    static List<Account> listAccount = readandWriteFile.readfile();
    ManagerProduct managerProduct = new ManagerProduct();
    ManagerShopping managerShopping = new ManagerShopping();

    public void loginAdmin() {
        System.out.println(" nhập tên");
        String name = scanner.nextLine();
        System.out.println(" nhập pass");
        String pass = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < listAccount.size(); i++) {
            if (listAccount.get(i).getName().equals(name) && listAccount.get(i).getPass().equals(pass)) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println(" đăng nhập ADmin thành công");
            adminMenu();
        } else {
            System.out.println(" sai tài khoản or mật khẩu");
        }
    }

    public void showlist() {

        System.out.println(listAccount.toString());

    }

    public void registerUser() {
        System.out.println("  nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println(" nhập pass");
        String pass = scanner.nextLine();
        Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        boolean flag = false;
        for (int i = 0; i < listAccount.size(); i++) {
            if (listAccount.get(i).getName().equals(name)) {
                System.out.println("tài khoản đã tồn tại");
                flag = true;
                break;
            }
        }
        if (!flag) {
            if (p.matcher(pass).matches()) {
                System.out.println(" đăng kí thành công");
                listAccount.add(new Account(name, pass));
                readandWriteFile.writefile(listAccount);
            }else System.out.println("Mật khẩu không đúng định dạng");
        }
    }


    public void loginUser() {
        System.out.println("Nhập tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String pass = scanner.nextLine();
        boolean flag = false;
        for (Account account : listAccount) {
            if (account.getName().equals(name) && account.getPass().equals(pass)) {
                System.out.println("Đăng nhập thành công");
                flag = true;
                break;
            }
        }
        if (flag) {
            userMenu();
        } else {
            System.out.println("Tài khoản không tồn tại");
        }

    }

    public int findIndexByUsername() {
        System.out.println(" nhập tên ");
        String name = scanner.nextLine();
        for (int i = 0; i < listAccount.size(); i++) {
            if (listAccount.get(i).getName().equals(name)) {
                return i;

            }
        }
        return -1;
    }

    public void deleteAccount() {
        int index = findIndexByUsername();
        if (index == -1) {
            System.out.println(" không tìm thấy");
        } else {
            listAccount.remove(index);
            readandWriteFile.writefile(listAccount);
        }
    }

    public void editAccount() {
        int index = findIndexByUsername();
        if (index == -1) {
            System.out.println(" không tìm thấy");
        } else {
            System.out.println(" nhập mật khẩu mới");
            String newpass = scanner.nextLine();
            listAccount.get(index).setPass(newpass);
            readandWriteFile.writefile(listAccount);
        }
    }


    public void adminMenu() {
        while (true) {
            try {
                System.out.println("1. Đăng ký tk cho user");
                System.out.println("2. Xóa tài khoản user");
                System.out.println("3: Sửa tài khoản ");
                System.out.println("4: Show Account");
                System.out.println("5: Thêm sản phẩm");
                System.out.println("6: Sửa sản phẩm");
                System.out.println("7: Show Product");
                System.out.println("8: Update Product");
                System.out.println("9: Sắp xếp theo giá");
                System.out.println("10: Xóa sản phẩm ");
                System.out.println("0: thoát");
                System.out.println("---Nhập lựa chọn---");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        registerUser();
                        break;
                    case 2:
                        deleteAccount();
                        break;
                    case 3:
                        editAccount();
                        break;
                    case 4:
                        showlist();
                        break;
                    case 5:
                        managerProduct.addProduct();
                        break;
                    case 6:
                        managerProduct.editProduct();
                        break;
                    case 7:
                        managerProduct.showProduct();
                        break;
                    case 8:
                        managerProduct.updateProduct();
                        break;
                    case 9:
                        managerProduct.sort();
                        break;
                    case 10:
                        managerProduct.deletePoduct();
                        break;
                    case 0:
                        return;
                }
            }catch (NumberFormatException e){
                System.out.println(" Nhập số");
            }

        }
    }


    public void userMenu() {
        while (true) {
            try {
                System.out.println("1: Đổi mật khẩu");
                System.out.println("2 :Thêm sản phẩm vào giỏ hàng");
                System.out.println("3: Hiển thị giỏ hàng");
                System.out.println("4: Xem bill và tính tiền");
                System.out.println("5: Xóa sản phẩm khỏi giỏ hàng");
                System.out.println("6: Tìm kiếm theo loại sp");
                System.out.println("7: Tìm kiếm theo khoảng giá");
                System.out.println("0: Thoát");
                System.out.println("---Nhập lựa chon---");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        editAccount();
                        break;
                    case 2:
                        managerShopping.addProducttoCart();
                        break;
                    case 3:
                        managerShopping.showCart();
                        break;
                    case 4:
                        managerShopping.showbill();
                        break;
                    case 5: managerShopping.deleteProductCart();
                        break;
                    case 6:
                        managerShopping.seachCatagory();
                        break;
                    case 7:
                        managerShopping.seachPrice();
                        break;
                    case 0:
                        return;
                }
            }catch (NumberFormatException e){
                System.out.println("chỉ nhập số");
            }

        }
    }
}

package Case_modul2.TEST;

import Case_modul2.manager.ManagerAcount;
import Case_modul2.manager.ManagerProduct;

import java.util.Scanner;

public class Test {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws RuntimeException {

        ManagerAcount manager = new ManagerAcount();
        while (true) {
            int choice;
            System.out.println("1. Đăng nhập ADMIN");
            System.out.println("2. Đăng nhập User");
            System.out.print("Nhập : ");
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(" vui lòng nhập số");

                }
            } while (true);

            switch (choice) {
                case 1:
                    manager.loginAdmin();
                    break;
                case 2:
                    manager.loginUser();
                    break;
            }
        }

    }
}


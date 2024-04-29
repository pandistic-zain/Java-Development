package storemanagementsystem;
import java.util.Scanner;
public class FrontPage {
    
    static void HomeDisplay(){
        int opt;
        Customer customer = new Customer();
        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);

        System.out.println("\t\t\t\t************************************************");
        System.out.println("\t\t\t\t\tWelcome to the Store Management System");
        System.out.println("\t\t\t\t************************************************");
        System.out.println("\t\t\t\t\t1. Admin ");
        System.out.println("\t\t\t\t\t2. Customer");
        System.out.println("\t\t\t\t************************************************");
        opt = input.nextInt();

        while (opt == 1) {
            admin.display();
            Admin.displaymenu();
        }
        while (opt == 2) {
            ProductData.loadProductsFromFile();
            customer.buyItems();
            break;
        }
        input.close();
    }
    
}

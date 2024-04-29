package storemanagementsystem;
import java.util.Scanner;
public class Admin extends Person {
  static Scanner input = new Scanner(System.in);
  public String username = "muzammil";
  public String password = "zain";
  int tryy = 0;
  @Override
  public void display() {
    while (tryy < 3) {
      System.out.println("ENTER YOUR USERNAME");
      String user = input.next();
      System.out.println("ENTER YOUR PASSWORD");
      String pass = input.next();

      if (user.equals(username) && pass.equals(password)) {
        System.out.println("Login successful!");
        displaymenu();
        break; // Exit the loop if login is successful
      } else {
        System.out.println("Login failed. Please try again.");
        tryy++;
      }

      if (tryy == 3) {
        System.out.println("You have exceeded the maximum number of login attempts.");
        System.exit(0);
      }
    }
  }

  public static void displaymenu() {
    ProductData.loadProductsFromFile();
    StaffData. loadStaffFromFile();
    while (true) {

      System.out.println("*********************(ADMIN)***********************");
      System.out.println("\nPress 1 to Manage Staff");
      System.out.println("Press 2 to Manage Store");
      System.out.println("Press 3 to Send Email");
       System.out.println("Press 4 to Send SMS");
      System.out.println("Press 5 to Exit ");
      System.out.println("\n*************************************************");
      System.out.print("Enter your choice: ");
      int choice = input.nextInt();

      if(choice == 1) {
         while (true) {
          System.out.println("*********************************************");
          System.out.println("\nPress 1 to Add Employees ");
          System.out.println("Press 2 to Update Employees ");
          System.out.println("Press 3 to Delete Employees ");
          System.out.println("Press 4 to View Employees ");
          System.out.println("Press 5 to Exit ");
          System.out.println("\n*********************************************");
          System.out.print("Enter your choice: ");
          int ch = input.nextInt();
           switch (ch) {
            case 1:
              System.out.println("*****Adding Employees*****");
              StaffData.AddStaff();
              break;
            case 2:
              System.out.println("*****Updating Employees Details*****");
              StaffData.updateStaff();
              break;
            case 3:
              System.out.println("*****Deleting Employees*****");
              StaffData.deleteStaff();
              break;
            case 4:
              System.out.println("*****Viewing Employees Details*****");
              System.out.println("\n**************************************************************************************************************");
              StaffData.viewWholeStaff();
              System.out.println("\n**************************************************************************************************************\n\n");
              break;
            case 5:
              System.out.println("Exiting the application...");
              System.exit(ch);
              break;
    
            default:
              System.out.println("Invalid choice. Please try again.");
          }
        }
      }
    
         

       else if(choice == 2 ){
         while (true) {
          System.out.println("*********************************************");
          System.out.println("\nPress 1 to Add items ");
          System.out.println("Press 2 to Update items ");
          System.out.println("Press 3 to Delete items ");
          System.out.println("Press 4 to View items ");
          System.out.println("Press 5 to Check Available Stock ");
          System.out.println("Press 6 to Exit ");
          System.out.println("\n*********************************************");
          System.out.print("Enter your choice: ");
          int c = input.nextInt();
    
          switch (c) {
            case 1:
              System.out.println("*****Adding Products*****");
              ProductData.AddProduct();
              break;
            case 2:
              System.out.println("*****Updating Product Details*****");
              ProductData.updateProduct();
              break;
            case 3:
              System.out.println("*****Deleting Product*****");
              ProductData.deleteProduct();
              break;
            case 4:
              System.out.println("*****Viewing Product Details*****");
              ProductData.viewAllProducts();
              break;
            case 5:
              System.out.println("*****Check Stocking Stock*****");
              StockChecker.checkAllProductsStockLevel();
              break;
            case 6:
              System.out.println("Exiting the application...");
              System.exit(c);
              break;
    
            default:
              System.out.println("Invalid choice. Please try again.");
          }
         }
        }
       else if(choice==3)
       {
                String message = "This is Store Management System Created by: Muzammil Arif and Zain Ul Abdideen ";
		String subject = "Mid Term Project";
		String to = "35747@students.riphah.edu.pk";
		String from = "35515@students.riphah.edu.pk";
                String path="C:\\Users\\hp\\Desktop\\projectimage.jpg";
                SendMail sent= new SendMail();
                sent.sendAttach(message, subject, to, from, path);
           //SendMail.SendingMail();
           FrontPage.HomeDisplay();
           break;
       }
       else if (choice==4)
       {
           SentSMS.sendingsms();
           FrontPage.HomeDisplay();
           break;
       }
        else if(choice ==5){
          System.out.println("Exiting the application...");
          System.exit(choice);
          break;
        }
        else
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

package storemanagementsystem;
import java.io.*;
import java.util.Scanner;

public class ProductData  {
static Scanner input = new Scanner(System.in);
  public static int max = 0;
  public static Product[] p = new Product[100];

  public static void AddProduct() {
    System.out.print("Enter how many products you want to add: ");
    int productCount = input.nextInt();

    for (int i = max; i < max + productCount; i++) {
      System.out.println("Enter details for product " + (i + 1) + ":\n");

      p[i] = new Item(); // Create an instance of a class that implements the Product interface

      System.out.print("Enter Product ID: ");
      p[i].setId(input.nextInt());

      System.out.print("Enter Product Name: ");
      p[i].setName(input.next());

      System.out.print("Enter Product Price: ");
      p[i].setPrice(input.nextInt());

      System.out.print("Enter Product Quantity: ");
      p[i].setQty(input.nextInt());

      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt", true)); // Open the file in append mode

        // Write the product information to the file
        writer.write(p[i].getId() + "," + p[i].getName() + "," + p[i].getPrice() + "," + p[i].getQty());
        writer.newLine(); // Write a newline character to separate entries

        writer.close();
        System.out.println("Product added and stored in the file.");
      } catch (IOException e) {
        System.out.println("An error occurred while writing to the file: " + e.getMessage());
      }
    }

    // input.close(); // Close the input scanner
    max += productCount; // Increment max to reflect the total number of products
  }

  public static void loadProductsFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
      String line;

      while ((line = reader.readLine()) != null) {
        // Split the line into product details
        String[] parts = line.split(",");

        if (parts.length != 4) {
          System.out.println("Invalid data format in the file: " + line);
          continue; // Skip this line and continue with the next one
        }

        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        int price = Integer.parseInt(parts[2]);
        int quantity = Integer.parseInt(parts[3]);
        Product pro = new Item(id, name, price, quantity);
        p[max] = pro;
        max++;
      }
    } catch (FileNotFoundException e) {
      System.out.println("File 'products.txt' not found.");
    } catch (IOException e) {
      System.out.println("An error occurred while reading 'products.txt': " + e.getMessage());
    }
  }

  public static void viewAllProducts() {
    // loadProductsFromFile();
    System.out.println("Product Id\tProduct Name\tProduct Price\tQuantity");
    for (int i = 0; i < max; i++) {
      System.out
          .println((p[i].getId()) + "\t\t" + p[i].getName() + "\t\t" + (p[i].getPrice()) + "\t\t" + (p[i].getQty()));
    }
  }

  public static void updateProduct() {

    // Get the product ID to update
    System.out.print("Enter the product ID to update: ");
    int productId = input.nextInt();

    // Find the product to update
    int index = -1;
    for (int i = 0; i < max; i++) {
      if (p[i].getId() == productId) {
        index = i;
        break;
      }
    }

    // If the product was not found, print an error message and return
    if (index == -1) {
      System.out.println("Product with ID " + productId + " not found.");
      
    }

    // Prompt the user for the updated product information
    System.out.println("Enter the updated product information:");
    System.out.print("Name: ");
    String newName = input.next();
    System.out.print("Price: ");
    int newPrice = input.nextInt();
    System.out.print("Quantity: ");
    int newQuantity = input.nextInt();
    // Update the product details in the array
    p[index].setName(newName);
    p[index].setPrice(newPrice);
    p[index].setQty(newQuantity);


    // Specify the file to update
    String filePath = "products.txt";

    // Define the data you want to search for and replace
    String search = "ID=" + productId;
    String replace = "ID=" + productId + ",Name=" + newName + ",Price=" + newPrice + ",Quantity=" + newQuantity;

    try {
      // Create a temporary file to write the updated data
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      BufferedWriter writer = new BufferedWriter(new FileWriter("tempFile.txt"));

      String line;

      while ((line = reader.readLine()) != null) {
        // Check if the line contains the data you want to update
        if (line.contains(search)) {
          line = line.replace(search, replace);
        }
        writer.write(line + System.getProperty("line.separator")); // Add a newline
      }

      // Close the readers and writers
      reader.close();

      writer.close();

      // Replace the original file with the temporary file
      File originalFile = new File(filePath);
      File tempFile = new File("tempFile.txt");
      if (originalFile.delete()) {

        if (tempFile.renameTo(originalFile)) {
          System.out.println("File updated successfully.");
          // Save the updated data back to the file permanently
                FileWriter fileWriter = new FileWriter(filePath);
                for (int i = 0; i < max; i++) {
                    fileWriter.write( p[i].getId() + "," + p[i].getName() + "," + p[i].getPrice() + "," + p[i].getQty()+ System.getProperty("line.separator"));
                }
                fileWriter.close();
                System.out.println("Data saved permanently.");
        } else {
          System.err.println("Error updating the file while renaming.");
        }
      } else {
        System.err.println("Error updating the file while deleting.");
      }
    } catch (IOException e) {
      System.err.println("Error updating the file: " + e.getMessage());
    }
  }

  public static void deleteProduct() {


    // Get the product ID to delete
    System.out.print("Enter the product ID to delete: ");
    int productId = input.nextInt();

    int index = -1;
    for (int i = 0; i < max; i++) {
        if (p[i].getId() == productId) {
            index = i;
            break;
        }
    }

    if (index == -1) {
        System.out.println("Product with ID " + productId + " not found.");
       
    }

    // Shift the elements in the array to remove the deleted product
    for (int i = index; i < max - 1; i++) {
        p[i] = p[i + 1];
    }

    // Set the last element to null to clear any reference
    p[max - 1] = null;

    // Update the 'max' count to reflect the reduced product count
    max--;

    System.out.println("Product with ID " + productId + " has been deleted.");

    // Remove the deleted product from the file
    String filePath = "products.txt";
    String search = "ID=" + productId;

    try {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter("tempFile.txt"));

        String line;

        while ((line = reader.readLine()) != null) {
            // Check if the line contains the data you want to delete
            if (line.contains(search)) {
                // Skip this line to effectively delete the product data from the file
                continue;
            }
            writer.write(line + System.getProperty("line.separator")); // Add a newline
        }

        reader.close();
        writer.close();

        // Replace the original file with the temporary file
        File originalFile = new File(filePath);
        File tempFile = new File("tempFile.txt");
        if (originalFile.delete()) {
            if (tempFile.renameTo(originalFile)) {
                System.out.println("Product data removed from the file.");
                 FileWriter fileWriter = new FileWriter(filePath);
                for (int i = 0; i < max; i++) {
                    fileWriter.write( p[i].getId() + "," + p[i].getName() + "," + p[i].getPrice() + "," + p[i].getQty()+ System.getProperty("line.separator"));
                }
                fileWriter.close();
                System.out.println("Data saved permanently.");
            } else {
                System.err.println("Error updating the file while renaming.");
            }
        } else {
            System.err.println("Error updating the file while deleting.");
        }
    } catch (IOException e) {
        System.err.println("Error removing the product data from the file: " + e.getMessage());
    }

}
}

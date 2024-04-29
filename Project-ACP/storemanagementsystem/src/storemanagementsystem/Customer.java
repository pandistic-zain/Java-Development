package storemanagementsystem;
import java.io.*;
import java.util.Scanner;

class Customer {
    Scanner input = new Scanner(System.in);
  public static Product[] p = new Product[100];
  public static int max = 0;
    private String check;
    Discount discount = new Discount();

    public Customer() {
    }

    public void buyItems() {
        ProductData.viewAllProducts();
        while (true) {
            System.out.println("Enter the ID of the product you want to buy: ");
            int productId = input.nextInt();
            int totalBill = 0;

            // Find the product in the ProductData.p array
            Product product = null;
            for (int i = 0; i < ProductData.max; i++) {
                if (ProductData.p[i].getId() == productId) {
                    product = ProductData.p[i];
                    break;
                }
            }

            if (product == null) {
                System.out.println("Product with ID " + productId + " not found.");
                continue; // Continue the loop to ask for another product.
            }

            if (product.getQty() < 1) {
                System.out.println("Product is out of stock.");
                continue; // Continue the loop to ask for another product.
            }

            System.out.println("Enter the quantity you want to purchase: ");
            int quantity = input.nextInt();

            if (quantity < 1) {
                System.out.println("Quantity must be greater than 0.");
                continue; // Continue the loop to ask for another product.
            }
            if (quantity > product.getQty()) {
                System.out.println("This Specific Product Isn't Available in That Much Quantity.\n");
                buyItems();
            }

            totalBill = quantity * product.getPrice();

            if (totalBill > 300) {
                discount.applydiscount(totalBill-discount.discountAmount);
            }

            System.out.println("Your Bill is " + totalBill);

            // Update the product's quantity in memory
            product.setQty(product.getQty() - quantity);

            // Update the product's quantity in the file
            updateProductQuantityInFile(productId, product.getQty());

            System.out.println("********************************************************");
            System.out.println("Do you want to Add More Or Not (Yes | No)");
            check = input.next();

            if (check.equals("Yes")) {
                buyItems();
                break; // Exit the loop if the user says "No".
            }
            else{
                 System.out.println("\n********************************************************");
                System.out.println("\nThanks For Shopping Here. See You Again InSha Allah :)\n");
                FrontPage.HomeDisplay();
                break;
                }
        }
    }

    // Function to update the product quantity in the file
        private void updateProductQuantityInFile(int productId, int newQuantity) {
        String filePath = "products.txt";

        try {
            // Create a temporary file to write the updated data
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter("tempFile.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                // Check if the line contains the data you want to update
                if (line.contains("ID=" + productId)) {
                    line = "ID=" + productId + ",Quantity=" + newQuantity;
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
                    for (int i = 0; i < ProductData.max; i++) {
                        fileWriter.write(
                            ProductData.p[i].getId() + 
                            "," + ProductData.p[i].getName() + 
                            "," + ProductData.p[i].getPrice() + 
                            "," + ProductData.p[i].getQty() + 
                            System.getProperty("line.separator")
                        );
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
}
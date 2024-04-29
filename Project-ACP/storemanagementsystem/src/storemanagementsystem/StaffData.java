package storemanagementsystem;
import java.io.*;
import java.util.Scanner;
public class StaffData  {
  static Scanner input = new Scanner(System.in);
  public static int max = 0;
  public static Staff[] s = new Staff[100];

  public static void AddStaff() {
   

    System.out.print("Enter How Many New Employees You Want To Add: ");
    int empCount = input.nextInt();

    for (int i = max; i < max + empCount; i++) {
      System.out.println("Enter details for Employee " + (i + 1) + ":\n");

      s[i] = new Employee(); // Create an instance of a class that implements the Product interface

      System.out.print("Enter Staff ID: ");
      s[i].setId(input.nextInt());

      System.out.print("Enter Staff Name: ");
      s[i].setName(input.next());

      System.out.print("Enter Contact Number: ");
      s[i]. setContact(input.next());

      System.out.print("Enter Staff Email: ");
      s[i]. setEmail(input.next());
       System.out.print("Enter Staff Job/Rank: ");
      s[i].setJob(input.next());

      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Staff_Detail.txt", true)); // Open the file in append mode

        // Write the product information to the file
        writer.write(s[i].getId() + "," + s[i].getName() + "," + s[i].getContact() + "," + s[i]. getEmail()+ "," + s[i]. getJob());
        writer.newLine(); // Write a newline character to separate entries

        writer.close();
        System.out.println("Staff Data added and stored in the file.");
      } catch (IOException e) {
        System.out.println("An error occurred while writing to the file: " + e.getMessage());
      }
    }
    max += empCount; // Increment max to reflect the total number of products
  }

  public static void loadStaffFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("Staff_Detail.txt"))) {
      String line;

      while ((line = reader.readLine()) != null) {
        // Split the line into product details
        String[] parts = line.split(",");

        if (parts.length != 5) {
          System.out.println("Invalid data format in the file: " + line);
          continue; // Skip this line and continue with the next one
        }

        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        String contact = parts[2];
        String Email = parts[3];
        String Job = parts[4];
        Staff stf = new Employee(id, name, contact,Email,Job);
        s[max] = stf;
        max++;
      }
    } catch (FileNotFoundException e) {
      System.out.println("File 'Staff_Detail.' not found.");
    } catch (IOException e) {
      System.out.println("An error occurred while reading 'Staff_Detail': " + e.getMessage());
    }
  }

  public static void viewWholeStaff() {
    
    System.out.println("Staff ID\tStaff Name\tContact Number \t\tStaff Email \t\t\t\tStaff Job/Rank ");
    for (int i = 0; i < max; i++) {
      System.out.println((s[i].getId()) + "\t\t" + s[i].getName() + "\t\t" + (s[i].getContact() )+ "\t\t" + (s[i]. getEmail())+ "\t\t" + ( s[i]. getJob()));
    }
  }

  public static void updateStaff() {  
    System.out.print("Enter the ID Of Staff to Update Data: ");
    int staffId = input.nextInt();

    // Find the product to update
    int index = -1;
    for (int i = 0; i < max; i++) {
      if (s[i].getId() == staffId) {
        index = i;
        break;
      }
    }
    if (index == -1) {
      System.out.println("Employee with ID " + staffId + " not found.");
      
    }

    // Prompt the user for the updated product information
    System.out.println("Enter the updated product information:");
    System.out.print("Name: ");
    String newName = input.next();
    System.out.print("Contact: ");
    String newContact = input.next();
     System.out.print("Email: ");
    String newEmail = input.next();
     System.out.print("Job/Rank: ");
    String newJob = input.next();
    // Update the product details in the array
    s[index].setName(newName);
    s[index].setContact(newContact);
    s[index].setEmail(newEmail);
s[index].setJob(newJob);

    // Specify the file to update
    String filePath = "Staff_Detail.txt";

    // Define the data you want to search for and replace
    String search = "ID=" + staffId;
    String replace = "ID=" + staffId + ",Name=" + newName + ",Contact=" + newContact + ",Email=" + newEmail+ ",Job/Rank=" + newJob;
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
                    fileWriter.write( s[i].getId() + "," + s[i].getName() + "," + s[i].getContact() + "," + s[i].getEmail()+ "," + s[i].getJob()+ System.getProperty("line.separator"));
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

  public static void deleteStaff() {
   

    // Get the product ID to delete
    System.out.print("Enter the Employee ID you Want to Delete: ");
    int staffId = input.nextInt();

    int index = -1;
    for (int i = 0; i < max; i++) {
        if (s[i].getId() == staffId) {
            index = i;
            break;
        }
    }

    if (index == -1) {
        System.out.println("Employee with ID " + staffId + " not found.");
        
    }

    // Shift the elements in the array to remove the deleted product
    for (int i = index; i < max - 1; i++) {
        s[i] = s[i + 1];
    }

    // Set the last element to null to clear any reference
    s[max - 1] = null;

    // Update the 'max' count to reflect the reduced product count
    max--;

    System.out.println("Product with ID " + staffId + " has been deleted.");

    // Remove the deleted product from the file
    String filePath = "Staff_Detail.txt";
    String search = "ID=" + staffId;

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
                    fileWriter.write( s[i].getId() + "," + s[i].getName() + "," + s[i].getContact() + "," + s[i].getEmail()+ "," + s[i].getJob()+ System.getProperty("line.separator"));
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


// SAP-35515 
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileMover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the source path:");
        String sourcePath = scanner.nextLine();

        System.out.println("Enter the destination path:");
        String destinationPath = scanner.nextLine();

        File source = new File(sourcePath);
        File destination = new File(destinationPath);

        if (!source.exists()) {
            System.out.println("Source does not exist.");
            return;
        }

        if (!destination.exists()) {
            System.out.println("Destination Location does not exist.");
            return;
        }

        try {
            if (source.isDirectory()) {
                // Move a Folder
                Path sourceDir = source.toPath();
                Path destDir = destination.toPath().resolve(sourceDir.getFileName());
                Files.move(sourceDir, destDir, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Moved successfully.");
            } else {
                // Move a file
                Path sourceFile = source.toPath();
                Path destFile = destination.toPath().resolve(sourceFile.getFileName());
                Files.move(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Moved successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while moving.");
        } finally {
            scanner.close();
        }
    }
}
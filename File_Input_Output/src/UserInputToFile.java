import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInputToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "user_input.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            boolean addMore = true;
            while (addMore)
            {
                System.out.print("Enter some text: ");
                String userInput = scanner.nextLine().trim();
                writer.write(userInput);
                writer.newLine();
                System.out.print("Do you want to add more content? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                addMore = response.equals("yes");
            }
            System.out.println("Input saved to " + filename);
        }
        catch (IOException e)
        {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            System.out.println("Content of " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}

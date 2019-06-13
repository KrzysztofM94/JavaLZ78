import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputData {
    private File filePath;
    private Scanner scanner = new Scanner(System.in);

//C:\Users\Kriss\Desktop\Test.txt
//C:\Users\Kriss\Desktop\Ojciec.txt
    public void getPatch() {
        System.out.println("Enter the path to the file.");
        filePath = new File(scanner.next());
    }

    public String getText() {

        try {
            Files.lines(Paths.get("newfile.txt")).forEach(System.out::println);
            Files.lines(new File("newfile.txt").toPath())
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String txt = null;
        String buffor="";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"ISO-8859-1"));

            while ((txt = reader.readLine()) != null) {
                buffor+=txt;
            }
            System.out.println("Operation Completed.");
            return buffor;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Operation failed.");
            return buffor;
        }

    }

    public static void main(String[] args) {

        InputData inputData = new InputData();
        inputData.getPatch();
        System.out.println(inputData.getText());
    }
}

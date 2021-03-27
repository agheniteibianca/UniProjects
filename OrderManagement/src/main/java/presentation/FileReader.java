package presentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileReader {
    private Scanner myReader;
    private File readFile;


    public FileReader(String a){
        readFile = new File(a);
        try {
            myReader = new Scanner(readFile);
        } catch (FileNotFoundException e) {
            System.out.println("nu am putut crea readerul");
        }
        readInputData();
    }
    private void readInputData(){

        while (myReader.hasNext()) {
            String line = myReader.nextLine();
            Parser myParser= new Parser(line);
            myParser.check_comand();
        }
    }
}

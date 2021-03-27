package Data;

import java.io.*;

public class FileWriterClass {
    Writer writer = null;

    public FileWriterClass(String text){
        try{
             writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bill.txt"), "utf-8"));
            writer.write(text);
        } catch (IOException ex) {
            // Report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {}
        }
    }


}

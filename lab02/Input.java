package gr8373.zhmaev.lab02;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Input {
    private BufferedReader inputStream = null;
    private String[] data = new String[4];   
    
    public Input(String fileName) {
           try {
               inputStream = new BufferedReader(new FileReader(fileName));
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }
           for (int i=0;i<4;i++) {
               try {
                   data[i]=inputStream.readLine();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
    }    
    
    public String[] getData() {
        return data;
    }
              
}

package gr8373.zhmaev.lab02;

import java.io.*;
import java.text.*;
import java.util.*;

public class Document {    

    private BufferedReader inputStream;
    private String[] data = new String[4];       
    
    public Document(String fileName) {
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
           //this.setData(this.getData());
           this.isOld();
           this.isSmart();  
    }
    
    public String[] getData() {
        return data;
    }    
    public void setData(String[] data) {
        this.data = data;
    }

    public String getAuthor() {
        return data[0];
    }
    public String getTitle() {
        return data[1];
    }
    public String getYear() {
        return data[2];
    }
    public String getText() {
        return data[3];
    }
    
    private boolean tooOld;
    private boolean tooSmart;
    private int symbols;
    private int words;
    
    private int takeOutWords(String string,BreakIterator iterator) {
        int count = 0;
        iterator.setText(string);
        int start = iterator.first();
        int current = iterator.next();
        while (current != BreakIterator.DONE) {
            String word = string.substring(start,current);
            if (Character.isLetterOrDigit(word.charAt(0))) {
                count++;
            }
            start = current;
            current = iterator.next();
        }
        return count;
    }
    private void isOld() {
        GregorianCalendar year = new GregorianCalendar();
        int today = year.get(Calendar.YEAR);
        if ((today-5)> Integer.valueOf(data[2])) {
            tooOld = true;
        }
    }
    private void isSmart() {
        symbols =data[3].trim().length();
        words = takeOutWords(data[3],BreakIterator.getWordInstance());
        if ((float)symbols/words>7) {
            tooSmart=true;
        }
    }
    public int getSymbols() {
        return symbols;
    }
    public int getWords() {
        return words;
    }
    public boolean getOld() {
        return tooOld;
    }
    public boolean getSmart() {
        return tooSmart;
    }
    
}

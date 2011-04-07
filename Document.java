package gr8373.zhmaev.lab02;

import java.io.*;
import java.text.*;
import java.util.*;

public class Document {

    private boolean tooOld;
    private boolean tooSmart;
    private int symbols;
    private int words;
    private String author;
    private String title;
    private String year;
    private String text;

    public Document(String fileName) throws IOException {
        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
        this.setAuthor(inputStream.readLine());
        this.setTitle(inputStream.readLine());
        this.setYear(inputStream.readLine());
        this.setText(inputStream.readLine());
        this.isOld();
        this.isSmart();
    }

    private int takeOutWords(String string) {
        BreakIterator iterator = BreakIterator.getWordInstance();
        int count = 0;
        iterator.setText(string);
        int start = iterator.first();
        int current = iterator.next();
        while (current != BreakIterator.DONE) {
            String word = string.substring(start, current);
            if (Character.isLetterOrDigit(word.charAt(0))) {
                count++;
            }
            start = current;
            current = iterator.next();
        }
        return count;
    }

    private void isOld() {
        if ((Calendar.getInstance().get(Calendar.YEAR) - 5) > Integer.valueOf(getYear())) {
            tooOld = true;
        }
    }

    private void isSmart() {
        symbols = getText().replace(" ","").length();
        words = takeOutWords(this.getText());
        if (symbols / words >= 7) {
            tooSmart = true;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String arg) {
        author = arg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String arg) {
        title = arg;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String arg) {
        year = arg;
    }

    public String getText() {
        return text;
    }

    public void setText(String arg) {
        text = arg;
    }
}

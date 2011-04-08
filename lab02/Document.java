package gr8373.zhmaev.lab02;

import java.io.*;
import java.text.*;
import java.util.*;

public class Document {

    private boolean tooOld;
    private boolean tooSmart;
    private int symbols;
    private int words;
    private final String author;
    private final String title;
    private final String year;
    private final String text;

    public Document(String fileName) throws IOException {
        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
        author = inputStream.readLine();
        title = inputStream.readLine();
        year = inputStream.readLine();
        text = inputStream.readLine();
        if ((Calendar.getInstance().get(Calendar.YEAR) - 5) > Integer.valueOf(getYear())) {
            tooOld = true;
        }
        symbols = getText().replace(" ","").length();
        words = countWords(this.getText());
        if (symbols / words >= 7) {
            tooSmart = true;
        }
    }

    private int countWords(String string) {
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

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getText() {
        return text;
    }
}

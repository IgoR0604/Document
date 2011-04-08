package gr8373.zhmaev.lab02;
import gr8373.zhmaev.lab02.builder.*;

import java.io.*;
import java.util.Scanner;


public class Test {

   
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String enterName = enter.next();
        Document doc = new Document(enterName);
        Builder builder = new Builder();
        System.out.println("1-для text,2-для html,3-для xml");
        Scanner scannerBuild = new Scanner(System.in);
        System.out.print("Выберите действие: ");
        int scanBuild=scannerBuild.nextInt();
        switch (scanBuild) {
        case 1:
               builder = new TextBuilder();
               break;
        case 2:
               builder = new HtmlBuilder();
               break;
        case 3:
               builder = new XmlBuilder();
               break;
        }
        System.out.println("1-для вывода в файл,2-для вывода на консоль");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите действие: ");
        int scan = scanner.nextInt();
        switch (scan) {
        case 1:      
               
                   if (scanBuild==1) {
                       try {
                        builder.build(doc,new FileWriter("file.txt"));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                   }
                   if (scanBuild==2) {
                       try {
                        builder.build(doc,new FileWriter("file.html"));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                   }
                   if (scanBuild==3) {
                       try {
                        builder.build(doc,new FileWriter("file.xml"));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                   }
            
               break;
        case 2:
               builder.build(doc,new OutputStreamWriter(System.out));
               break;
        }
    }
}
    

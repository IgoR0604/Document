package gr8373.zhmaev.lab02.builder;
import gr8373.zhmaev.lab02.Builder;;

public class TextBuilder extends Builder {
    protected void buildHeader(boolean tooSmart) {
        writer.write(document.getAuthor());
        writer.write("\r\n");
        writer.write(document.getTitle());
        writer.write("\r\n");
        if (document.getOld()) {
            writer.write("!");
        }
        writer.write(document.getYear());
        writer.write("\r\n");
    }
    protected void buildBody(boolean tooSmart) {
        if (document.getSmart()) {
            writer.write("!");
        }
        writer.write(document.getText());
        writer.write("\r\n");
    }
    protected void buildFooter() {
        String space="";
        for(int i=0;i<document.getSymbols()-3;i++) {
            space+=" ";
        }
        writer.write(document.getSymbols()+space+document.getWords());   
    }
}

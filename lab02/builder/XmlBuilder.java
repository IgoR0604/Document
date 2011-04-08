package gr8373.zhmaev.lab02.builder;

import gr8373.zhmaev.lab02.Builder;;

public class XmlBuilder extends Builder {
    protected void buildHeader(boolean tooSmart) {
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
        writer.write("<body>\r\n");
        writer.write(" <buildHeader>\r\n");
        writer.write("  "+document.getAuthor());
        writer.write("\r\n </buildHeader>\r\n");
        writer.write(" <buildHeader>\r\n");
        writer.write("  "+document.getTitle());
        writer.write("\r\n </buildHeader>\r\n");
        if (document.getOld()) {
            writer.write(" <buildHeader old = \"old\">\r\n");
        }
        else {
            writer.write(" <buildHeader>\r\n");
        }
        writer.write("  "+document.getYear());
        writer.write("\r\n </buildHeader>\r\n");
    }
    protected void buildBody(boolean tooSmart) {
        if (document.getSmart()) {
            writer.write(" <buildBody smart=\"smart\">\r\n");
        }
        else {
            writer.write(" <buildBody>\r\n");   
        }    
        writer.write("  "+document.getText());
        writer.write("\r\n </buildBody>\r\n");
    }
    protected void buildFooter() {
        writer.write(" <buildFooter>\r\n");
        writer.write("  "+document.getSymbols()+"                                "+document.getWords());
        writer.write("\r\n </buildFooter>\r\n");
        writer.write("</body>");
    }
}

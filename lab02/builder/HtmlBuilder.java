package gr8373.zhmaev.lab02.builder;
import gr8373.zhmaev.lab02.Builder;

public class HtmlBuilder extends Builder {
    protected void buildHeader(boolean tooSmart) {
        writer.write("<html>\r\n<head>\r\n<title>File</title>\r\n</head>\r\n<body>\r\n<p align=center>\r\n<font size=4>\r\n");
        writer.write(document.getAuthor());
        writer.write("\r\n<BR>\r\n");
        writer.write(document.getTitle());
        writer.write("\r\n<BR>\r\n");
        if (document.getOld()) {
            writer.write("<span style =\"background: silver\">");
            writer.write(document.getYear());
            writer.write("</span style =\"background: silver\">\r\n");
        }
        else {
            writer.write(document.getYear()+"\r\n");
        }    
        writer.write("<BR>\r\n");
    }
    protected void buildBody(boolean tooSmart) {
        if (document.getSmart()) {
            writer.write("<span style =\"background: silver\">");
            writer.write(document.getText());
            writer.write("</span style =\"background: silver\">\r\n");
        }
        else {
            writer.write(document.getText()+"\r\n");
        }
        writer.write("<BR>\r\n");
    }
    protected void buildFooter() {
        writer.write("<pre>\r\n<p align=center>");
        writer.write(String.valueOf(document.getSymbols()));
        writer.write("                       ");
        writer.write(String.valueOf(document.getWords()));
        writer.write("</p align=center>\r\n</pre>\r\n");
        writer.write("</font size=4>\r\n</p align=center>\r\n</body>\r\n</html>");   
    }
}

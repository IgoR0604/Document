package gr8373.zhmaev.lab02;

import java.io.*;

public class Builder {
   
    protected Document document;
    protected PrintWriter writer;

    public void build(Document document, Writer out) {
        this.document = document;
        this.writer = new PrintWriter(new BufferedWriter(out));
        boolean tooOld=document.getOld();
        buildHeader(tooOld);
        boolean tooSmart = document.getSmart();
        buildBody(tooSmart);
        buildFooter();
        writer.close();
    }

    protected void buildFooter() {
        // TODO Auto-generated method stub    
    }

    protected void buildBody(boolean tooSmart) {
        // TODO Auto-generated method stub        
    }

    protected void buildHeader(boolean tooOld) {
        // TODO Auto-generated method stub        
    }
}

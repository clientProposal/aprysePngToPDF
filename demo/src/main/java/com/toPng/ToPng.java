package com.toPng;

import com.pdftron.pdf.*;
import io.github.cdimascio.dotenv.Dotenv;

public class ToPng {
    public static void main(String[] args) throws Exception {
        Dotenv dotenv = Dotenv.configure()
            .directory("./")
            .ignoreIfMissing()
            .load();   
        String token = dotenv.get("PDFTRON_KEY");
        PDFNet.initialize(token); 
        PDFDoc doc = new PDFDoc(System.getProperty("user.dir") + "/src/main/resources/input.pdf");
        PDFDraw draw = new PDFDraw();
        Page pg = doc.getPage(1);
        draw.export(pg, System.getProperty("user.dir") + "/src/main/resources/output/output.png");
    }
}

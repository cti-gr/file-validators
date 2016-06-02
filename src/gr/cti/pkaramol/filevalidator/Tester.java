package gr.cti.pkaramol.filevalidator;

import gr.cti.pkaramol.filevalidator.PdfFileValidator;

/**
 * Class that demonstrates usage of file validation classes
 * 
 * @author pkaramol
 */
public class Tester {
    
    private final static String testFilePath = "/home/pkaramol/Desktop/dspacemanual.pdf";
    
    public static void main(String args[]) {
        
        PdfFileValidator pdfv = new PdfFileValidator();
        
        System.out.println(pdfv.isValidExtension(testFilePath));
    }
    
}

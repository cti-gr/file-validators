package gr.cti.pkaramol.filevalidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that validates pdf files. 
 * Validation is based on the initial byte sequence of a pdf File: %PDF-
 * It also checks that the file is not empty as also that its length exceeds
 * 4 bytes
 * 
 * @author pkaramol
 */
public class PdfFileValidator extends FileValidator {
    
    String fileExtension = "pdf";        
    boolean isValid = false;
    
    @Override
    public boolean isValidExtension(String filePath) {
        byte data[] = null;
        
        try {
            data = this.getFileAsByteArray(filePath);
        } catch (IOException ex) {
            Logger.getLogger(PdfFileValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (            
            data != null &&
            data.length > 4 &&
            data[0] == 0x25 && // %
            data[1] == 0x50 && // P
            data[2] == 0x44 && // D
            data[3] == 0x46 && // F
            data[4] == 0x2D // -
        )
            isValid = true;
       
        return isValid;
        
    }
    
}

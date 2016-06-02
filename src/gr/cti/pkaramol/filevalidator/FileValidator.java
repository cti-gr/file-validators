package gr.cti.pkaramol.filevalidator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 * Abstract class for all file validation classes.
 * Validation is based on parsing the file as a byte array, a process supported
 * by the java.nio library.
 * Each derived class should implement the isValidExtension method according to
 * the particularities of the file being processed.
 * 
 * @author pkaramol
 */
public abstract class FileValidator {    
   
   
    /**
     * Method for parsing the file to be validated as an array of bytes
     * 
     * @param filePath: The full path to the file to be validated
     * @return: byte array of the file parsed     * 
     * @throws IOException 
     */
    protected byte[] getFileAsByteArray(String filePath) throws IOException {
        
        File file = new File(filePath); 
        Path path = Paths.get(file.getAbsolutePath()); 
        byte[] data = Files.readAllBytes(path); 
        return data;
    }
    
    public abstract boolean isValidExtension(String filePath);    
}

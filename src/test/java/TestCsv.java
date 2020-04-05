
import java.io.IOException;
import org.junit.Test;
import rs.ugligovic.csvparser.exception.BadCsvException;
import rs.ugligovic.csvparser.Csv;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author UrosGligovic
 */

public class TestCsv {
    
    @Test
    public void initalTest() throws IOException {
        
        Csv csv = new Csv("C:\\Users\\User\\Documents\\BigFilesPlay\\csvExample.txt",",");
        
        csv.stream()
            .forEach(x->System.out.println(x.get("prva")));
    }
    
}

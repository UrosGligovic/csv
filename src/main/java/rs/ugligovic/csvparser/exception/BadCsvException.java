/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ugligovic.csvparser.exception;

/**
 *
 * @author UrosGligovic
 */
public class BadCsvException extends RuntimeException{

    public BadCsvException(String reason) {
        super(reason);    
    }
    
    
    
}

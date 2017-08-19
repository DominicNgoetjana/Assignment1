
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dominic
 */
public class DataFileGenerator {
    
    public void writeToFile() throws IOException {
        BufferedWriter bw = new BufferedWriter( new FileWriter("data.file") );
        int numData = generateNumber();
        bw.write(numData + "\n");
        for (int i = 0; i < numData; i++) {
            bw.write(String.valueOf(i+1) + " " + generateNumber() + "\n");
        }
        bw.close();
    }
    
    public int generateNumber() {
        Random rand = new Random();
        int result;
        do {            
            result = rand.nextInt(90)+11;
        } while ( result%2==0 );
        return result;
    }
    
    public static void main(String[] args) {
        DataFileGenerator dtf = new DataFileGenerator();
        try {
            dtf.writeToFile();
        } catch (Exception e) {
        }
    }
    
}


import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class SerialNoiseFilter {

    String dataFile, outputFile;
    int filterSize;

    public void readData() {
        try {
            Scanner in = new Scanner ( new File ("data.file") );
            int numData = Integer.parseInt( in.nextLine() );
            double[] data = new double[numData];
            String line;
            for (int i = 0; i < numData; i++) {
                line = in.nextLine();
                data[i] = Double.parseDouble( line.substring( line.indexOf(" ")+1, line.length() ) );
            }
            //System.out.println( Arrays.toString( generateFilteredArray(data) ) );
        } catch (Exception e) {
        }
    }
    
    public double[] generateFilteredArray( double[] original ) {
        double[] result = new double[original.length];                          // new, modified data
        int borderVal = (filterSize-1)/2;                                       // number of elements to exclude on either side
        for (int i = 0; i < original.length; i++) {
            if ( (i < borderVal) || (i > (original.length-borderVal-1) ) ) {    // falls within border
                result[i] = original[i];                                        // copy as is
            } else {
                result[i] = medianFilter( Arrays.copyOfRange(original, i-borderVal, i+borderVal+1) ); // generates array of length filterSize, from the left to the right of the current element and returns median
            }
        }
        return result;
    }
    
    public void writeData( double[] newData ) {
        
    }
    
    public double medianFilter( double[] array ) {
        Arrays.sort(array);
        return array[ array.length/2 ];
    }

    public static void main(String[] args) {
        SerialNoiseFilter snf = new SerialNoiseFilter();
        //snf.dataFile = args[0];
        //snf.filterSize = Integer.parseInt(args[1]);
        //snf.outputFile = args[2];
        //snf.readData();
        double[] arr = {3, 4, 2, 54, 23, 56, 32}; // 3 , 3, 4, 23, 54, 32, 32
        snf.filterSize = 3;
        System.out.println( Arrays.toString( snf.generateFilteredArray(arr) ) );
        //System.out.println("median is " + snf.medianFilter(arr));
    }

}//eof

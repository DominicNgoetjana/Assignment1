
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
            //System.out.println( Arrays.toString(data) );
        } catch (Exception e) {
        }
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
        //double[] arr = {15,3,67,43,12};
        //System.out.println("median is " + snf.medianFilter(arr));
    }

}//eof

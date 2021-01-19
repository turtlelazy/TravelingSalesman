import java.util.ArrayList;
import java.util.Scanner;

public class CityMatrix{
    private ArrayList<ArrayList<Integer>> cityDistances = 
            new ArrayList<ArrayList<Integer>>();
    
    private ArrayList<String> cities = new ArrayList<String>();
    CityMatrix(Scanner txtFile){
        runScanner(txtFile);
    }

    public void runScanner(Scanner txtFile){
        while(txtFile.hasNextLine()){
            String city0 = txtFile.next();

            txtFile.next(); // skips the "to"

            String city1 = txtFile.next();

            txtFile.next(); //skips the "="

            if (!cities.contains(city0)) {
                cities.add(city0);
            }
            
            if (!cities.contains(city1)) {
                cities.add(city1);
            }

            int distance = Integer.parseInt(txtFile.next());

            cityDistances.get(cities.indexOf(city0))
                         .set(cities.indexOf(city0), distance);

        }
    }

    public int get(int x, int y){
        return cityDistances.get(x).get(y);
    }

}
import java.util.ArrayList;
import java.util.Scanner;

public class CityMatrix{
    private int[][] cityDistances;
    
    private ArrayList<String> cities = new ArrayList<String>();
    CityMatrix(Scanner txtFile){
        cityGrabber(txtFile);
        insertDistances(txtFile);
    }

    public void cityGrabber(Scanner txtFile){
        while(txtFile.hasNext()){
            String city0 = txtFile.next();

            txtFile.next(); // skips the "to"

            String city1 = txtFile.next();

            txtFile.next(); //skips the "="
            txtFile.next(); //skips the distance
            if (!cities.contains(city0)) {
                cities.add(city0);
            }

            if (!cities.contains(city1)) {
                cities.add(city1);
            }

            cityDistances = new int[cities.size()][cities.size()];
        }
    }

    public void insertDistances(Scanner txtFile){
        String city0 = txtFile.next();

        txtFile.next(); // skips the "to"

        String city1 = txtFile.next();

        txtFile.next(); // skips the "="

        int distance = Integer.parseInt(txtFile.next());

        cityDistances[cities.indexOf(city0)][cities.indexOf(city1)] = distance;
        cityDistances[cities.indexOf(city1)][cities.indexOf(city0)] = distance;
    }

    public int get(int x, int y){
        return cityDistances[x][y];
    }

}
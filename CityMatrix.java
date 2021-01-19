/// Edited pushed version

import java.util.ArrayList;
import java.util.Scanner;

public class CityMatrix{
    private int[][] cityDistances;

    private ArrayList<String> cities = new ArrayList<String>();
    CityMatrix(Scanner txtFile){
        insertDistances(cityGrabber(txtFile));
    }

    public ArrayList<int[]> cityGrabber(Scanner txtFile){
        ArrayList<int[]> citiesInfo = new ArrayList<int[]>();
        while(txtFile.hasNext()){
            String city0 = txtFile.next();

            txtFile.next(); // skips the "to"

            String city1 = txtFile.next();

            txtFile.next(); //skips the "="
            int distance = Integer.parseInt(txtFile.next()); //skips the distance
            if (!cities.contains(city0)) {
                cities.add(city0);
            }

            if (!cities.contains(city1)) {
                cities.add(city1);
            }
            int [] x = {cities.indexOf(city0),cities.indexOf(city1),distance};
            citiesInfo.add(x);
        }
        cityDistances = new int[cities.size()][cities.size()];
        return citiesInfo;
    }

    public void insertDistances(ArrayList<int[]> citiesInfo){
        for(int i = 0; i < citiesInfo.size();i++){
            int[] current = citiesInfo.get(i);
            cityDistances[current[0]][current[1]] = current[2];
            cityDistances[current[1]][current[0]] = current[2];
        }
    }

    public int get(int x, int y){
        return cityDistances[x][y];
    }

    public int size(){
        return cities.size();
    }

}

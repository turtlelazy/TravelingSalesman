/// Edited pushed version

import java.util.ArrayList;
import java.util.Scanner;

public class CityMatrix{
    private int[][] cityDistances;
    private int largestDistance = 0;

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
            if (current[2] > largestDistance){
                largestDistance = current[2];
            }
        }
    }

    public int get(int x, int y){
        return cityDistances[x][y];
    }

    public int size(){
        return cities.size();
    }

    //This code is very dirty but works to see the data we're working with for testing purposes
    public String toString(){
        String returnString = "    ";
        int length = String.valueOf(largestDistance).length();

        for(int i = 0; i < size();i++){
            String city = cities.get(i);
            if (city.length() > 3) {
                city = city.substring(0, 3);
            }

            returnString += city;

            for(int z = 0; z < length - city.length() + 2; z++){
                returnString += " ";
            }

        }

        returnString += "\n";

        for (int x = 0; x < size(); x++) {

            String city = cities.get(x);
            if (city.length() > 3) {
                city = city.substring(0, 3);
            }
            
            returnString += city;

            for(int z = 0; z < 2 - city.length() + 2; z ++){
                returnString += " ";
            }
            
            for (int y = 0; y < size(); y++) {
                returnString += (get(x, y));
                for (int z = 0; z < length - String.valueOf(get(x,y)).length() + 2; z++) {
                    returnString += " ";
                }
            }
            returnString += ("\n");
        }


        return returnString;
    }

}

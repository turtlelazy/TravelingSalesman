import java.util.Scanner;
import java.util.ArrayList;

public class TravellingSalesman{

  //helper method to find the smallest city, from a city
  private static int findSmallestFrom(CityMatrix data, int x, ArrayList<Integer> added){
    
    //grabs the array of the city we're working with 
    int[] city = data.getArray(x);

    //helper variables to figure out which city is the closest
    int smallest = -1;
    int smallestDistance = -1;

    //loops through the city's array and looks for the one with the smallest distance
    for (int i = 0; i < city.length; i++){
      if ((city[i] < smallestDistance || smallestDistance == -1) && !added.contains(i) && x != i){
        smallest = i;
        smallestDistance = city[i];
      }
    }

    return smallest;
  }

  private static int solver(CityMatrix data){
    int shortestDistance = -1;

    //loops through all the cities' arrays (first loop)
    for (int i = 0; i < data.cities.size(); i++){

      //looks for distance of path of current city
      int distance = 0;
      int from = i;
      ArrayList<Integer> added = new ArrayList<Integer>();

      //loops through to look for current shortest path
      for (int v = 0; v < data.cities.size() - 1; v ++){
        int nextCityCode = findSmallestFrom(data, from, added);
        //adds to sum distance 
        distance = distance + data.get(from, nextCityCode);
        added.add(from);
        from = nextCityCode;
      }

      //checks to see if this path is an improvement and updates shortestDistance if so
      if (distance < shortestDistance || shortestDistance == -1){
        shortestDistance = distance;
      }
    }

    return shortestDistance;
  }

  public static void main(String[] args){
    CityMatrix data = new CityMatrix(new Scanner(System.in));

    System.out.println(solver(data));
  }
}

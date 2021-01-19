import java.util.Scanner;
import java.util.ArrayList;

public class TravellingSalesman{
  private static int findSmallestFrom(CityMatrix data, int x, ArrayList<Integer> added){
    int[] city = data.getArray(x);
    int smallest = -1;
    int smallestDistance = -1;

    for (int i = 0; i < city.length; i++){
      if ((city[i] < smallestDistance || smallestDistance == -1) && added.indexOf(i) == -1 && x != i){
        smallest = i;
        smallestDistance = city[i];
      }
    }

    return smallest;
  }

  private static int solver(CityMatrix data){
    int shortestDistance = -1;

    for (int i = 0; i < data.cities.size(); i++){
      int distance = 0;
      int from = i;
      ArrayList<Integer> added = new ArrayList<Integer>();

      for (int v = 0; v < data.cities.size() - 1; v ++){
        int nextCityCode = findSmallestFrom(data, from, added);
        distance = distance + data.get(from, nextCityCode);
        added.add(from);
        from = nextCityCode;
      }

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

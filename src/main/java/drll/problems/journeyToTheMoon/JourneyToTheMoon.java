
package drll.problems.journeyToTheMoon;

import java.io.*;
import java.util.*;

public class JourneyToTheMoon {

    // Complete the journeyToMoon function below.
    static long journeyToMoon(int n, int[][] astronaut) {

        long result = 0;

        // Get big cities
        Set<Set<Integer>> cities = processAllPairs(astronaut);

        // Counting pair for big cities
        Set<Integer>[] citiesArray = cities.toArray(new HashSet[cities.size()]);
        long bigCitiesPopulation = citiesArray[citiesArray.length - 1].size();
        for (int i = citiesArray.length - 2; i >= 0 ; i--) {
            result += citiesArray[i].size() * bigCitiesPopulation;
            bigCitiesPopulation += citiesArray[i].size();
        }

        // Count small cities (with only one astronaut)
        long smallCities = n - bigCitiesPopulation;

        // adding to result:
        // - pair formed in small cities(combination),
        // - pairs formed between small and big cities
        return result +
                combinationsNin2(smallCities) +
                bigCitiesPopulation * smallCities;
    }

    private static long combinationsNin2(long n){
        return (n - 1) * n / 2;
    }

    private static Set<Set<Integer>> processAllPairs(int[][] astronaut) {
        HashMap<Integer, Set<Integer>> result = new HashMap<>();

        // reading astronauts pairs
        for(int i = 0; i < astronaut.length; i++){
            Integer firstAstronaut = astronaut[i][0],
                    secondAstronaut = astronaut[i][1];

            if(areBothRegisteredAstronauts(result, firstAstronaut, secondAstronaut)){
                // astronauts are both registered
                mergeAstronautsCities(result, firstAstronaut, secondAstronaut);
            }
            else {
                if (areBothNewAstronauts(result, firstAstronaut, secondAstronaut)) {
                    // astronauts are both new, then create a city for them
                    createNewCity(result, firstAstronaut, secondAstronaut);
                }
                else {
                    addNewAstronautToCity(result, firstAstronaut, secondAstronaut);
                }
            }
        }

        return new HashSet<>(result.values());
    }

    private static void mergeAstronautsCities(HashMap<Integer, Set<Integer>> astronautsByCity,
                                              Integer firstAstronaut, Integer secondAstronaut) {

        Set<Integer> firstAstronautCity = astronautsByCity.get(firstAstronaut);

        if(firstAstronautCity.equals(astronautsByCity.get(secondAstronaut))){
            return;
        }

        firstAstronautCity.addAll(astronautsByCity.get(secondAstronaut));

        for (Integer astronaut : astronautsByCity.get(secondAstronaut)) {
            astronautsByCity.put(astronaut, firstAstronautCity);
        }
    }

    private static void createNewCity(HashMap<Integer, Set<Integer>> astronautsByCity,
                                      Integer firstAstronaut, Integer secondAstronaut) {
        Set<Integer> city = new HashSet<>();

        city.add(firstAstronaut);
        city.add(secondAstronaut);

        astronautsByCity.put(firstAstronaut, city);
        astronautsByCity.put(secondAstronaut, city);
    }

    private static void addNewAstronautToCity(HashMap<Integer, Set<Integer>> astronautsByCity,
                                              Integer firstAstronaut, Integer secondAstronaut) {
        Set<Integer> city;
        if(astronautsByCity.containsKey(firstAstronaut)){
            city = astronautsByCity.get(firstAstronaut);
            astronautsByCity.put(secondAstronaut, city);
            city.add(secondAstronaut);
        }
        else{
            city = astronautsByCity.get(secondAstronaut);
            astronautsByCity.put(firstAstronaut, city);
            city.add(firstAstronaut);
        }
    }

    private static boolean areBothRegisteredAstronauts(HashMap<Integer, Set<Integer>> astronautsByCity,
                                                       Integer firstAstronaut, Integer secondAstronaut) {
        return astronautsByCity.containsKey(firstAstronaut)  &&
                astronautsByCity.containsKey(secondAstronaut);
    }

    private static boolean areBothNewAstronauts(HashMap<Integer, Set<Integer>> astronautsByCity,
                                                Integer firstAstronaut, Integer secondAstronaut) {
        return !(astronautsByCity.containsKey(firstAstronaut)  ||
                astronautsByCity.containsKey(secondAstronaut));
    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
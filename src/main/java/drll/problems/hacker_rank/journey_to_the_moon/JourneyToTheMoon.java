
package drll.problems.hacker_rank.journey_to_the_moon;

import java.util.*;

public class JourneyToTheMoon {

    // Complete the journeyToMoon function below.
    static long journeyToMoon(int n, int[][] astronaut) {

        long result = 0;

        // Get big cities
        Set<Set<Integer>> cities = processAllPairs(astronaut);

        // Counting pair for big cities
        HashSet[] citiesArray = cities.toArray(new HashSet[0]);
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
        for (int[] ints : astronaut) {
            Integer firstAstronaut = ints[0],
                    secondAstronaut = ints[1];

            if (areBothRegisteredAstronauts(result, firstAstronaut, secondAstronaut)) {
                // astronauts are both registered
                mergeAstronautsCities(result, firstAstronaut, secondAstronaut);
            } else {
                if (areBothNewAstronauts(result, firstAstronaut, secondAstronaut)) {
                    // astronauts are both new, then create a city for them
                    createNewCity(result, firstAstronaut, secondAstronaut);
                } else {
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
}
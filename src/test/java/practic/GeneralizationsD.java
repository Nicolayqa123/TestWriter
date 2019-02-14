package practic;

import java.util.ArrayList;
import java.util.HashMap;

public class GeneralizationsD {

    public static void main(String[] args) {

        ArrayList<String> sports = new ArrayList<String>();
        sports.add("Football");
        sports.add("Boxing");
        System.out.println(sports.get(0));


       /* for(String sport : sports) {
            System.out.println(sports.get(1));
        }
*/
        //Major cities and the year they were founded
        HashMap<String, Integer> majorCities = new HashMap<String, Integer>();

        majorCities.put("New York", 1624);
        majorCities.put("London", 43);
        majorCities.put("Mexico City", 1521);
        majorCities.put("Sao Paulo", 1554);


        for (String city : majorCities.keySet()) {

            System.out.println(city + " was founded in " + majorCities.get(city));

        }

        HashMap<String, Integer> gamesRating = new HashMap<String, Integer>();

        gamesRating.put("Assassins", 10);
        gamesRating.put("Grid 2", 8);
        gamesRating.put("Xcom 2", 10);

        for (String game : gamesRating.keySet()){
            System.out.println(game + " the raiting of the game " + gamesRating.get(game));
        }


    }

}

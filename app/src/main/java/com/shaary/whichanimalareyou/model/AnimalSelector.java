package com.shaary.whichanimalareyou.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AnimalSelector {
    private int fox = 0;
    private int dolphin = 0;
    private int cat = 0;
    private int tiger = 0;
    private int sloth = 0;
    private int seal = 0;
    private int owl = 0;
    private int horse = 0;
    private int elephant = 0;
    private int monkey = 0;
    private int redPanda = 0;



    private HashMap<String, Integer> animals = new HashMap<>();

    public String AnimalSelector(List<Integer> answers) {
        String animalOfChoice;
        for (int i = 0; i < answers.size(); i++) {
            // 1. I eat meat
            if (i == 0) {
                switch (answers.get(i)) {
                    //Always
                    case (0):
                        tiger = tiger + 10;
                        owl = owl + 10;
                        seal = seal + 10;
                        dolphin = dolphin + 10;
                        break;

                    //Often
                    case (1):
                        fox = fox + 5;
                        cat = cat + 5;
                        break;

                    //Sometimes
                    case (2):
                        monkey = monkey + 3;
                        break;

                    //Rare
                    case (3):
                        sloth = sloth + 5;
                        redPanda = redPanda + 5;
                        break;

                    //Never
                    case (4):
                        elephant = elephant + 10;
                        horse = horse + 10;
                        break;

                }
            }
            // 2. I like being around other people
            if (i == 1) {
                switch (answers.get(i)) {
                    case (0):
                        seal++;
                        dolphin++;
                        break;

                    case (1):
                        elephant++;
                        tiger++;
                        break;

                    case (2):
                        horse++;
                        monkey++;
                        break;

                    case (3):
                        fox++;
                        sloth++;
                        break;

                    case (4):
                        cat++;
                        owl++;
                        redPanda++;
                        break;

                }
            }
            // 3. I like to swim
            if (i == 2) {
                switch (answers.get(i)) {
                    case (0):
                        dolphin = dolphin + 10;
                        seal = seal + 10;
                        owl = owl - 5;
                        break;

                    case (1):
                        horse = horse + 5;
                        elephant = elephant + 5;
                        monkey = monkey + 5;
                        break;

                    case (2):
                        fox = fox + 3;
                        break;

                    case (3):
                        sloth = sloth + 5;
                        tiger = tiger + 5;
                        break;

                    case (4):
                        seal = seal - 5;
                        dolphin = dolphin - 10;
                        cat = cat + 10;
                        redPanda = redPanda + 10;
                        owl = owl + 10;
                        break;

                }
            }
            // 4. I sleep a lot
            if (i == 3) {
                switch (answers.get(i)) {
                    case (0):
                        sloth = sloth + 10;
                        cat = cat + 5;
                        break;

                    case (1):
                        tiger++;
                        break;

                    case (2):
                        redPanda++;
                        fox++;
                        monkey++;
                        owl++;
                        break;

                    case (3):
                        elephant++;
                        horse++;
                        break;

                    case (4):
                        dolphin = dolphin + 2;
                        seal = seal + 2;
                        break;

                }
            }
            // 5. I stay up late at night
            if (i == 4) {
                switch (answers.get(i)) {
                    case (0):
                        dolphin++;
                        seal++;
                        owl++;
                        tiger++;
                        break;

                    case (1):
                        fox++;
                        cat++;
                        break;

                    case (2):
                        redPanda++;
                        monkey++;
                        break;

                    case (3):
                        sloth++;
                        break;

                    case (4):
                        horse++;
                        elephant++;
                        break;
                }
            }
            // 6. I feel comfortable during the winter
            if (i == 5) {
                switch (answers.get(i)) {
                    case (0):
                        owl++;
                        seal = seal + 2;
                        break;

                    case (1):
                        dolphin++;
                        tiger = tiger + 2;
                        break;

                    case (2):
                        fox = fox + 2;
                        horse++;
                        break;

                    case (3):
                        monkey++;
                        cat++;
                        redPanda++;
                        break;

                    case (4):
                        dolphin = dolphin - 5;
                        seal = seal - 5;
                        elephant = elephant + 10;
                        sloth = sloth + 10;
                        break;
                }
            }
            // 7. I'm an active person
            if (i == 6) {
                switch (answers.get(i)) {
                    case (0):
                        horse++;
                        dolphin = dolphin + 2;
                        sloth = sloth - 10;
                        break;

                    case (1):
                        seal++;
                        elephant++;
                        break;

                    case (2):
                        owl++;
                        cat++;
                        monkey++;
                        break;

                    case (3):
                        tiger++;
                        redPanda++;
                        fox++;
                        break;

                    case (4):
                        sloth = sloth + 5;
                        break;
                }
            }
            // 8. I can easily loose my temper
            if (i == 7) {
                switch (answers.get(i)) {
                    case (0):
                        sloth = sloth - 3;
                        tiger = tiger + 2;
                        monkey++;
                        break;

                    case (1):
                        cat++;
                        redPanda++;
                        break;

                    case (2):
                        fox++;
                        elephant++;
                        horse++;
                        owl++;
                        break;

                    case (3):
                        dolphin++;
                        seal++;
                        break;

                    case (4):
                        sloth = sloth + 5;
                        break;
                }
            }
        }

        animals.put("cat", cat);
        animals.put("red panda", redPanda);
        animals.put("dolphin", dolphin);
        animals.put("seal", seal);
        animals.put("sloth", sloth);
        animals.put("elephant", elephant);
        animals.put("monkey", monkey);
        animals.put("owl", owl);
        animals.put("fox", fox);
        animals.put("tiger", tiger);
        animals.put("horse", horse);


        //chooses the max value of votes after the test
        int maxVotes = Collections.max(animals.values());

        animalOfChoice = getKeysByValue(animals, maxVotes);
        return animalOfChoice;

    }

    //chooses random animal if there are two or more with equal values
    public String getKeysByValue(HashMap<String, Integer> animals, Integer maxVotes) {
        List<String> biggestScore = new ArrayList<>();
        for (String animal : animals.keySet()) {
            if (animals.get(animal).equals(maxVotes)) {
                biggestScore.add(animal);
            }
        }
        Random random = new Random();
        int index = random.nextInt(biggestScore.size());
        String animal = biggestScore.get(index);
        Log.i(animal, " is chosen, lol");
        return animal;
    }
}

package com.shaary.whichanimalareyou.model;

import com.shaary.whichanimalareyou.R;

import java.util.Map;
import java.util.TreeMap;

public class Zoo {

    private Animal[] animals;
    private Map<String, Animal> animalMap;

    public Zoo() {
        animals = new Animal[11];

        animals[0] = new Animal("cat", R.drawable.cat, 0.6f,  0.6f, "Dairy is bad for your health");
        animals[1] = new Animal("dolphin", R.drawable.dolphin, 0.55f,  0.5f, "I'm not a fish");
        animals[2] = new Animal("elephant",R.drawable.elephant, 0.7f, 0.35f, "People are cute");
        animals[3] = new Animal("fox", R.drawable.fox, 0.75f,  0.5f, "I like chicken");
        animals[4] = new Animal("horse", R.drawable.horse, 0.95f, 0.75f, "Got me some carrots?");
        animals[5] = new Animal("monkey", R.drawable.monkey, 0.7f,  0.5f, "Sometimes I eat meat");
        animals[6] = new Animal("owl", R.drawable.owl, 0.45f, 0.6f, "Coffee??");
        animals[7] = new Animal("redpanda", R.drawable.redpanda, 0.9f, 0.5f, "I bet you've never heard of me");
        animals[8] = new Animal("seal", R.drawable.seal9, 0.4f, 0.4f, "I wish I was a penguin");
        animals[9] = new Animal("sloth", R.drawable.sloth, 0.55f,  0.7f, "Lazyyyyy");
        animals[10] = new Animal("tiger", R.drawable.tiger, 0.75f,  0.5f, "Zebra is my relative");

        animalMap = new TreeMap<>();

        animalMap.put("cat",  animals[0]);
        animalMap.put("dolphin", animals[1]);
        animalMap.put("elephant", animals[2]);
        animalMap.put("fox", animals[3]);
        animalMap.put("horse", animals[4]);
        animalMap.put("monkey", animals[5]);
        animalMap.put("owl",  animals[6]);
        animalMap.put("red panda", animals[7]);
        animalMap.put("seal", animals[8]);
        animalMap.put("sloth", animals[9]);
        animalMap.put("tiger", animals[10]);

    }

    //returns the Animal object to the ResultActivity to load the page
    public Animal getAnimal(String animal) {
        return animalMap.get(animal);
    }
}



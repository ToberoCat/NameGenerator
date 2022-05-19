package io.github.toberocat.generator;

import io.github.toberocat.data.FileReader;
import io.github.toberocat.jackson.JsonUtility;

import java.util.LinkedList;
import java.util.Random;

public abstract class AbstractGenerator {
    public String[] generateNames(int amount, int seed) {
        return generateNames(amount, new Random(seed));
    }

    public String[] generateNames(int amount) {
        return generateNames(amount, new Random());
    }

    public String[] generateNames(int amount, Random random) {
        LinkedList<String> names = new LinkedList<>();

        for (int i = 0; i < amount; i++) {
            names.add(generateName(random));
        }

        return names.toArray(String[]::new);
    }



    public String generateName() {
        return generateName(new Random());
    }

    public String generateName(int seed) {
        return generateName(new Random(seed));
    }

    public abstract String generateName(Random random);

    protected String[] readArray(String path) {
        return JsonUtility.readObject(FileReader.readResourceFile(path), String[].class);
    }
}

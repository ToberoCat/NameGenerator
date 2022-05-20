package io.github.toberocat.generator;

import io.github.toberocat.math.Mathf;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;

public class UndeadArmyGenerator extends AbstractGenerator {
    @Override
    public String[] generateNames(int amount, Random random) {
        LinkedHashSet<String> namings = new LinkedHashSet<>();
        String[] namings1 = readArray("/names/undead_army/nm1.json");
        String[] namings2 = readArray("/names/undead_army/nm2.json");

        while (namings.size() < amount) {
            int randomNms1 = random.nextInt(namings1.length);
            int randomNms2 = random.nextInt(namings2.length);

            namings.add("The " + namings1[randomNms1] + " " + namings2[randomNms2]);
        }
        return namings.toArray(String[]::new);
    }

    @Override
    public String generateName(Random random) {
        String[] namings1 = readArray("/names/undead_army/nm1.json");
        String[] namings2 = readArray("/names/undead_army/nm2.json");

        int randomNms1 = random.nextInt(namings1.length);
        int randomNms2 = random.nextInt(namings2.length);

        return "The " + namings1[randomNms1] + " " + namings2[randomNms2];
    }
}

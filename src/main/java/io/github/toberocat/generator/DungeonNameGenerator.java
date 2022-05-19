package io.github.toberocat.generator;

import java.util.LinkedHashSet;
import java.util.Random;

public class DungeonNameGenerator extends AbstractGenerator {

    @Override
    public String[] generateNames(int amount, Random random) {
        LinkedHashSet<String> names = new LinkedHashSet<>();
        String[] namings1 = null, namings2, namings3 = null, namings4 = null;
        namings2 = readArray("/names/dungeon/nm2.json");

        for (int i = 0; i < amount; i++) {
            int second = random.nextInt(namings2.length);

            if (random.nextBoolean()) {
                if (namings3 == null) namings3 = readArray("/names/dungeon/nm3.json");
                if (namings4 == null) namings4 = readArray("/names/dungeon/nm4.json");

                int fourth = random.nextInt(namings4.length);
                int third = random.nextInt(namings3.length);

                names.add(namings2[second] + " of the " + namings3[third] + " " + namings4[fourth]);
                continue;
            }

            if (namings1 == null) namings1 = readArray("/names/dungeon/nm1.json");
            int first = random.nextInt(namings1.length);

            names.add("The " + namings1[first] + " " + namings2[second]);
        }

        return names.toArray(String[]::new);
    }


    @Override
    public String generateName(Random random) {
        String[] namings2 = readArray("/names/dungeon/nm2.json");

        int second = random.nextInt(namings2.length);

        if (random.nextBoolean()) {
            String[] namings3 = readArray("/names/dungeon/nm3.json");
            String[] namings4 = readArray("/names/dungeon/nm4.json");

            int fourth = random.nextInt(namings4.length);
            int third = random.nextInt(namings3.length);

            return namings2[second] + " of the " + namings3[third] + " " + namings4[fourth];
        }

        String[] namings1 = readArray("/names/dungeon/nm1.json");
        int first = random.nextInt(namings1.length);

        return "The " + namings1[first] + " " + namings2[second];
    }
}

package io.github.toberocat.generator;

import java.util.LinkedHashSet;
import java.util.Random;

public class ApocalypseTownGenerator extends AbstractGenerator {
    @Override
    public String[] generateNames(int amount, Random random) {
        LinkedHashSet<String> names = new LinkedHashSet<>();
        String[] namings = readArray("/names/apocalypse_towns/nm1.json");

        while (names.size() < amount) {
            names.add(namings[random.nextInt(namings.length)]);
        }

        return names.toArray(String[]::new);
    }

    @Override
    public String generateName(Random random) {
        String[] namings = readArray("/names/apocalypse_towns/nm1.json");
        return namings[random.nextInt(namings.length)];
    }
}

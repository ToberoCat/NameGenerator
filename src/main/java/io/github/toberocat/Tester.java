package io.github.toberocat;

import io.github.toberocat.generator.DungeonNameGenerator;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        String[] names = new DungeonNameGenerator().generateNames(10);
        System.out.println(Arrays.toString(names));
    }
}

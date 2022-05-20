package io.github.toberocat;

import io.github.toberocat.generator.ApocalypseTownGenerator;
import io.github.toberocat.jackson.JsonUtility;

import java.io.File;
import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        String[] names = new ApocalypseTownGenerator().generateNames(1);
        System.out.println(Arrays.toString(names));

    }

    private static void write(String name, String[] array) {
        JsonUtility.saveObject(new File("C:\\Users\\Tobias\\Desktop\\Development\\Java\\NameGenerator\\src\\main\\resources\\names\\apocalypse_towns\\" + name + ".json"), array);

    }
}

package de.lcraft.configurationSystem.yaml;

import org.junit.jupiter.api.Test;
import java.io.File;

public class ConfigTest {

    @Test
    public void test() {
        Config config = new Config();
        config.load(new File(Config.testPath + "\\load\\config.txt"));
        config.set("mama.test.lol", 3);
        config.save(new File(Config.testPath + "\\load\\config1.txt"));

        config = new Config();
        config.load(new File(Config.testPath + "\\load\\config1.txt"));
        config.set("mama.test.lol", 6);
        config.save(new File(Config.testPath + "\\load\\config2.txt"));
    }

}

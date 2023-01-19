package de.lcraft.configurationSystem.yaml.loadSystem;

import de.lcraft.configurationSystem.yaml.Config;
import org.junit.jupiter.api.Test;
import java.io.File;

public class LoadManagerTest {

    @Test
    public void test() {
        LoadManager loadManager = new LoadManager();
        loadManager.load(new File(Config.testPath + "\\load\\config.txt"));
        for(LoadItem c : loadManager.getLoadItems()) {
            System.out.println(c.toString());
        }
    }

}

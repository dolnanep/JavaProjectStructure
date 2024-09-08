package TollCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    private static final String PROPERTIES_FILE = "src/main/resources/configs.properties";
    private static Properties properties;
    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static String getValue(String key) {
        return properties.getProperty(key);
}
        }


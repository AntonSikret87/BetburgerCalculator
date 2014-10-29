package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Дом
 * Date: 25.12.13
 * Time: 13:03
 * To change this template use File | Settings | File Templates.
 */
public final class DataStorage {
    private static Map<String, Properties> propertiesMap;
    private static DataStorage instance;

    private DataStorage() {
        propertiesMap = new HashMap<String, Properties>();
    }

    public static DataStorage getInstance() {
        if (instance == null) {
            instance = new DataStorage();
        }
        return instance;
    }

    public static void setProperty(String key, Properties properties) {
        propertiesMap.put(key, properties);
    }

    public static Properties getProperty(String key) {
        return propertiesMap.get(key);
    }

    public static boolean exists(String key) {
        return propertiesMap.get(key) != null;
    }
}

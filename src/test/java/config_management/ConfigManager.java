package config_management;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final Properties config;

    static {
        config = new Properties();
        try {
            config.load(new FileReader("src/test/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String ratesTestFileLocation(){
        return config.getProperty("rates_test_file_location");
    }

    public static void main(String[] args) {
        System.out.println(ratesTestFileLocation());
    }


}

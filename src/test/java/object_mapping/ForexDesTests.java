package object_mapping;
import config_management.ConfigManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForexDesTests {
    private static ForexRatesDeserialiser forexRatesDeserialiser;

    @BeforeAll
    private static void setup(){
        forexRatesDeserialiser = new ForexRatesDeserialiser(new File(ConfigManager.ratesTestFileLocation()));
    }

    @Test
    public void successTest(){
       assertTrue(forexRatesDeserialiser.forexJsonDTO.isSuccess());
    }

    @Test
    public void timestampTest(){
        long timestamp = 1539182646;
        assertEquals(timestamp, forexRatesDeserialiser.forexJsonDTO.getTimestamp());
    }

    @Test
    public void baseTest(){
        String base = "EUR";
        assertEquals(base, forexRatesDeserialiser.forexJsonDTO.getBase());
    }

}

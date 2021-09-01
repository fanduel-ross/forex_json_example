package node_parsing;

import java.io.File;

import config_management.ConfigManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForexJsonNodeTests {
    private static ForexJsonNodeParsing forexJsonNodeParsing;
    @BeforeAll
    private static void setup(){
        forexJsonNodeParsing = new ForexJsonNodeParsing(new File(ConfigManager.ratesTestFileLocation()));

    }

    @Test
    public void getSuccessTest(){
        assertTrue(forexJsonNodeParsing.getSuccess());
    }

    @Test
    public void getRatesTestSuccess() throws Exception {
        String expected = "AFN 87.678396";
        assertEquals(expected, forexJsonNodeParsing.getRates("AFN"));

    }

}
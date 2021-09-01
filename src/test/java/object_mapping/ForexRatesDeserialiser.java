package object_mapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ForexRatesDeserialiser {
    public ForexJsonDTO forexJsonDTO;

    public ForexRatesDeserialiser(File json_file_location) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.forexJsonDTO = objectMapper.readValue(json_file_location, ForexJsonDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package node_parsing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import config_management.ConfigManager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ForexJsonNodeParsing {

    private JsonNode ratesNodes;

    public ForexJsonNodeParsing(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.ratesNodes = objectMapper.readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean getSuccess() {
        return ratesNodes.get("success").asBoolean();
    }

    public String getRates(String code) throws Exception {

        JsonNode rates = ratesNodes.get("rates");
        if (!rates.has(code)) {
            throw new Exception("Code not found.");
        }
        return code + " " + rates.get(code).asDouble();

    }



}
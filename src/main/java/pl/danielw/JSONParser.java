package pl.danielw;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JSONParser {
    public static void main(String[] args) throws IOException {
        File json = new File("cats response.json");
        String jsonString = Files.readAllLines(json.toPath()).get(0);
        ObjectMapper om = new ObjectMapper();

        JsonNode jsonArray = om.readTree(jsonString);
        JsonNode firstItem = jsonArray.get(0);
        String url = firstItem.get("url").asText();
        System.out.println(url);

    }
}

package pl.danielw.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pl.danielw.APIKey;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String authHeaderKey = "x-api-key";
        String authHeaderAPIKeyValue = APIKey.KEY.VALUE;

        HttpRequest httpGetRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.thecatapi.com/v1/images/search?limit=3"))
                .header(authHeaderKey, authHeaderAPIKeyValue)
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> httpResponse = httpClient.send(httpGetRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        // when parsing a JSON array reflectively create a parametrized type of list
        // if parsing a single JSON object use {MyObject.class} in .fromJson instead
        Type listType = new TypeToken<List<CatImage>>() {}.getType();
        List<CatImage> catImages = gson.fromJson(httpResponse.body(), listType);
        System.out.println(catImages);
    }
}

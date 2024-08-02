package pl.danielw.simple;

import pl.danielw.APIKey;

import java.io.IOException;
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String authHeaderKey = "x-api-key";
        String authHeaderAPIKeyValue = APIKey.KEY.VALUE;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.thecatapi.com/v1/images/search?limit=1"))
                .header(authHeaderKey, authHeaderAPIKeyValue)
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
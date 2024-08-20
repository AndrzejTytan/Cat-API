package pl.danielw.Service;

import pl.danielw.CatAPIConstants;
import pl.danielw.Entity.CatImage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CatApiService {
    private final JsonParsingService jsonParsingService;
    private final HttpClient httpClient;

    public CatApiService(JsonParsingService jsonParsingService) {
        this.jsonParsingService = jsonParsingService;
        this.httpClient = HttpClient.newHttpClient();
    }

    public CatImage requestSingle() throws IOException, InterruptedException {
        HttpRequest httpRequest = requestCountBuilder(1).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = httpResponse.body();
        System.out.println(responseBody);
        return jsonParsingService.toSingleFromJsonArray(responseBody);
    }

    public CatImage[] requestMultipleInArray(int count) throws IOException, InterruptedException {
        HttpRequest httpRequest = requestCountBuilder(count).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = httpResponse.body();
        System.out.println(responseBody);
        return jsonParsingService.toArray(responseBody);
    }

    public List<CatImage> requestMultipleInList(int count) throws IOException, InterruptedException {
        HttpRequest httpRequest = requestCountBuilder(count).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = httpResponse.body();
        System.out.println(responseBody);
        return jsonParsingService.toList(responseBody);
    }

    private HttpRequest.Builder requestCountBuilder(int count) {
        if (count < 1) throw new IllegalArgumentException();
        return HttpRequest.newBuilder()
                .header(CatAPIConstants.HEADER.VALUE, CatAPIConstants.KEY.VALUE)
                .uri(URI.create(CatAPIConstants.URI.VALUE + count));
    }
}

package pl.danielw;

import pl.danielw.Entity.CatImage;
import pl.danielw.Service.CatApiService;
import pl.danielw.Service.GsonParsingService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        CatApiService catApiService = new CatApiService(new GsonParsingService());
//        CatImage catImage = catApiService.requestSingle();
//        System.out.println(catImage);

        CatImage[] catImages = catApiService.requestMultipleInArray(10);
        for (CatImage ci : catImages) {
            System.out.println(ci);
        }

        // TODO: breeds object within CatImage https://developers.thecatapi.com/view-account/ylX4blBYT9FaoVd6OhvR?report=aZyiLrsCh#tag/Images
        // TODO: expand the requests with parameters https://www.baeldung.com/java-httpclient-request-parameters
    }
}

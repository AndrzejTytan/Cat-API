package pl.danielw.Service;

import pl.danielw.Entity.CatImage;

import java.util.List;

public class JacksonParsingService implements JsonParsingService {
    @Override
    public CatImage toSingle(String json) {
        return null;
    }

    @Override
    public CatImage toSingleFromJsonArray(String json) {
        return null;
    }

    @Override
    public CatImage[] toArray(String json) {
        return new CatImage[0];
    }

    @Override
    public List<CatImage> toList(String json) {
        return List.of();
    }
}

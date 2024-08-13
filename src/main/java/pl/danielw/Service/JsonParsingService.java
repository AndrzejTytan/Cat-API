package pl.danielw.Service;

import pl.danielw.Entity.CatImage;

import java.util.List;

public interface JsonParsingService {
    CatImage toSingle(String json);
    CatImage toSingleFromJsonArray(String json);
    CatImage[] toArray(String json);
    List<CatImage> toList(String json);

}

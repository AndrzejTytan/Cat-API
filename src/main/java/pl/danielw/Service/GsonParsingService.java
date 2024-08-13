package pl.danielw.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pl.danielw.Entity.CatImage;

import java.lang.reflect.Type;
import java.util.List;

public class GsonParsingService implements JsonParsingService {
    private final Gson gson;

    public GsonParsingService() {
        this.gson = new Gson();
    }

    @Override
    public CatImage toSingle(String json) {
        return gson.fromJson(json, CatImage.class);
    }

    public CatImage toSingleFromJsonArray(String json) {
        return gson.fromJson(json, CatImage[].class)[0];
    }

    @Override
    public CatImage[] toArray(String json) {
        return gson.fromJson(json, CatImage[].class);
    }

    @Override
    public List<CatImage> toList(String json) {
        Type listType = new TypeToken<List<CatImage>>() {}.getType();
        return gson.fromJson(json, listType);
    }
}

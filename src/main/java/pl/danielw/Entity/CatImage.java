package pl.danielw.Entity;

import java.util.Arrays;

public class CatImage {
    private String[] breeds; // lots of fields https://api.thecatapi.com/v1/images/0XYvRd7oD
    private String id;
    private String url;
    private String width;
    private String height;

    public String[] getBreeds() {
        return breeds;
    }

    public void setBreeds(String[] breeds) {
        this.breeds = breeds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "CatImage{" +
                "breeds=" + Arrays.toString(breeds) +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}

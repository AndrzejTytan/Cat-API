package pl.danielw;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CatURIBuilder {
    private final Map<String, String> parameters;

    public CatURIBuilder() {
        this.parameters = new HashMap<>();
    }

    /**
     * type: 1-100
     * description: Number of images to return between
     * default: 1
     *
     * @param limit
     */
    public CatURIBuilder limit(int limit) {
        if (limit > 100 || limit < 1) throw new IllegalArgumentException();
        parameters.put("limit", String.valueOf(limit));
        return this;
    }

    /**
     * type: 0-n
     * description: The page number to use when Paginating through the images
     * default: 0
     *
     * @param page
     */
    public CatURIBuilder page(int page) {
        if (page < 0) throw new IllegalArgumentException();
        parameters.put("page", String.valueOf(page));
        return this;
    }

    /**
     * type: ASC/DESC/RAND
     * description: The Order to return the images in by their upload date
     * default: RAND
     * *
     *
     * @param order
     */
    public CatURIBuilder order(String order) {
        if (!order.equals("ASC") &&
                !order.equals("DESC") &&
                !order.equals("RAND")) {
            throw new IllegalArgumentException();
        }
        parameters.put("order", order);
        return this;
    }

    /**
     * type: true/false
     * description: Only return images that have breed information
     * default: false
     * *
     *
     * @param hasBreeds
     */
    public CatURIBuilder hasBreeds(boolean hasBreeds) {
        if (hasBreeds) {
            parameters.put("breed_ids", "1");
        } else {
            parameters.put("breed_ids", "0");
        }
        return this;
    }

    /**
     * type: true/false
     * description: The IDs of the breeds to filter the images. e.g. {"beng", "abys"}
     * default: none
     * *
     *
     * @param breeds
     */
    public CatURIBuilder breedIds(String[] breeds) {
        String breedsCommaSeparated = String.join(",", breeds);
        parameters.put("breed_ids", breedsCommaSeparated);
        return this;
    }

    public URI build() {
        if (parameters.isEmpty()) {
            return URI.create(CatAPIConstants.URI.VALUE);
        }
        StringBuilder uriBuilder = new StringBuilder(CatAPIConstants.URI.VALUE);
        String uriParameters = "?" + parameters.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
        uriBuilder.append(uriParameters);
        return URI.create(uriBuilder.toString());
    }
}

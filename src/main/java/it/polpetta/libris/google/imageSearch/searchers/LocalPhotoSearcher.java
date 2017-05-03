package it.polpetta.libris.google.imageSearch.searchers;

import it.polpetta.libris.google.imageSearch.Coordinates;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;

/**
 * Created by dpolonio on 03/05/17.
 */
class LocalPhotoSearcher implements ISearcher {

    private URI path = null;

    LocalPhotoSearcher (URI pathToImage, Coordinates location) {
        this.path = pathToImage;
    }

    public JSONObject search() throws IOException {

        // TODO

        return null;
    }
}

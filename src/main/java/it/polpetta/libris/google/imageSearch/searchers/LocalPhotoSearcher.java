package it.polpetta.libris.google.imageSearch.searchers;

import it.polpetta.libris.google.imageSearch.Coordinates;
import it.polpetta.libris.google.imageSearch.IGoogleImageSearcher;
import it.polpetta.libris.utils.SearchResult.googleImageSearch.IGoogleImageSearchResult;

import java.io.IOException;
import java.net.URI;

/**
 * Created by dpolonio on 03/05/17.
 */
class LocalPhotoSearcher implements IGoogleImageSearcher {

    private URI path = null;

    LocalPhotoSearcher (URI pathToImage, Coordinates location) {
        this.path = pathToImage;
    }

    public IGoogleImageSearchResult search() throws IOException {

        // TODO

        return null;
    }
}

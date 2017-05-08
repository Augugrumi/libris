package it.polpetta.libris.image.google.searchers;

import it.polpetta.libris.utils.Coordinates;
import it.polpetta.libris.image.google.IGoogleImageSearcher;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;

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

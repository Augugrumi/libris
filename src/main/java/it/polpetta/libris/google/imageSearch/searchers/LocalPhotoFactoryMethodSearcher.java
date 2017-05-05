package it.polpetta.libris.google.imageSearch.searchers;

import it.polpetta.libris.google.imageSearch.Coordinates;
import it.polpetta.libris.utils.AbstractFactoryMethodSearcher;
import it.polpetta.libris.utils.ISearcher;

import java.net.URI;

/**
 * Created by dpolonio on 03/05/17.
 */
public class LocalPhotoFactoryMethodSearcher extends AbstractFactoryMethodSearcher {

    private URI path = null;

    public LocalPhotoFactoryMethodSearcher(Coordinates location, URI path) {
        super(location);

        this.path = path;
    }

    @Override
    public ISearcher makeSearcher() {
        return new LocalPhotoSearcher(path, location);
    }

}

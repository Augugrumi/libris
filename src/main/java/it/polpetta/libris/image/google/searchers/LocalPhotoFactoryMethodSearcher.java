package it.polpetta.libris.image.google.searchers;

import it.polpetta.libris.utils.Coordinates;
import it.polpetta.libris.contract.AbstractFactoryMethodSearcher;
import it.polpetta.libris.contract.ISearcher;

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

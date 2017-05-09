package it.polpetta.libris.image.google.hmtlImageSearch.searchers;

import it.polpetta.libris.utils.Coordinates;
import it.polpetta.libris.image.google.contract.IGoogleImageSearcher;
import it.polpetta.libris.contract.AbstractFactoryMethodSearcher;

import java.net.URL;

/**
 * Created by davide on 28/04/17.
 */
// FIXME REMOVE ME, I'LL BE SUBSTITUTED SOON
@Deprecated
public class URLFactoryMethodSearcher extends AbstractFactoryMethodSearcher {

    private URL link = null;

    public URLFactoryMethodSearcher(Coordinates location, URL link) {
        super(location);

        this.link = link;
    }

    @Override
    public IGoogleImageSearcher makeSearcher() {
        return new URLSearcher(link, location);
    }

}

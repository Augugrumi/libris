package it.polpetta.libris.google.imageSearch.searchers;

import it.polpetta.libris.google.imageSearch.Coordinates;
import it.polpetta.libris.utils.AbstractFactoryMethodSearcher;
import it.polpetta.libris.utils.ISearcher;

import java.net.URL;

/**
 * Created by davide on 28/04/17.
 */
public class URLFactoryMethodSearcher extends AbstractFactoryMethodSearcher {

    private URL link = null;

    public URLFactoryMethodSearcher(Coordinates location, URL link) {
        super(location);

        this.link = link;
    }

    @Override
    public ISearcher makeSearcher() {
        return new URLSearcher(link, location);
    }

}

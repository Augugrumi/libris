package it.polpetta.libris.google.imageSearch.searchers;


import it.polpetta.libris.google.imageSearch.Coordinates;

/**
 * Created by davide on 28/04/17.
 */
public abstract class AbstractFactoryMethodSearcher {

    protected Coordinates location = null;

    AbstractFactoryMethodSearcher(Coordinates location) {
        this.location = location;
    }

    public abstract ISearcher makeSearcher();

}

package it.polpetta.libris.utils;


import it.polpetta.libris.google.imageSearch.Coordinates;

/**
 * Created by davide on 28/04/17.
 */
public abstract class AbstractFactoryMethodSearcher {

    protected Coordinates location = null;

    public AbstractFactoryMethodSearcher(Coordinates location) {
        this.location = location;
    }

    public abstract ISearcher makeSearcher();

}

package it.polpetta.libris.contract;


import it.polpetta.libris.util.Coordinates;

/**
 * Created by davide on 28/04/17.
 */

// TODO: 08/05/17 delete me
public abstract class AbstractFactoryMethodSearcher {

    protected Coordinates location = null;

    public AbstractFactoryMethodSearcher(Coordinates location) {
        this.location = location;
    }

    public abstract ISearcher makeSearcher();

}

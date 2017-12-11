package it.polpetta.libris.image.contract;

import it.polpetta.libris.contract.AbstractURLSearcher;
import it.polpetta.libris.util.Coordinates;

import java.net.URL;

/**
 * Created by zanna on 08/05/17.
 * its a template method
 */
public abstract class AbstractURLImageSearcher extends AbstractURLSearcher {
    protected Coordinates location;

    public AbstractURLImageSearcher(URL link, Coordinates location) {
        super(link);
        this.location = location;
    }
}

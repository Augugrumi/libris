package it.polpetta.libris.opticalCharacterRecognition.contract;

import it.polpetta.libris.contract.AbstractURLSearcher;
import it.polpetta.libris.util.Coordinates;

import java.net.URL;

/**
 * Created by zanna on 08/05/17.
 * its a template method
 */
public abstract class AbstractURLOcr extends AbstractURLSearcher {

    public AbstractURLOcr(URL link) {
        super(link);
    }
}

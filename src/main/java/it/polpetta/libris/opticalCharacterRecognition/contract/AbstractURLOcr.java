package com.tfederico.libris.opticalCharacterRecognition.contract;

import com.tfederico.libris.contract.AbstractURLSearcher;

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

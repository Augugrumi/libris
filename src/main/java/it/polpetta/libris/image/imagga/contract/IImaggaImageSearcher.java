package it.polpetta.libris.image.imagga.contract;

import it.polpetta.libris.contract.ISearcher;

import java.io.IOException;

/**
 * Created by federico on 17/05/17.
 */
public interface IImaggaImageSearcher extends ISearcher {
    IImaggaImageSearchResult search() throws IOException;
}

package it.polpetta.libris.image.contract;

import it.polpetta.libris.contract.ISearchResult;

import java.util.ArrayList;

/**
 * Created by zanna on 08/05/17.
 */
public interface IImageSearchResult extends ISearchResult {
    //TODO put in ISearchResult?
    String getBestGuess();
    ArrayList<String> getTags();
}

package com.tfederico.libris.image.contract;

import com.tfederico.libris.contract.ISearchResult;

import java.util.ArrayList;

/**
 * Created by zanna on 08/05/17.
 */
public interface IImageSearchResult extends ISearchResult {
    //TODO put in ISearchResult?
    String getBestGuess();
    ArrayList<String> getTags();
}

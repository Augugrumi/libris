package it.polpetta.libris.opticalCharacterRecognition.contract;

import it.polpetta.libris.contract.ISearchResult;

import java.util.ArrayList;

/**
 * Created by zanna on 11/05/17.
 */
public interface IOcrSearchResult extends ISearchResult {
    ArrayList<String> getBestGuess();
}

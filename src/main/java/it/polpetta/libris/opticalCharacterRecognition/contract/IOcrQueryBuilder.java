package it.polpetta.libris.opticalCharacterRecognition.contract;

import it.polpetta.libris.contract.IQueryBuilder;

/**
 * Created by zanna on 08/05/17.
 */
public interface IOcrQueryBuilder extends IQueryBuilder {
    IOcrQueryBuilder addBestGuess(String language);
    IOcrQueryBuilder addLanguage(String language);
}

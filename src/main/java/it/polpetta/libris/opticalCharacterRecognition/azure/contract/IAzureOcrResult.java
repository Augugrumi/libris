package it.polpetta.libris.opticalCharacterRecognition.azure.contract;

import it.polpetta.libris.opticalCharacterRecognition.contract.IOcrSearchResult;

/**
 * Created by zanna on 11/05/17.
 */
public interface IAzureOcrResult extends IOcrSearchResult {
    String getLanguage();
}

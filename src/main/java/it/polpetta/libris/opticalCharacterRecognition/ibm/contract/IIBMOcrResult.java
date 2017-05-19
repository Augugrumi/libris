package it.polpetta.libris.opticalCharacterRecognition.ibm.contract;

import it.polpetta.libris.opticalCharacterRecognition.contract.IOcrSearchResult;

/**
 * Created by zanna on 11/05/17.
 */
public interface IIBMOcrResult extends IOcrSearchResult {
    String getLanguage();
}

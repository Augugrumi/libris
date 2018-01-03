package com.tfederico.libris.opticalCharacterRecognition.ibm.contract;

import com.tfederico.libris.opticalCharacterRecognition.contract.IOcrSearchResult;

/**
 * Created by zanna on 11/05/17.
 */
public interface IIBMOcrResult extends IOcrSearchResult {
    String getLanguage();
}

package com.tfederico.libris.opticalCharacterRecognition.azure.contract;

import com.tfederico.libris.opticalCharacterRecognition.contract.IOcrSearchResult;

/**
 * Created by zanna on 11/05/17.
 */
public interface IAzureOcrResult extends IOcrSearchResult {
    String getLanguage();
}

package it.polpetta.libris.opticalCharacterRecognition.ocrSpace;

import it.polpetta.libris.opticalCharacterRecognition.ocrSpace.contract.IAbstractOCRSpaceFactoryReverseSearchProvider;
import it.polpetta.libris.opticalCharacterRecognition.ocrSpace.freeOcr.FreeOCRSpaceSearcher;

/**
 * Created by davide on 26/05/17.
 */
public class OCRSpaceAbstractFactory implements IAbstractOCRSpaceFactoryReverseSearchProvider {

    private String subscriptionKey = null;

    public OCRSpaceAbstractFactory(String subscriptionKey) {

        this.subscriptionKey = subscriptionKey;
    }

    @Override
    public FreeOCRSpaceSearcher.Builder imageSearchBuildQuery() {
        FreeOCRSpaceSearcher.setSubscriptionKey(subscriptionKey);
        return new FreeOCRSpaceSearcher.Builder();
    }
}

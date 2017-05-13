package it.polpetta.libris.image.azure.contract;

import it.polpetta.libris.image.contract.IImageSearchResult;

import java.util.ArrayList;

/**
 * Created by davide on 06/05/17.
 */
public interface IAzureImageSearchResult extends IImageSearchResult {
    ArrayList<String> getOtherTags();
    String getDescription();
}

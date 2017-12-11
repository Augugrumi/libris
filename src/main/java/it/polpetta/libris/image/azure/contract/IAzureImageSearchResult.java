package com.tfederico.libris.image.azure.contract;

import com.tfederico.libris.image.contract.IImageSearchResult;

import java.util.ArrayList;

/**
 * Created by davide on 06/05/17.
 */
public interface IAzureImageSearchResult extends IImageSearchResult {
    ArrayList<String> getOtherTags();
    String getDescription();
}

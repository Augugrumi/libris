package it.polpetta.libris.image.ibm.contract;


import it.polpetta.libris.image.contract.IImageSearchResult;

import java.util.ArrayList;

/**
 * Created by dpolonio on 17/05/17.
 */
public interface IIBMImageSearchResult extends IImageSearchResult {
    ArrayList<String> getTags();
}

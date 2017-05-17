package it.polpetta.libris.image.imagga.contract;

import it.polpetta.libris.image.contract.IImageSearchResult;

import java.util.ArrayList;

/**
 * Created by federico on 17/05/17.
 */
public interface IImaggaImageSearchResult extends IImageSearchResult {
    ArrayList<String> getOtherTags();
    String getDescription();
}

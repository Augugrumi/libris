package com.tfederico.libris.image.imagga.contract;

import com.tfederico.libris.image.contract.IImageSearchResult;

import java.util.ArrayList;

/**
 * Created by federico on 17/05/17.
 */
public interface IImaggaImageSearchResult extends IImageSearchResult {
    ArrayList<String> getOtherTags();
}

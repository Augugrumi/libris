package com.tfederico.libris.image.google.contract;

import com.tfederico.libris.image.contract.IImageSearchResult;

import java.util.ArrayList;

/**
 * Created by davide on 06/05/17.
 */
public interface IGoogleImageSearchResult extends IImageSearchResult {
    ArrayList<String> getLinks();
    ArrayList<String> getDescription();
    ArrayList<String> getSimilarImages();
    ArrayList<String> getTitles();
}

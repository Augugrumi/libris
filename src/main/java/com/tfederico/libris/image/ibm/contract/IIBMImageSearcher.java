package com.tfederico.libris.image.ibm.contract;

import com.tfederico.libris.contract.ISearcher;

import java.io.IOException;

/**
 * Created by dpolonio on 17/05/17.
 */
public interface IIBMImageSearcher extends ISearcher {

    IIBMImageSearchResult search() throws IOException;
}

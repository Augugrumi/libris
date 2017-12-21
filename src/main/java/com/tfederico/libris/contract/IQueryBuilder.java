package com.tfederico.libris.contract;

import java.io.File;
import java.net.URL;

/**
 * Created by davide on 28/04/17.
 */
public interface IQueryBuilder {

    IQueryBuilder setImage(File file);
    IQueryBuilder setImage(URL linkToImage);
    ISearcher build();
}

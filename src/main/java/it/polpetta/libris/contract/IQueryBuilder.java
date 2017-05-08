package it.polpetta.libris.contract;

import java.io.File;
import java.net.URL;

/**
 * Created by davide on 28/04/17.
 */
public interface IQueryBuilder {

    IQueryBuilder setPhoto(File file);
    IQueryBuilder setPhoto(URL linkToImage);
    // TODO Le coordinate dovrebbero essere in gradi, da vedere
    IQueryBuilder setLocation(float x, float y);
    // TODO Fare un setLocation che accetti anche stringhe?
    //IQueryBuilder setLocation(String x, String y);
    IQuery runQuery();
}
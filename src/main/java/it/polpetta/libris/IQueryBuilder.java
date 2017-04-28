package it.polpetta.libris;

import java.io.File;

/**
 * Created by davide on 28/04/17.
 */
public interface IQueryBuilder {

    IQueryBuilder setPhoto(File file);
    // TODO Le coordinate dovrebbero essere in gradi, da vedere
    IQueryBuilder setLocation(float x, float y);
    // TODO Fare un setLocation che accetti anche stringhe?
    //IQueryBuilder setLocation(String x, String y);
    IQuery runQuery();
}

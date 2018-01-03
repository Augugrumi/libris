package com.tfederico.libris.image.contract;

import com.tfederico.libris.contract.IQueryBuilder;

/**
 * Created by zanna on 08/05/17.
 */
public interface IImageQueryBuilder extends IQueryBuilder {
    // TODO Le coordinate dovrebbero essere in gradi, da vedere
    IQueryBuilder setLocation(float x, float y);
    // TODO Fare un setLocation che accetti anche stringhe?
    //IQueryBuilder setLocation(String x, String y);
}

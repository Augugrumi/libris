package com.tfederico.libris;

import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifier;
import com.tfederico.libris.image.ibm.contract.IIBMCustomClassifierUtility;
import com.tfederico.libris.image.ibm.visualRecognition.IBMCustomClassifierUtility;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IBMCustomClassifierUtility.setSubscriptionKey("");
        IIBMCustomClassifierUtility customClassifierUtility = new IBMCustomClassifierUtility();

        List<Classifier> classifiersList = customClassifierUtility.getClassifiersList();

        for(Classifier c : classifiersList)
            customClassifierUtility.deleteClassifier(c.getClassifierId());

    }
}

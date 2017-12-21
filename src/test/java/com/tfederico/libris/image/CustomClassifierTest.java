package com.tfederico.libris.image;

import com.tfederico.libris.image.ibm.contract.IIBMCustomClassifierUtility;
import com.tfederico.libris.image.ibm.visualRecognition.IBMCustomClassifierUtility;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifier;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomClassifierTest {

    @Test
    public static void createCustomClassifier(){

        IBMCustomClassifierUtility.setSubscriptionKey("");
        IIBMCustomClassifierUtility customClassifierUtility = new IBMCustomClassifierUtility();

        HashMap<String, String> positiveSamples = new HashMap<>();
        ArrayList<String> negativeSamples = new ArrayList<>();


        positiveSamples.put("Pearl", "/home/federico/Desktop/watson_innovation/girl_with_pearl_earing/pearl.zip");
        negativeSamples.add("/home/federico/Desktop/watson_innovation/goldfinch/goldfinch.zip");

        Classifier vc = null;
        try {
            vc = customClassifierUtility.createClassifier("pearl", positiveSamples, negativeSamples);
        } catch (FileNotFoundException e) {

            org.junit.Assert.assertTrue(false);
        }

        String id = vc.getClassifierId();


        org.junit.Assert.assertEquals(id, customClassifierUtility.getClassifiersList().get(0).getClassifierId());

    }
}

package com.tfederico.libris;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsResult;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImage;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifier;
import com.tfederico.libris.image.ibm.contract.IIBMCustomClassifierUtility;
import com.tfederico.libris.image.ibm.visualRecognition.IBMCustomClassifierUtility;
import com.tfederico.libris.text.naturalLanguageUnderstanding.contract.IIBMNaturalLanguageUnderstandingUtility;
import com.tfederico.libris.text.naturalLanguageUnderstanding.ibm.IBMNaturalLanguageUnderstandingUtility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IBMCustomClassifierUtility.setSubscriptionKey("");
        IIBMCustomClassifierUtility customClassifierUtility = new IBMCustomClassifierUtility();

        /*List<Classifier> classifiersList = customClassifierUtility.getClassifiersList();
        for(Classifier c : classifiersList)
            customClassifierUtility.deleteClassifier(c.getClassifierId());*/

        /*ClassifiedImages image = null;
        try {
            image = customClassifierUtility.classify("/home/federico/Downloads/hello.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(image != null){
            System.out.println(image.getImages().get(0).getClassifiers().get(0).getName());
        }*/

        IBMNaturalLanguageUnderstandingUtility
                .setUsernameAndPassword("",
                        "");

        IIBMNaturalLanguageUnderstandingUtility nlu = new IBMNaturalLanguageUnderstandingUtility();
        String s = "The young sitter is assumed to be Maria Trip, the daughter of a wealthy " +
                "Amsterdam merchant. She displaysher wealth with pride. Her dress is trimmed " +
                "with white linen so fine it is almost transparent. She sports a fortune in " +
                "pearls, and in her left hand she casually holds the knobbed handle of a folding " +
                "fan. In 1639 thiswas still a rare and costly accessory.\n";
        List<KeywordsResult> keywordsResults = nlu.getKeywordsFromText(s);

        for(KeywordsResult k : keywordsResults){
            System.out.println(k.getText());
            System.out.println(k.getRelevance());
        }


    }
}

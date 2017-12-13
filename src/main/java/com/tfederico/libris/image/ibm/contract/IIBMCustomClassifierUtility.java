package com.tfederico.libris.image.ibm.contract;

import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.Classifier;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IIBMCustomClassifierUtility {

    Classifier createClassifier(String name, HashMap<String, String> classesAndPaths,
                                ArrayList<String> negativesPaths) throws FileNotFoundException;

    Classifier getClassifierById(String id);

    List<Classifier> getClassifiersList();

    void deleteClassifier(String id);

    Classifier updateClassifier(String id, HashMap<String, String> classesAndPaths,
                                      ArrayList<String> negativesPaths) throws FileNotFoundException;

    ClassifiedImages classifyById(String classifierId, String imagePath) throws FileNotFoundException;

    ClassifiedImages classify(String imagePath) throws FileNotFoundException;
}

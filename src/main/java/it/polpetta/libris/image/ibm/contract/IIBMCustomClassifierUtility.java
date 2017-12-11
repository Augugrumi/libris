package it.polpetta.libris.image.ibm.contract;

import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IIBMCustomClassifierUtility {

    VisualClassifier createClassifier(String name, HashMap<String, String> classesAndPaths,
                                ArrayList<String> negativesPaths);

    VisualClassifier getClassifierById(String id);

    List<VisualClassifier> getClassifiersList();

    void deleteClassifier(String id);

    VisualClassifier updateClassifier(String id, HashMap<String, String> classesAndPaths,
                                      ArrayList<String> negativesPaths);

}

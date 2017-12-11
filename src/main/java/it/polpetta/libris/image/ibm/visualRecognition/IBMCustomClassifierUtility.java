package it.polpetta.libris.image.ibm.visualRecognition;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;
import it.polpetta.libris.image.ibm.contract.IIBMCustomClassifierUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IBMCustomClassifierUtility implements IIBMCustomClassifierUtility{

    private static String subscriptionKey;

    private VisualRecognition service;


    public IBMCustomClassifierUtility(String apiKey){
        service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20, subscriptionKey);
    }

    public static void setSubscriptionKey(String key) {
        subscriptionKey = key;
    }

    @Override
    public VisualClassifier createClassifier(String name, HashMap<String, String> classesAndPaths,
                                       ArrayList<String> negativesPaths) {

        ClassifierOptions.Builder classifierOptionsBuilder = new ClassifierOptions.Builder();

        classifierOptionsBuilder.classifierName(name);

        for(String key : classesAndPaths.keySet()){
            classifierOptionsBuilder.addClass(key, new File(classesAndPaths.get(key)));
        }

        for(String path : negativesPaths){
            classifierOptionsBuilder.negativeExamples(new File(path));
        }

        ClassifierOptions classifierOptions = classifierOptionsBuilder.build();

        return service.createClassifier(classifierOptions).execute();
    }

    @Override
    public VisualClassifier getClassifierById(String id){
        return service.getClassifier(id).execute();
    }

    @Override
    public List<VisualClassifier> getClassifiersList(){
        return service.getClassifiers().execute();
    }

    @Override
    public void deleteClassifier(String id){
        service.deleteClassifier(id).execute();
    }

    @Override
    public VisualClassifier updateClassifier(String id, HashMap<String, String> classesAndPaths,
                                 ArrayList<String> negativesPaths){

        ClassifierOptions.Builder classifierOptionsBuilder = new ClassifierOptions.Builder();

        VisualClassifier classifier = getClassifierById(id);
        String name = classifier.getName();

        classifierOptionsBuilder.classifierName(name);

        for(String key : classesAndPaths.keySet()){
            classifierOptionsBuilder.addClass(key, new File(classesAndPaths.get(key)));
        }

        for(String path : negativesPaths){
            classifierOptionsBuilder.negativeExamples(new File(path));
        }

        ClassifierOptions classifierOptions = classifierOptionsBuilder.build();

        return service.updateClassifier(id, classifierOptions).execute();
    }

}

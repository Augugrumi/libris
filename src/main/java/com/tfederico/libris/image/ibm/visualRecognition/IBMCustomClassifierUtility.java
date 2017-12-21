package com.tfederico.libris.image.ibm.visualRecognition;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.*;
import com.tfederico.libris.image.ibm.contract.IIBMCustomClassifierUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IBMCustomClassifierUtility implements IIBMCustomClassifierUtility{

    private static String subscriptionKey;

    private VisualRecognition service;


    public IBMCustomClassifierUtility(){
        service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20, subscriptionKey);
    }

    public static void setSubscriptionKey(String key) {
        subscriptionKey = key;
    }

    @Override
    public Classifier createClassifier(String name, HashMap<String, String> classesAndPaths,
                                       ArrayList<String> negativesPaths) throws FileNotFoundException {


        CreateClassifierOptions.Builder classifierOptionsBuilder = new CreateClassifierOptions.Builder();

        classifierOptionsBuilder.name(name);

        for(String key : classesAndPaths.keySet()){
            classifierOptionsBuilder.addClass(key, new File(classesAndPaths.get(key)));
        }

        for(String path : negativesPaths){
            classifierOptionsBuilder.negativeExamples(new File(path));
        }

        CreateClassifierOptions classifierOptions = classifierOptionsBuilder.build();

        return service.createClassifier(classifierOptions).execute();
    }

    @Override
    public Classifier getClassifierById(String id){
        GetClassifierOptions getClassifierOptions = new GetClassifierOptions.Builder(id).build();
        return service.getClassifier(getClassifierOptions).execute();
    }

    @Override
    public List<Classifier> getClassifiersList(){
        ListClassifiersOptions listClassifiersOptions = new ListClassifiersOptions.Builder()
                .verbose(true)
                .build();
        return service.listClassifiers(listClassifiersOptions).execute().getClassifiers();
    }

    @Override
    public void deleteClassifier(String id){
        DeleteClassifierOptions options = new DeleteClassifierOptions.Builder(id).build();
        service.deleteClassifier(options).execute();
    }

    @Override
    public Classifier updateClassifier(String id, HashMap<String, String> classesAndPaths,
                                 ArrayList<String> negativesPaths) throws FileNotFoundException {

        UpdateClassifierOptions.Builder classifierOptionsBuilder = new UpdateClassifierOptions.Builder();

        classifierOptionsBuilder.classifierId(id);
        for(String key : classesAndPaths.keySet()){
            classifierOptionsBuilder.addClass(key, new File(classesAndPaths.get(key)));
        }

        for(String path : negativesPaths){
            classifierOptionsBuilder.negativeExamples(new File(path));
        }

        UpdateClassifierOptions classifierOptions = classifierOptionsBuilder.build();

        return service.updateClassifier(classifierOptions).execute();
    }

    @Override
    public ClassifiedImages classifyById(ArrayList<String> classifierId, String imagePath) throws IOException {

        ClassifyOptions.Builder builder = new ClassifyOptions.Builder();

        InputStream imagesStream = new BufferedInputStream(new FileInputStream(imagePath));

        //int i = imagesStream.read();


        StringBuilder ids = new StringBuilder();

        if(classifierId != null){
            for(String s : classifierId){
                ids.append("\"").append(s).append("\"").append(",");
            }

            ids.deleteCharAt(ids.length()-1);
        }


        String parameters;
        if(classifierId != null){
            parameters = "{\"classifier_ids\": [\""+classifierId+"\"],"
                    + "\"owners\": [\"me\"]}";
        }
        else
            parameters = "{\"owners\": [\"me\"]}";


        String[] steps = imagePath.split("/");
        String fileName = steps[steps.length-1];
        String fileExt = fileName.split("\\.")[1];
        builder.imagesFile(imagesStream)
                .imagesFilename(fileName)
                .parameters(parameters);

        ClassifyOptions classifyOptions = builder.build();

        return service.classify(classifyOptions).execute();
    }

    @Override
    public ClassifiedImages classify(String imagePath) throws IOException {
        return classifyById(null,imagePath);
    }


}

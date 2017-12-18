package com.tfederico.libris.text.naturalLanguageUnderstanding.ibm;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;
import com.tfederico.libris.text.naturalLanguageUnderstanding.contract.IIBMNaturalLanguageUnderstandingUtility;

import java.util.ArrayList;
import java.util.List;

public class IBMNaturalLanguageUnderstandingUtility implements IIBMNaturalLanguageUnderstandingUtility{

    private NaturalLanguageUnderstanding nlu;

    private static String username;

    private static String password;

    public IBMNaturalLanguageUnderstandingUtility(){
        nlu = new NaturalLanguageUnderstanding(NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27);
        nlu.setUsernameAndPassword(username, password);

    }

    public static void setUsernameAndPassword(String username, String password) {
        IBMNaturalLanguageUnderstandingUtility.username = username;
        IBMNaturalLanguageUnderstandingUtility.password = password;
    }

    @Override
    public List<CategoriesResult> getCategoriesFromText(String text) {
        CategoriesOptions options = new CategoriesOptions();
        Features f = new Features.Builder().categories(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getCategories();

    }

    @Override
    public List<ConceptsResult> getConceptsFromText(String text, int limit) {

        ConceptsOptions options = new ConceptsOptions.Builder().limit(limit).build();
        Features f = new Features.Builder().concepts(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getConcepts();
    }

    @Override
    public EmotionResult getEmotionsFromText(String text) {
        EmotionOptions options = new EmotionOptions.Builder().build();
        Features f = new Features.Builder().emotion(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getEmotion();
    }

    @Override
    public EmotionResult getTargetsEmotionsFromText(String text, ArrayList<String> targets) {
        EmotionOptions options = new EmotionOptions.Builder().targets(targets).build();
        Features f = new Features.Builder().emotion(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getEmotion();
    }

    @Override
    public List<EntitiesResult> getEntitiesFromText(String text) {
        EntitiesOptions options = new EntitiesOptions.Builder().mentions(true).build();
        Features f = new Features.Builder().entities(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getEntities();
    }

    @Override
    public List<KeywordsResult> getKeywordsFromText(String text) {
        KeywordsOptions options = new KeywordsOptions.Builder().build();
        Features f = new Features.Builder().keywords(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getKeywords();
    }

    @Override
    public MetadataResult getMetadataFromText(String text) {
        MetadataOptions options = new MetadataOptions();
        Features f = new Features.Builder().metadata(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getMetadata();
    }

    @Override
    public List<RelationsResult> getRelationsFromText(String text) {
        RelationsOptions options = new RelationsOptions.Builder().build();
        Features f = new Features.Builder().relations(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getRelations();
    }

    @Override
    public List<SemanticRolesResult> getSemanticRolesFromText(String text) {
        SemanticRolesOptions options = new SemanticRolesOptions.Builder().build();
        Features f = new Features.Builder().semanticRoles(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getSemanticRoles();
    }

    @Override
    public SentimentResult getSentimentFromText(String text) {
        SentimentOptions options = new SentimentOptions.Builder().build();
        Features f = new Features.Builder().sentiment(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getSentiment();
    }

    @Override
    public SentimentResult getTargetsSentimentFromText(String text, ArrayList<String> targets) {
        SentimentOptions options = new SentimentOptions.Builder().targets(targets).build();
        Features f = new Features.Builder().sentiment(options).build();
        AnalyzeOptions analyzeOptions = new AnalyzeOptions.Builder().text(text).features(f).build();
        return nlu.analyze(analyzeOptions).execute().getSentiment();
    }


}

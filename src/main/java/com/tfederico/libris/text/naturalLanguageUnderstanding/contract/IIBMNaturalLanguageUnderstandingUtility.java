package com.tfederico.libris.text.naturalLanguageUnderstanding.contract;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;

import java.util.ArrayList;
import java.util.List;

public interface IIBMNaturalLanguageUnderstandingUtility {

    List<CategoriesResult> getCategoriesFromText(String text);

    List<ConceptsResult> getConceptsFromText(String text, int limit);

    EmotionResult getEmotionsFromText(String text);

    EmotionResult getTargetsEmotionsFromText(String text, ArrayList<String> targets);

    List<EntitiesResult> getEntitiesFromText(String text);

    List<KeywordsResult> getKeywordsFromText(String text);

    MetadataResult getMetadataFromText(String text);

    List<RelationsResult> getRelationsFromText(String text);

    List<SemanticRolesResult> getSemanticRolesFromText(String text);

    SentimentResult getSentimentFromText(String text);

    SentimentResult getTargetsSentimentFromText(String text, ArrayList<String> targets);
}

package com.tfederico.libris.text.discovery.ibm;

import com.ibm.watson.developer_cloud.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateDocumentOptions;
import com.tfederico.libris.text.discovery.contract.IIBMDiscoveryDocumentUtility;

import java.io.File;
import java.io.FileNotFoundException;

public class IBMDiscoveryDocumentUtility implements IIBMDiscoveryDocumentUtility{
    @Override
    public AddDocumentOptions addDocument(String envId, String collId, String jsonPath) throws FileNotFoundException {
        AddDocumentOptions.Builder builder = new AddDocumentOptions.Builder();
        builder.environmentId(envId);
        builder.collectionId(collId);
        builder.file(new File(jsonPath));
        return builder.build();
    }

    @Override
    public UpdateDocumentOptions updateDocument(String envId, String collId, String docId, String jsonPath) throws FileNotFoundException {
        UpdateDocumentOptions.Builder builder = new UpdateDocumentOptions.Builder();
        builder.environmentId(envId);
        builder.collectionId(collId);
        builder.documentId(docId);
        builder.file(new File(jsonPath));
        return builder.build();
    }

    @Override
    public DeleteDocumentOptions deleteDocument(String envId, String collId, String docId) {
        DeleteDocumentOptions.Builder builder = new DeleteDocumentOptions.Builder();
        builder.environmentId(envId);
        builder.collectionId(collId);
        builder.documentId(docId);
        return builder.build();
    }
}

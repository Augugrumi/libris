package com.tfederico.libris.text.discovery.contract;

import com.ibm.watson.developer_cloud.discovery.v1.model.AddDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteDocumentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateDocumentOptions;

import java.io.FileNotFoundException;

public interface IIBMDiscoveryDocumentUtility {

    AddDocumentOptions addDocument(String envId, String collId, String jsonPath) throws FileNotFoundException;

    UpdateDocumentOptions updateDocument(String envId, String collId, String docId, String jsonPath) throws FileNotFoundException;

    DeleteDocumentOptions deleteDocument(String envId, String collId, String docId);
}

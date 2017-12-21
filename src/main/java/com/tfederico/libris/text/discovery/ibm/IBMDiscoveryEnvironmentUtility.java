package com.tfederico.libris.text.discovery.ibm;

import com.ibm.watson.developer_cloud.discovery.v1.model.CreateEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteEnvironmentOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateEnvironmentOptions;
import com.tfederico.libris.text.discovery.contract.IIBMDiscoveryEnvironmentUtility;

import java.util.List;

public class IBMDiscoveryEnvironmentUtility implements IIBMDiscoveryEnvironmentUtility{

    @Override
    public CreateEnvironmentOptions createEnvironment(String name, String description) {
        CreateEnvironmentOptions.Builder createRequestOptions = new CreateEnvironmentOptions.Builder();

        createRequestOptions.size(1);
        createRequestOptions.name(name);
        createRequestOptions.description(description);

        return createRequestOptions.build();

    }

    @Override
    public UpdateEnvironmentOptions updateEnvironment(String envId, String name, String description) {

        UpdateEnvironmentOptions.Builder builder = new UpdateEnvironmentOptions.Builder();
        builder.environmentId(envId);
        builder.name(name);
        builder.description(description);

        return builder.build();
    }

    @Override
    public DeleteEnvironmentOptions deleteEnvironment(String envId) {
        DeleteEnvironmentOptions.Builder builder = new DeleteEnvironmentOptions.Builder();
        builder.environmentId(envId);

        return builder.build();
    }
}

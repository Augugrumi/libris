package com.tfederico.libris.text.discovery.ibm;

import com.ibm.watson.developer_cloud.discovery.v1.model.*;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.tfederico.libris.text.discovery.contract.IIBMDiscoveryConfigurationUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class IBMDiscoveryConfigurationUtility implements IIBMDiscoveryConfigurationUtility{

    @Override
    public CreateConfigurationOptions createConfiguration(String envId, String name,
                                                          String jsonFile) throws FileNotFoundException {
        CreateConfigurationOptions.Builder builder = new CreateConfigurationOptions.Builder();
        builder.environmentId(envId);
        builder.name(name);
        Configuration configuration = GsonSingleton.getGson().fromJson(
                new FileReader(jsonFile), Configuration.class);
        builder.configuration(configuration);
        return builder.build();
    }

    @Override
    public UpdateConfigurationOptions updateConfiguration(String envId, String confId,
                                                          String name, String jsonFile) throws FileNotFoundException {
        UpdateConfigurationOptions.Builder builder = new UpdateConfigurationOptions.Builder();
        builder.environmentId(envId);
        builder.configurationId(confId);
        builder.name(name);

        Configuration configuration = GsonSingleton.getGson().fromJson(
                new FileReader(jsonFile), Configuration.class);
        builder.configuration(configuration);
        return builder.build();
    }

    @Override
    public ListConfigurationsOptions listConfigurations(String envId) {
        ListConfigurationsOptions.Builder builder = new ListConfigurationsOptions.Builder();
        builder.environmentId(envId);
        return builder.build();
    }

    @Override
    public DeleteConfigurationOptions deleteConfiguration(String envId, String confId) {
        DeleteConfigurationOptions.Builder builder = new DeleteConfigurationOptions.Builder();

        builder.environmentId(envId);
        builder.configurationId(confId);
        return builder.build();
    }
}

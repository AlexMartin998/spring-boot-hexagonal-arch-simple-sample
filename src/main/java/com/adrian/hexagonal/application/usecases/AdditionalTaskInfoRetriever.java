package com.adrian.hexagonal.application.usecases;

import com.adrian.hexagonal.domain.models.AdditionalTaskInfo;
import com.adrian.hexagonal.domain.out.ExternalServicePort;
import com.adrian.hexagonal.domain.usecases.GetAdditionalTaskInfo;
import lombok.AllArgsConstructor;


// AdditionalTaskInfoRetriever to avoid using Impl suffix and set more semantic name
@AllArgsConstructor
public class AdditionalTaskInfoRetriever implements GetAdditionalTaskInfo {

    ///* DI
    private final ExternalServicePort externalServicePort;


    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }

}

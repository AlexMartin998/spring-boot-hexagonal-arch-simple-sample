package com.adrian.hexagonal.domain.out;

import com.adrian.hexagonal.domain.models.AdditionalTaskInfo;


// fetch domain data of an external resource
public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}

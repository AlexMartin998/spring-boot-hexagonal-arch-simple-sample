package com.adrian.hexagonal.domain.usecases;

import com.adrian.hexagonal.domain.models.AdditionalTaskInfo;


public interface GetAdditionalTaskInfo {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}

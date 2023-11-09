package com.adrian.hexagonal.infrastructure.config;

import com.adrian.hexagonal.application.services.TaskService;
import com.adrian.hexagonal.application.usecases.*;
import com.adrian.hexagonal.domain.out.ExternalServicePort;
import com.adrian.hexagonal.domain.repositories.TaskRepository;
import com.adrian.hexagonal.domain.usecases.GetAdditionalTaskInfo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    ///* @Beans to set Application Services as   Injectable/Bean   without Spring Boot @Service annotation
    @Bean
    public TaskService taskService(TaskRepository taskRepository, GetAdditionalTaskInfo getAdditionalTaskInfo) {
        return new TaskService(
                new TaskCreator(taskRepository),
                new TaskUpdater(taskRepository),
                new TaskDeleter(taskRepository),
                new TaskRetriever(taskRepository),
                getAdditionalTaskInfo
        );
    }


    @Bean
    public AdditionalTaskInfoRetriever getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new AdditionalTaskInfoRetriever(externalServicePort);
    }


//    @Bean  // @Repository in Infrastructure is allowed
//    public TaskRepository taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
//        return jpaTaskRepositoryAdapter;
//    }
//    @Bean
//    public ExternalServicePort externalServicePort() {
//        return new ExternalServiceAdapter();
//    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

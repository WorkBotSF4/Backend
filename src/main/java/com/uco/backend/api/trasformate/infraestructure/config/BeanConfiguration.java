package com.uco.backend.api.trasformate.infraestructure.config;

import com.uco.backend.api.trasformate.application.*;
import com.uco.backend.api.trasformate.domain.port.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService userService(IUserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public AreaService areaService(IAreaRepository areaRepository) {
        return new AreaService(areaRepository);
    }

    @Bean
    public DocumentService documentService(IDocumentRepository iDocumentRepository) {
        return new DocumentService(iDocumentRepository);
    }
    @Bean
    public ExerciseService exerciseService(IExerciseRepository exerciseRepository) {
        return new ExerciseService(exerciseRepository);
    }

    @Bean
    public RoutineService routineService(IRoutineRepository routineRepository) {
        return new RoutineService(routineRepository);
    }
    @Bean
    public GYMClassService gymClassService(IGYMClassRepository gymClassRepository) {
        return new GYMClassService(gymClassRepository);
    }

    @Bean
    public RegistrationService registrationService(IUserRepository userRepository) {
        return new RegistrationService(userRepository);
    }

}

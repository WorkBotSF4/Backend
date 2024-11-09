package com.uco.backend.api.trasformate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GYMClass {
    private int id;
    private String nameClass;
    private Area area;
    private String description;
    private User teacher;
    private List<Exercise> exercises;
    private List<User> attendees;
    private LocalDateTime createdAt;
    private String timeDate;
}

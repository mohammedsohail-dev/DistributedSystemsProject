package com.skiers.project.models;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;


@Document("skiers_resorts")

public class Resorts {
    @Id
    Integer resortID;
    String resortName;
    String year;
    
}




package com.skiers.project.models;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;

@Document("skiers_resorts")



public class ListofResorts {
    @Id
    Resorts resort ;
}

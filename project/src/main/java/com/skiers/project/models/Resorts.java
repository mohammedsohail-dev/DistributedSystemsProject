package com.skiers.project.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="skiers_resorts")
public class Resorts {
    @Id
    String resortName;
    String resortID;
    String year;

   
    
}






package com.skiers.project.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.skiers.project.models.Resorts;

public interface ResortRepository extends MongoRepository<Resorts, String> {
        @Query(value = "{ 'resortID': ?0 }")
        Resorts findByMappingCode(String resortID);
        


        

        
        

}










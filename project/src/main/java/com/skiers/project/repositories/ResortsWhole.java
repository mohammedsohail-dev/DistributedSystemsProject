package com.skiers.project.repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.skiers.project.models.Resorts;

  public interface ResortsWhole extends MongoRepository<Resorts , String> {
    @Query("{'active':true}")
    List<Resorts> findAll();
        

}
    


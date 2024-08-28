package com.example.GitMiningRestSever;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface dateCreation extends MongoRepository<dateNode, String> {

    @Query(value="{id:'?0'}", fields="{'commits' : 1, 'dates': 1  }")
    List<contributorNode> findAll(String id);

}

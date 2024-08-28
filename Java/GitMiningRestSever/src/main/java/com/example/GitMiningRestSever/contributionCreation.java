package com.example.GitMiningRestSever;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface contributionCreation extends MongoRepository<contributorNode, String> {

    @Query(value="{id:'?0'}", fields="{'userName' : 1, 'contributions': 1  }")
    List<contributorNode> findAll(String id);

}

package com.example.GitMiningRestSever;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repoActivityCreation extends MongoRepository<repoActivityDateNode, String> {

}

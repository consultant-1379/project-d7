package com.example.GitMiningRestSever;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/contrib")
@CrossOrigin(origins= {"localhost:9090"}, maxAge = 4800, allowCredentials = "false" )
public class contributionController {

    @Autowired
    private contributionCreation repository;

    @GetMapping(produces={"application/json","application/xml"})
    public ResponseEntity<Collection<contributorNode>> getAllNodes(){
        Collection<contributorNode> result = repository.findAll();
        return ResponseEntity.ok().body(result);
    }
}

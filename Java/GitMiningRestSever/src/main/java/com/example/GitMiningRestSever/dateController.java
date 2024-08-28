package com.example.GitMiningRestSever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/date")
//@CrossOrigin
@CrossOrigin(origins= {"localhost:9090"}, maxAge = 4800, allowCredentials = "false" )
public class dateController {

    @Autowired
    private dateCreation repository;

    @GetMapping(produces={"application/json","application/xml"})
    public ResponseEntity<Collection<dateNode>> getAllNodes(){
        Collection<dateNode> result = repository.findAll();
        return ResponseEntity.ok().body(result);
    }
}

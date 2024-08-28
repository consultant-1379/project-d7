package com.example.GitMiningRestSever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/fa")
//@CrossOrigin
@CrossOrigin(origins= {"localhost:9090"}, maxAge = 4800, allowCredentials = "false" )
public class filesAnalysisController {

    @Autowired
    private filesAnalysisCreation repository;

    @GetMapping(produces={"application/json","application/xml"})
    public ResponseEntity<Collection<filesAnalysisNode>> getAllNodes(){
        Collection<filesAnalysisNode> result = repository.findAll();
        return ResponseEntity.ok().body(result);
    }






}

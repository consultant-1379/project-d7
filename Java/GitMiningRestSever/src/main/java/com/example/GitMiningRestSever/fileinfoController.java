package com.example.GitMiningRestSever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/repo")
//@CrossOrigin
@CrossOrigin(origins= {"localhost:9090"}, maxAge = 4800, allowCredentials = "false" )
public class fileinfoController {

    private fileInfoNode all;
    private fileInfoNode dates;

    @RequestMapping(path = "/pname" , method = RequestMethod.POST)
    @PostMapping(consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public fileInfoNode insertNewNode(@RequestBody fileInfoNode file){
        System.out.println(file);
        all = file;
        return all;
    }

    @RequestMapping(path = "/pdate" , method = RequestMethod.POST)
    @PostMapping(consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public fileInfoNode insertDates(@RequestBody fileInfoNode file){
        dates = file;
        return dates;
    }

    @RequestMapping(path = "/date", method = RequestMethod.GET)
    @GetMapping(produces={"application/json","application/xml"})
    public fileInfoNode getDates(){

        System.out.println(dates);
        return dates;
    }

    @RequestMapping(path = "/name", method = RequestMethod.GET)
    @GetMapping(produces={"application/json","application/xml"})
    public fileInfoNode getRepo(){
        System.out.println(all.getName());
        return all;
    }

}

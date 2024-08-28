package com.example.GitMiningRestSever;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class generalAnalysisControllerTest {


    @Autowired
    private generalAnalysisController node1;
    @Before
    public void init(){
        node1 = new generalAnalysisController();

    }

    @Test
    void getAllNodes() throws Exception {
        assertThat(node1.getAllNodes()).isNotNull();
    }
}
package com.example.GitMiningRestSever;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class filesAnalysisControllerTest {


    @Autowired
    private filesAnalysisController node1;
    @Before
    public void init(){
        node1 = new filesAnalysisController();
    }

    @Test
    void getAllNodes() throws Exception {
        assertThat(node1.getAllNodes()).isNotNull();
    }
}
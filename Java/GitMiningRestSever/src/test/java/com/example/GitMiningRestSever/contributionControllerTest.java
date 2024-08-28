package com.example.GitMiningRestSever;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class contributionControllerTest {

    @Autowired
    private contributionController node1;
    @Before
    public void init(){
        node1 = new contributionController();
    }

    @Test
    void getAllNodes() throws Exception {
        assertThat(node1.getAllNodes()).isNotNull();
    }
}
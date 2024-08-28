package com.example.GitMiningRestSever;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class repoActivityControllerTest {

    @Autowired
    private repoActivityController node1;
    @Before
    public void init(){
        node1 = new repoActivityController();
    }

    @Test
    void getAllNodes() {
        assertThat(node1.getAllNodes()).isNotNull();
    }
}
package com.example.GitMiningRestSever;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class contributorNodeTest {


    @Autowired
    private contributorNode node1;
    @BeforeEach
    public void init(){
        this.node1 = new contributorNode("1","username","23");

    }
    @Test
    void testSetAndGetName() {
        this.node1.setUserName("un");
        String username = this.node1.getUserName();
        assertEquals("un",username);
    }

    @Test
    void setAndGetId() {

        this.node1.setId("2");
        String id = this.node1.getId();
        assertEquals("2",id);
    }

    @Test
    void getAndSetContributions() {

        this.node1.setContributions("789");
        String contrib = this.node1.getContributions();
        assertEquals("789",contrib);
    }

}
package com.example.GitMiningRestSever;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class dateNodeTest {


    @Autowired
    private dateNode node1;
    @BeforeEach
    public void init(){
        this.node1 = new dateNode();

    }

    @Test
    void TestConstruction(){
        dateNode n1 = new dateNode("","test","test");

        assertEquals("test", n1.getDate());
    }
    @Test
    void testId() {

        this.node1.setId("test");
        String Test = this.node1.getId();
        assertEquals("test",Test);
    }

    @Test
    void testCommits() {
        this.node1.setCommits("test");
        String Test = this.node1.getCommits();
        assertEquals("test",Test);
    }

    @Test
    void testDate() {
        this.node1.setDate("test");
        String Test = this.node1.getDate();
        assertEquals("test",Test);
    }
}
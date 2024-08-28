package com.example.GitMiningRestSever;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class generalAnalysisNodeTest {


    @Autowired
    private generalAnalysisNode node1;
    @BeforeEach
    public void init(){
        this.node1 = new generalAnalysisNode();

    }

    @Test
    void TestConstruction(){
        generalAnalysisNode n1 = new generalAnalysisNode("1","test","test","test","test","test");

        assertEquals("test", n1.getLinesAdded());
    }
    @Test
    void TestId() {

        this.node1.setId("test");
        String Test = this.node1.getId();
        assertEquals("test",Test);
    }

    @Test
    void TestLinesAdded() {

        this.node1.setLinesAdded("test");
        String Test = this.node1.getLinesAdded();
        assertEquals("test",Test);
    }

    @Test
    void TestLinesRemoved() {
        this.node1.setLinesRemoved("test");
        String Test = this.node1.getLinesRemoved();
        assertEquals("test",Test);
    }

    @Test
    void TestMaxChangeSet() {
        this.node1.setMaxChangeSet("test");
        String Test = this.node1.getMaxChangeSet();
        assertEquals("test",Test);
    }

    @Test
    void TestAvgChangeSet() {
        this.node1.setAvgChangeSet("test");
        String Test = this.node1.getAvgChangeSet();
        assertEquals("test",Test);
    }

    @Test
    void TestTotalCommits() {
        this.node1.setTotalCommits("test");
        String Test = this.node1.getTotalCommits();
        assertEquals("test",Test);
    }
}
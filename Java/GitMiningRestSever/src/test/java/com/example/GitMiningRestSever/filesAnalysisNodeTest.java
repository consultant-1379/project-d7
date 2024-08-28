package com.example.GitMiningRestSever;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class filesAnalysisNodeTest {

    @Autowired
    private filesAnalysisNode node1;
    @BeforeEach
    public void init(){
        this.node1 = new filesAnalysisNode();

    }

    @Test
    void testId() {
        this.node1.setId("un");
        String Id = this.node1.getId();
        assertEquals("un",Id);
    }

    @Test
    void testFile() {
        this.node1.setFile("test");
        String Test = this.node1.getFile();
        assertEquals("test",Test);
    }

    @Test
    void testContributors() {
        this.node1.setContributors("test");
        String Test = this.node1.getContributors();
        assertEquals("test",Test);
    }

    @Test
    void testMinorContributors() {

        this.node1.setMinorContributors("test");
        String Test = this.node1.getMinorContributors();
        assertEquals("test",Test);
    }

    @Test
    void testLinesAdded() {

        this.node1.setLinesAdded("test");
        String Test = this.node1.getLinesAdded();
        assertEquals("test",Test);
    }

    @Test
    void testLinesRemoved() {

        this.node1.setLinesRemoved("test");
        String Test = this.node1.getLinesRemoved();
        assertEquals("test",Test);
    }

    @Test
    void testMaxCodeChurn() {

        this.node1.setMaxCodeChurn("test");
        String Test = this.node1.getMaxCodeChurn();
        assertEquals("test",Test);
    }

    @Test
    void testAvgCodeChurn() {

        this.node1.setAvgCodeChurn("test");
        String Test = this.node1.getAvgCodeChurn();
        assertEquals("test",Test);
    }

    @Test
    void testHighestContributor() {

        this.node1.setHighestContributor("test");
        String Test = this.node1.getHighestContributor();
        assertEquals("test",Test);
    }

    @Test
    void testHunksCount() {

        this.node1.setHunksCount("test");
        String Test = this.node1.getHunksCount();
        assertEquals("test",Test);
    }
}
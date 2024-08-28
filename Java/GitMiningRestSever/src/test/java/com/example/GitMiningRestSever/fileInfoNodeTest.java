package com.example.GitMiningRestSever;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class fileInfoNodeTest {


    @Autowired
    private fileInfoNode node1;


    @BeforeEach
    public void init(){
        this.node1 = new fileInfoNode("test","test","test");
    }
    @Test
    void TestConstruction(){
        fileInfoNode n1 = new fileInfoNode("test","test","test");
        assertEquals("test", n1.getName());
    }

    @Test
    void TestConstruction1(){
        fileInfoNode n1 = new fileInfoNode("test");
        assertEquals("test", n1.getName());
    }

    @Test
    void getAndSetName() {
        this.node1.setName("test1");
        String Test = this.node1.getName();
        assertEquals("test1", Test);
    }

    @Test
    void getAndSetDateStart() {

        this.node1.setDateStart("test1");
        String Test = this.node1.getDateStart();
        assertEquals("test1", Test);
    }

    @Test
    void getAndSetDateEnd() {
        this.node1.setDateEnd("test1");
        String Test = this.node1.getDateEnd();
        assertEquals("test1", Test);
    }
}
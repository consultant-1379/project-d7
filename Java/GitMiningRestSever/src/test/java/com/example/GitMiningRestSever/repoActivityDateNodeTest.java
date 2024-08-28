package com.example.GitMiningRestSever;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class repoActivityDateNodeTest {


    @Autowired
    private repoActivityDateNode node1;


    @BeforeEach
    public void init(){
        this.node1 = new repoActivityDateNode();

    }


    @Test
    void getAndSetId() {
        this.node1.setId("12");
        String Test = this.node1.getId();
        assertEquals("12",Test);

    }

    @Test
    void getAndSetDate() {
        this.node1.setDate("12/1/22");
        String Test = this.node1.getDate();
        assertEquals("12/1/22",Test);
    }

    @Test
    void TestConsturctor() {
        repoActivityDateNode n1 = new repoActivityDateNode("id","date");
        assertEquals("id",n1.getId());
    }
}
package com.example.GitMiningRestSever;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class PopulateDBTest {


    @Autowired
    private PopulateDB node1;
    @BeforeEach
    public void init(){
        this.node1 = new PopulateDB();

    }
    @Test
    void getFileName() {
        this.node1.setFileName("test");
        String Test = this.node1.getFileName();
        assertEquals("test",Test);
    }
}
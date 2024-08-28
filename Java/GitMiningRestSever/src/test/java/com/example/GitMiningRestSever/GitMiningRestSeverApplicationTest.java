package com.example.GitMiningRestSever;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ejb.ApplicationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GitMiningRestSeverApplicationTest {


    GitMiningRestSeverApplication obj;
    @BeforeEach
    void setUp() throws Exception {
        obj = new GitMiningRestSeverApplication();
    }
    @Test
    public void main() throws InterruptedException {
        GitMiningRestSeverApplication.main(new String[]{});
    }


    @Test
    public void testExceptions() throws Exception {

        try {
            obj.run();
        } catch (IOException e) {
            // throw new RuntimeException(e);
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
//}
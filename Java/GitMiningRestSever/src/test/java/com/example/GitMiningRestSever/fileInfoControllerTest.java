package com.example.GitMiningRestSever;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class fileinfoControllerTest {



    @Autowired
    private fileinfoController node1;
    private fileInfoNode t1;
    @Autowired
    private TestRestTemplate restTemplate;
    @Before
    public void init(){
        node1 = new fileinfoController();
        t1 = new fileInfoNode("name","2/2/22","2/2/22");
    }



    @Test
    void insertNewDate() {
        fileInfoNode t1 = new fileInfoNode("name","2/2/22","2/2/22");
        assertThat(node1.insertDates(t1)).isNotNull();
    }



    @Test
    void insertName() {
        fileInfoNode t1 = new fileInfoNode("name","2/2/22","2/2/22");
        assertThat(node1.insertNewNode(t1)).isNotNull();
    }



    @Test
    void testGetDates() throws Exception {
        fileInfoNode t1 = new fileInfoNode("name","2/2/22","2/2/22");
        node1.insertDates(t1);
        assertThat(node1.getDates().getDateStart()).isNotNull();
    }



    @Test
    void testGetName() throws Exception {
        fileInfoNode t1 = new fileInfoNode("name","2/2/22","2/2/22");
        node1.insertDates(t1);
        node1.insertNewNode(t1);
//        assertThat(node1.getRepo().getName()).isNotNull();
//        System.out.println(node1.getRepo().getName());
        assertEquals("name", node1.getRepo().getName());
    }
}
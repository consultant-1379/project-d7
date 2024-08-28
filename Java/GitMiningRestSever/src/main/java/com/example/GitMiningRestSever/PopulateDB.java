package com.example.GitMiningRestSever;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PopulateDB {

    private String fileName;

    private final static String COMMA_DELIMITER = ",";

    public PopulateDB() {
    }

    public PopulateDB(String fileName) {
        this.fileName = fileName;
    }

    public List<List<String>> populate() throws IOException {
        List<List<String>> result = new ArrayList<>();
        String line;
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            while ((line = br.readLine()) != null) {

                if(i==1) {
                    String[] values = line.split(COMMA_DELIMITER);
                    result.add(Arrays.asList(values));
                }
                i=1;
            }

        }

        return result;
    }



    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}

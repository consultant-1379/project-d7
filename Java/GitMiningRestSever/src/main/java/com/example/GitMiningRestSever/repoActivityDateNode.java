package com.example.GitMiningRestSever;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("repoActivity_data_set")
public class repoActivityDateNode {

    private String id;
    private String date;

    public repoActivityDateNode() {
    }

    public repoActivityDateNode(String id, String date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}

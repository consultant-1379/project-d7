package com.example.GitMiningRestSever;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("date_data_set")
public class dateNode {
    private String id;
    private String commits;
    private String date;


    public dateNode() {
    }

    public dateNode(String id, String commits, String date) {
        this.id = id;
        this.commits = commits;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommits() {
        return commits;
    }

    public void setCommits(String commits) {
        this.commits = commits;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

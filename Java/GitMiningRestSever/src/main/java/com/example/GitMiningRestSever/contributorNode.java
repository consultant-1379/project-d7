package com.example.GitMiningRestSever;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Contribution_data_set")
public class contributorNode {
    //@Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String userName;

    private String contributions;

    public contributorNode(String id, String userName, String contributions) {
        this.id = id;
        this.userName = userName;
        this.contributions = contributions;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContributions() {
        return contributions;
    }

    public void setContributions(String contributions) {
        this.contributions = contributions;
    }

}

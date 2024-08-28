package com.example.GitMiningRestSever;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("generalAnalysis_data_set")
public class generalAnalysisNode {

    private String id;
    private String linesAdded;
    private String linesRemoved;
    private String maxChangeSet;
    private String avgChangeSet;
    private String totalCommits;

    public generalAnalysisNode() {
    }

    public generalAnalysisNode(String id, String linesAdded, String linesRemoved, String maxChangeSet, String avgChangeSet, String totalCommits) {
        this.id = id;
        this.linesAdded = linesAdded;
        this.linesRemoved = linesRemoved;
        this.maxChangeSet = maxChangeSet;
        this.avgChangeSet = avgChangeSet;
        this.totalCommits = totalCommits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinesAdded() {
        return linesAdded;
    }

    public void setLinesAdded(String linesAdded) {
        this.linesAdded = linesAdded;
    }

    public String getLinesRemoved() {
        return linesRemoved;
    }

    public void setLinesRemoved(String linesRemoved) {
        this.linesRemoved = linesRemoved;
    }

    public String getMaxChangeSet() {
        return maxChangeSet;
    }

    public void setMaxChangeSet(String maxChangeSet) {
        this.maxChangeSet = maxChangeSet;
    }

    public String getAvgChangeSet() {
        return avgChangeSet;
    }

    public void setAvgChangeSet(String avgChangeSet) {
        this.avgChangeSet = avgChangeSet;
    }

    public String getTotalCommits() {
        return totalCommits;
    }

    public void setTotalCommits(String totalCommits) {
        this.totalCommits = totalCommits;
    }


}

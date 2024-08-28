package com.example.GitMiningRestSever;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("fileAnalysis_data_set")
public class filesAnalysisNode {

    private String id;
    private String file;
    private String contributors;
    private String minorContributors;
    private String linesAdded;
    private String linesRemoved;
    private String maxCodeChurn;
    private String avgCodeChurn;
    private String highestContributor;
    private String hunksCount;

    public filesAnalysisNode() {
    }

    public filesAnalysisNode(String id, String file, String contributors, String minorContributors, String linesAdded, String linesRemoved, String maxCodeChurn, String avgCodeChurn, String highestContributor, String hunksCount) {
        this.id = id;
        this.file = file;
        this.contributors = contributors;
        this.minorContributors = minorContributors;
        this.linesAdded = linesAdded;
        this.linesRemoved = linesRemoved;
        this.maxCodeChurn = maxCodeChurn;
        this.avgCodeChurn = avgCodeChurn;
        this.highestContributor = highestContributor;
        this.hunksCount = hunksCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public String getMinorContributors() {
        return minorContributors;
    }

    public void setMinorContributors(String minorContributors) {
        this.minorContributors = minorContributors;
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

    public String getMaxCodeChurn() {
        return maxCodeChurn;
    }

    public void setMaxCodeChurn(String maxCodeChurn) {
        this.maxCodeChurn = maxCodeChurn;
    }

    public String getAvgCodeChurn() {
        return avgCodeChurn;
    }

    public void setAvgCodeChurn(String avgCodeChurn) {
        this.avgCodeChurn = avgCodeChurn;
    }

    public String getHighestContributor() {
        return highestContributor;
    }

    public void setHighestContributor(String highestContributor) {
        this.highestContributor = highestContributor;
    }

    public String getHunksCount() {
        return hunksCount;
    }

    public void setHunksCount(String hunksCount) {
        this.hunksCount = hunksCount;
    }


}

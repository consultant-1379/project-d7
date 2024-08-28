package com.example.GitMiningRestSever;

public class fileInfoNode {

    private String name;
    private String dateStart;
    private String dateEnd;


    public fileInfoNode(String name) {
        this.name = name;
    }


    public fileInfoNode(String name, String dateStart, String dateEnd) {
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }



    @Override
    public String toString() {
        return "fileInfoNode{" +
                "name='" + name + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                '}';
    }
}

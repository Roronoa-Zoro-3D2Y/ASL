package com.example.asl_project.Model;

public class PhotoNDescriptionModel {

    String description_line1;
    String description_line2;

    public PhotoNDescriptionModel(String description_line1, String description_line2) {
        this.description_line1 = description_line1;
        this.description_line2 = description_line2;
    }

    public String getDescription_line1() {
        return description_line1;
    }

    public void setDescription_line1(String description_line1) {
        this.description_line1 = description_line1;
    }

    public String getDescription_line2() {
        return description_line2;
    }

    public void setDescription_line2(String description_line2) {
        this.description_line2 = description_line2;
    }
}

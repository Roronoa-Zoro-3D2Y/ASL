package com.example.asl_project.Model;

public class WordDescriptionModel {
    int wordClass;
    String word;
    String handShape;
    String locationOnBody;
    String movement;
    String facialExp;

    public WordDescriptionModel(int wordClass, String word, String handShape, String locationOnBody, String movement, String facialExp) {
        this.wordClass = wordClass;
        this.word = word;
        this.handShape = handShape;
        this.locationOnBody = locationOnBody;
        this.movement = movement;
        this.facialExp = facialExp;
    }

    public WordDescriptionModel(String handShape, String locationOnBody, String movement, String facialExp) {
        this.handShape = handShape;
        this.locationOnBody = locationOnBody;
        this.movement = movement;
        this.facialExp = facialExp;
    }

    public WordDescriptionModel(int wordClass, String handShape, String locationOnBody, String movement, String facialExp) {
        this.wordClass = wordClass;
        this.handShape = handShape;
        this.locationOnBody = locationOnBody;
        this.movement = movement;
        this.facialExp = facialExp;
    }

    public int getWordClass() {
        return wordClass;
    }

    public void setWordClass(int wordClass) {
        this.wordClass = wordClass;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getHandShape() {
        return handShape;
    }

    public void setHandShape(String handShape) {
        this.handShape = handShape;
    }

    public String getLocationOnBody() {
        return locationOnBody;
    }

    public void setLocationOnBody(String locationOnBody) {
        this.locationOnBody = locationOnBody;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getFacialExp() {
        return facialExp;
    }

    public void setFacialExp(String facialExp) {
        this.facialExp = facialExp;
    }
}

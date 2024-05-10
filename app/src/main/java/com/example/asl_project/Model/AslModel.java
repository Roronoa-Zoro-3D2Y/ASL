//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.asl_project.Model;

public class AslModel {
    int aslImage;
    int id;
    String aslAlphabet;

    public AslModel() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AslModel(int id, int aslImage, String aslAlphabet) {
        this.aslImage = aslImage;
        this.id = id;
        this.aslAlphabet = aslAlphabet;
    }

    public AslModel(int aslImage, String aslAlphabet) {
        this.aslImage = aslImage;
        this.aslAlphabet = aslAlphabet;
    }

    public int getAslImage() {
        return this.aslImage;
    }

    public void setAslImage(int aslImage) {
        this.aslImage = aslImage;
    }

    public String getAslAlphabet() {
        return this.aslAlphabet;
    }

    public void setAslAlphabet(String aslAlphabet) {
        this.aslAlphabet = aslAlphabet;
    }
}

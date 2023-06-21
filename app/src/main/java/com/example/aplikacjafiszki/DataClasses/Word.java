//The class is used to create objects by mapping from JSON
package com.example.aplikacjafiszki.DataClasses;

public class Word {
    private Integer id;
    private String polish;
    private String norwegian;

    public Word() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPolish() {
        return polish;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }

    public String getNorwegian() {
        return norwegian;
    }

    public void setNorwegian(String norwegian) {
        this.norwegian = norwegian;
    }
}
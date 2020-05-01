package com.itheima.domian;

import java.io.Serializable;

public class Vacancy implements Serializable {

    private String specialized;
    private Integer lack;

    public Vacancy(){

    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public Integer getLack() {
        return lack;
    }

    public void setLack(Integer lack) {
        this.lack = lack;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "specialized='" + specialized + '\'' +
                ", lack='" + lack + '\'' +
                '}';
    }
}

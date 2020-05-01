package com.itheima.domian;

import java.io.Serializable;
import java.util.List;

public class OtherVacancy implements Serializable {


   private List<Vacancy> vacancies;

    private String contacts;

    private String telephone;

    private String email;


    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "OtherVacancy{" +
                "vacancies=" + vacancies +
                ", contacts='" + contacts + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public OtherVacancy(){ }



}

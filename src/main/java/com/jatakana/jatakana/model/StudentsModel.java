package com.jatakana.jatakana.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "students_info")
public class StudentsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String infoYourself;
    private String nameParents;
    private int course;
    private String country;
    private String region;
    private String sik_f;
    private String sik_m;
    private String family_status;
    private String my_status;
    private int income;
    private String study_relative;
    private String have_home;
    private double point;

    public StudentsModel(String name, String email, String infoYourself, String nameParents, int course, String country, String region, String sik_f, String sik_m, String family_status, String my_status, int income, String study_relative, String have_home, double point) {
        this.name = name;
        this.email = email;
        this.infoYourself = infoYourself;
        this.nameParents = nameParents;
        this.course = course;
        this.country = country;
        this.region = region;
        this.sik_f = sik_f;
        this.sik_m = sik_m;
        this.family_status = family_status;
        this.my_status = my_status;
        this.income = income;
        this.study_relative = study_relative;
        this.have_home = have_home;
        this.point = point;
    }

    public StudentsModel() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfoYourself() {
        return infoYourself;
    }

    public void setInfoYourself(String infoYourself) {
        this.infoYourself = infoYourself;
    }

    public String getNameParents() {
        return nameParents;
    }

    public void setNameParents(String nameParents) {
        this.nameParents = nameParents;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSik_f() {
        return sik_f;
    }

    public void setSik_f(String sik_f) {
        this.sik_f = sik_f;
    }

    public String getSik_m() {
        return sik_m;
    }

    public void setSik_m(String sik_m) {
        this.sik_m = sik_m;
    }

    public String getFamily_status() {
        return family_status;
    }

    public void setFamily_status(String family_status) {
        this.family_status = family_status;
    }

    public String getMy_status() {
        return my_status;
    }

    public void setMy_status(String my_status) {
        this.my_status = my_status;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getStudy_relative() {
        return study_relative;
    }

    public void setStudy_relative(String study_relative) {
        this.study_relative = study_relative;
    }

    public String getHave_home() {
        return have_home;
    }

    public void setHave_home(String have_home) {
        this.have_home = have_home;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}

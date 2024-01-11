package com.jatakana.jatakana.services;

import com.jatakana.jatakana.model.StudentsModel;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    public static StudentsModel calculate(StudentsModel studentsModel) {
        double point = 0;
        if (studentsModel.getCourse() == 0)
            point = point + 1;
        if (!studentsModel.getCountry().equals("kg"))
            point = point + 1;
        if (studentsModel.getSik_f().equals("On"))
            point = point + 1;
        if (studentsModel.getSik_m().equals("On"))
            point = point + 1;
        if (!studentsModel.getInfoYourself().equals("good"))
            point = point + 1;
        if (studentsModel.getStudy_relative().equals("On"))
            point = point + 1;
        if (!studentsModel.getHave_home().equals("On"))
            point = point + 1;
        if (!studentsModel.getFamily_status().equals("with")) {
            point = point + 1;
            point = incomeCalc(studentsModel.getIncome()) + point;
        }
        switch (studentsModel.getRegion()) {
            case "naryn", "YK" -> point = point + 1;
            case "talas", "dj-abad" -> point = point + 1.5;
            case "osh" -> point = point + 2;
            case "batken" -> point = point + 3;
            default -> point = point + 0;
        }
        point = point * 10;
        studentsModel.setPoint(point);

        return studentsModel;
    }

    private static double incomeCalc(int income) {
        if (income < 21) {
            return 3;
        } else if (income < 31) {
            return 2;
        } else if (income < 41) {
            return 1;
        }
        return 0;
    }

    public static StudentsModel nullValidation(StudentsModel studentsModel) {
        if (studentsModel.getName() == null) studentsModel.setName(" ");
        if (studentsModel.getEmail() == null) studentsModel.setEmail(" ");
        if (studentsModel.getInfoYourself() == null) studentsModel.setInfoYourself(" ");
        if (studentsModel.getNameParents() == null) studentsModel.setNameParents(" ");
        if (studentsModel.getCountry() == null) studentsModel.setCountry(" ");
        if (studentsModel.getRegion() == null) studentsModel.setRegion(" ");
        if (studentsModel.getSik_f() == null) studentsModel.setSik_f(" ");
        if (studentsModel.getSik_m() == null) studentsModel.setSik_m(" ");
        if (studentsModel.getFamily_status() == null) studentsModel.setFamily_status(" ");
        if (studentsModel.getMy_status() == null) studentsModel.setMy_status(" ");
        if (studentsModel.getStudy_relative() == null) studentsModel.setStudy_relative(" ");
        if (studentsModel.getHave_home() == null) studentsModel.setHave_home(" ");
        return studentsModel;
    }
}

package com.jatakana.jatakana.controller;

import com.jatakana.jatakana.model.StudentsModel;
import com.jatakana.jatakana.repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

@Controller
public class MainPageController {
    @Autowired
    StudentsRepo studentsRepo;

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String mainG() {
        Random random = new Random();
        for (int i = 0; i < 45; i++) {
            studentsRepo.save(new StudentsModel("String name"+i, "String email"+i,
                    "String infoYourself"+i, "String nameParents"+i, 3, "String country"
                    , "String region"+i, "String sik_f"+i, "String sik_m"+i,
                    "String family_status"+i, "String my_status"+i,
                    10000, "String study_relative"+i, "String have_home"+i,
                    random.nextDouble() * 15.0));
        }
        return "index";
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.POST)
    public String mainP() {
        return "index";
    }
}

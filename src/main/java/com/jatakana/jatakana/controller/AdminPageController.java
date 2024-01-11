package com.jatakana.jatakana.controller;

import com.jatakana.jatakana.model.StudentsModel;
import com.jatakana.jatakana.repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminPageController {
    @Value("${room}")
    private int room;

    @Autowired
    private StudentsRepo studentsRepo;
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String mainG(Model model) {
        List<StudentsModel> studentsModels = studentsRepo.findByPoint();
        int queue = 1;
        for (int i = 0; i < studentsModels.size(); i++) {
            if (i < room) {
                studentsModels.get(i).setInfoYourself("жатаканага киришкендер");
            } else {
                studentsModels.get(i).setInfoYourself(String.valueOf(queue));
                queue++;
            }
        }

        model.addAttribute("studentsModels", studentsModels);
        return "admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String mainP() {
        return "admin";
    }
}

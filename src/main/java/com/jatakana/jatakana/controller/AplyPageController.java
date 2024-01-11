package com.jatakana.jatakana.controller;

import com.jatakana.jatakana.model.StudentsModel;
import com.jatakana.jatakana.repository.StudentsRepo;
import com.jatakana.jatakana.services.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AplyPageController {
    @Autowired
    StudentsRepo studentsRepo;
    @Value("${room}")
    private int room;
    private String MODEL_KEY = "value";
    private String firstH2Value = "Жатаканага катталуу";

    @RequestMapping(value = "/aply", method = RequestMethod.GET)
    public String mainG(Model model) {
        model.addAttribute(MODEL_KEY, firstH2Value);
        firstH2Value = "Сиз ийгиликтуу кезекке турдунуз!";
        return "aply";
    }

    @RequestMapping(value = "/aply", method = RequestMethod.POST)
    public String mainP(@ModelAttribute StudentsModel studentsModel) {
        StudentsModel validatedStudentsModel = CalculateService.nullValidation(studentsModel);

        validatedStudentsModel = CalculateService.calculate(validatedStudentsModel);
        studentsRepo.save(validatedStudentsModel);
        firstH2Value = "Кезегиниз келгенде почтанызга смс барат! Текшерип турунуз";

        return "redirect:/aply";
    }
}

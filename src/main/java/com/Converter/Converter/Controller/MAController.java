package com.Converter.Converter.Controller;

import com.Converter.Converter.Security.AllData;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;


@Controller
class MAController {
    @GetMapping("/")
    public String index(Model model) throws SQLException {
        AllData get = new AllData();

        System.out.println(get.GetAllData());


        model.addAttribute("name", get.GetAllData());
        return "index";
    }


}

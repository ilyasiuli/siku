package id.go.kemenkeu.siku.controllers;

import id.go.kemenkeu.siku.models.Indikator;
import id.go.kemenkeu.siku.services.IndikatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    IndikatorServices indikatorServices;


    @GetMapping("/siku/home")
    public String home(Model model){
        List<Indikator> indikatorList = indikatorServices.getAll();
        model.addAttribute("indikatorList",indikatorList);
        return "pages/home";
    }

    @GetMapping("/siku/indikator/{id}")
    public String show(@PathVariable long id, Model model){
        Indikator indikator = indikatorServices.getById(id);
        model.addAttribute("idk", indikator);
        return "pages/show";
    }

    @GetMapping("/siku/add")
    public String add(Model model){
        Indikator indikator = new Indikator();
        model.addAttribute("indikator",indikator);
        return "pages/add";
    }

    @PostMapping("/siku/indikator/create")
    public String createIndikator(@ModelAttribute(name = "indikator") Indikator indikator){
        indikatorServices.create(indikator);
        return "redirect:/siku/home";
    }
}

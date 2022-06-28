package id.go.kemenkeu.siku.controllers;

import id.go.kemenkeu.siku.models.Indikator;
import id.go.kemenkeu.siku.services.IndikatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("indikator")
public class MasterDataController {
    @Autowired
    IndikatorServices indikatorServices;

    @GetMapping("")
    public String home(Model model){
        List<Indikator> indikatorList = indikatorServices.getAll();
        model.addAttribute("indikatorList",indikatorList);
        return "pages/indikator/indikator-index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model){
        Indikator indikator = indikatorServices.getById(id);
        model.addAttribute("idk", indikator);
        return "pages/indikator/indikator-show";
    }

    @GetMapping("/add")
    public String add(Model model){
        Indikator indikator = new Indikator();
        model.addAttribute("indikator",indikator);
        return "pages/indikator/indikator-add";
    }

    @PostMapping("/create")
    public String createIndikator(@ModelAttribute(name = "indikator") Indikator indikator){
        indikatorServices.create(indikator);
        return "redirect:/indikator";
    }
}

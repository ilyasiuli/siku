package id.go.kemenkeu.siku.controllers;

import id.go.kemenkeu.siku.models.Indikator;
import id.go.kemenkeu.siku.services.IndikatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("indikator")
public class MasterDataController {
    @Autowired
    IndikatorServices indikatorServices;

    @GetMapping("")
    public String index(Model model){
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
    public String create(@Valid @ModelAttribute(name = "indikator") Indikator indikator,
                                  BindingResult result){
        if(result.hasErrors()){
            return "redirect:/indikator/add";
        }
        indikatorServices.create(indikator);
        return "redirect:/indikator";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id){
        Indikator indikator = indikatorServices.getById(id);
        if(!model.containsAttribute("data")){
            model.addAttribute("data",indikator);
        }
        return "pages/indikator/indikator-edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute(name = "data") Indikator indikator,
                                  BindingResult result){
        if(result.hasErrors()){
            return "redirect:/indikator/edit/"+indikator.getId();
        }
        indikatorServices.update(indikator);
        return "redirect:/indikator";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id){
        Indikator indikator = indikatorServices.getById(id);
        indikatorServices.delete(indikator);
        return "redirect:/indikator";
    }
}

package com.assettracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.assettracking.entity.Asset;
import com.assettracking.service.AssetService;

@Controller
public class ViewController {

    @Autowired
    private AssetService service;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("assets", service.getAll());
        model.addAttribute("asset", new Asset());
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Asset asset) {
        service.create(asset);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.softDelete(id);
        return "redirect:/";
    }
}

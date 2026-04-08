package com.assettracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.assettracking.entity.Asset;
import com.assettracking.service.AssetService;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService service;

    @PostMapping
    public Asset create(@RequestBody Asset asset) {
        return service.create(asset);
    }
    
    
//    @PostMapping
//    public String test(@RequestBody String body) {
//        return body;
//    }
    

    @GetMapping
    public List<Asset> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Asset getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PatchMapping("/{id}")
    public Asset update(@PathVariable Long id, @RequestBody Asset asset) {
        return service.update(id, asset);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.softDelete(id);
        return "Asset soft deleted successfully";
    }
}

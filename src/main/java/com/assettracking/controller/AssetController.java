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

    // ✅ CREATE
    @PostMapping
    public Asset create(@RequestBody Asset asset) {
        return service.create(asset);
    }
    
    
//    @PostMapping
//    public String test(@RequestBody String body) {
//        return body;
//    }
    

    // ✅ GET ALL (no casting needed)
    @GetMapping
    public List<Asset> getAll() {
        return service.getAll();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public Asset getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // ✅ UPDATE (PATCH)
    @PatchMapping("/{id}")
    public Asset update(@PathVariable Long id, @RequestBody Asset asset) {
        return service.update(id, asset);
    }

    // ✅ SOFT DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.softDelete(id);
        return "Asset soft deleted successfully";
    }
}
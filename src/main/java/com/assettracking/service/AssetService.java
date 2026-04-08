package com.assettracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assettracking.entity.Asset;
import com.assettracking.repository.AssetRepository;

@Service
public class AssetService {

    @Autowired
    private AssetRepository repo;

    
    public Asset create(Asset asset) {
        return repo.save(asset);
    }

    public List<Asset> getAll() {
        return repo.findByDeletedFalse();   
    }

    
    public Asset getById(Long id) {
        return repo.findById(id)
                .filter(a -> !a.isDeleted())
                .orElseThrow(() -> new RuntimeException("Asset not found"));
    }

   
    public Asset update(Long id, Asset updated) {
        Asset a = getById(id);

        if (updated.getName() != null) a.setName(updated.getName());
        if (updated.getType() != null) a.setType(updated.getType());
        if (updated.getStatus() != null) a.setStatus(updated.getStatus());

        return repo.save(a);
    }

    public void softDelete(Long id) {
        Asset a = getById(id);
        a.setDeleted(true);
        repo.save(a);
    }
}

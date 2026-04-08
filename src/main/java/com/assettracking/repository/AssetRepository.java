package com.assettracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assettracking.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    List<Asset> findByDeletedFalse();  
}

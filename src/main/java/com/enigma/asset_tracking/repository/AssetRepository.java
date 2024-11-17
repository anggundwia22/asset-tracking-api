package com.enigma.asset_tracking.repository;

import com.enigma.asset_tracking.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}

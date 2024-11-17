package com.enigma.asset_tracking.service;

import com.enigma.asset_tracking.dto.request.AssetRequest;
import com.enigma.asset_tracking.dto.response.AssetResponse;
import com.enigma.asset_tracking.entity.Asset;
import com.enigma.asset_tracking.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<AssetResponse> getAllAssets() {
        return assetRepository.findAll().stream()
                .map(asset -> new AssetResponse(asset.getId(), asset.getName(), asset.getType(), asset.getStatus()))
                .collect(Collectors.toList());
    }

    public AssetResponse addAsset(AssetRequest request) {
        Asset asset = Asset.builder()
                .name(request.getName())
                .type(request.getType())
                .status(request.getStatus())
                .build();
        asset = assetRepository.save(asset);
        return new AssetResponse(asset.getId(), asset.getName(), asset.getType(), asset.getStatus());
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
}

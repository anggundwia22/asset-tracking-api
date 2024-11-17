package com.enigma.asset_tracking.controller;

import com.enigma.asset_tracking.dto.request.AssetRequest;
import com.enigma.asset_tracking.dto.response.AssetResponse;
import com.enigma.asset_tracking.service.AssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public ResponseEntity<List<AssetResponse>> getAllAssets() {
        return ResponseEntity.ok(assetService.getAllAssets());
    }

    @PostMapping
    public ResponseEntity<AssetResponse> addAsset(@RequestBody AssetRequest request) {
        return ResponseEntity.ok(assetService.addAsset(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id);
        return ResponseEntity.noContent().build();
    }
}

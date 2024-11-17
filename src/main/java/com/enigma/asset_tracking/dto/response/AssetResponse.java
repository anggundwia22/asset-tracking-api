package com.enigma.asset_tracking.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetResponse {
    private String id;
    private String name;
    private String type;
    private String status;
}

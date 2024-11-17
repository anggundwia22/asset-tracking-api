package com.enigma.asset_tracking.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetRequest {
    private String name;
    private String type;
    private String status;
}

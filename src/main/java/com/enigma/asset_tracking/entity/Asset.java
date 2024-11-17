package com.enigma.asset_tracking.entity;

import com.enigma.asset_tracking.constant.Constant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = Constant.ASSET_TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    private String status;
}

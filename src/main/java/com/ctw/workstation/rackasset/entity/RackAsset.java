package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.rack.entity.Rack;
import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name="t_rack_asset")
public class RackAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "asset_tag", length = 30)
    private String assetTag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", nullable = false)
    private Rack rack;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }
}

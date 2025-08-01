package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.rackasset.entity.RackAsset;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackAssetRepository implements PanacheRepositoryBase<RackAsset,UUID> {

    public List<RackAsset> listByRackId(UUID rackId) {
        return find("rack.id", rackId).list();
    }
}

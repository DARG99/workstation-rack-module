// src/main/java/com/ctw/workstation/rack/boundary/RackRepository.java
package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.entity.Rack;          // ← import the right entity
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;
import java.util.function.Supplier;

@ApplicationScoped
public class RackRepository implements PanacheRepositoryBase<Rack, UUID> {

}

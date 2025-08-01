package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;

import java.util.UUID;
@Transactional
@ApplicationScoped
public class TeamRepository implements PanacheRepositoryBase<Team, UUID> {



}

package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberRepository implements PanacheRepositoryBase<TeamMember,UUID> {

    public List<TeamMember> listByTeamId(UUID teamId) {
        return list("team.id", teamId);
    }
}
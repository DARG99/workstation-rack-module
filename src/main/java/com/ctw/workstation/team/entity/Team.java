    package com.ctw.workstation.team.entity;

    import com.ctw.workstation.teammember.entity.TeamMember;
    import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
    import jakarta.persistence.*;
    import org.eclipse.microprofile.openapi.annotations.media.Schema;
    import org.hibernate.annotations.CreationTimestamp;
    import org.hibernate.annotations.UpdateTimestamp;

    import java.sql.Timestamp;
    import java.util.Date;
    import java.util.List;
    import java.util.UUID;

    @Entity
    @Table(name="t_team")
    public class Team extends PanacheEntityBase {

        @Id
        @Schema(hidden = true)
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(name="name", length = 30)
        private String name;

        @Column(name="product", length = 30)
        private String product;

        @Schema(hidden = true)
        @Column(name="created_at")
        @CreationTimestamp
        private Timestamp createdAt;

        @Schema(hidden = true)
        @Column(name="modified_at")
        @UpdateTimestamp
        private Timestamp modifiedAt;

        @Column(name="default_location", length = 50)
        private String defaultLocation;

        @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
        private List<TeamMember> teamMembers;


        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public Timestamp getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Timestamp createdAt) {
            this.createdAt = createdAt;
        }

        public Timestamp getModifiedAt() {
            return modifiedAt;
        }

        public void setModifiedAt(Timestamp modifiedAt) {
            this.modifiedAt = modifiedAt;
        }

        public String getDefaultLocation() {
            return defaultLocation;
        }

        public void setDefaultLocation(String defaultLocation) {
            this.defaultLocation = defaultLocation;
        }

        public List<TeamMember> getTeamMembers() {
            return teamMembers;
        }

        public void setTeamMembers(List<TeamMember> teamMembers) {
            this.teamMembers = teamMembers;
        }
        }

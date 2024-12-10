package ru.asocial.pm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity(name = "project_member_project")
@IdClass(value = ProjectMemberComposite.class)
public class ProjectMemberProject {
    
    @Id
    @Column(name = "project_id")
    private Long projectId;
    
    @Id
    @Column(name = "project_member_id")
    private Long projectMemberId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectMemberId() {
        return projectMemberId;
    }

    public void setProjectMemberId(Long projectMemberId) {
        this.projectMemberId = projectMemberId;
    }
}

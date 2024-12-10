package ru.asocial.pm.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProjectMemberComposite implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long projectId;
    
    private Long projectMemberId;
    
    public Long getDepartmentId() {
        return projectId;
    }
    public void setDepartmentId(Long departmentId) {
        this.projectId = departmentId;
    }
    public Long getEmployeeId() {
        return projectMemberId;
    }
    public void setEmployeeId(Long employeeId) {
        this.projectMemberId = employeeId;
    }
   
}

package ru.asocial.pm.model.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "project")
public class ProjectEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @Column
    private String title;
    
    @Column(name = "due_date")
    private LocalDate dueDate;
    
    @Column(name = "date_started")
    private LocalDate dateStarted;
    
    @Column(name = "date_completed")
    private LocalDate dateCompleted;
    
    @Column
    private String status;
    
    @Column
    private Integer progress;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ProjectGoal> goals;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Set<ProjectGoal> getGoals() {
        return goals;
    }

    public void setGoals(Set<ProjectGoal> goals) {
        this.goals = goals;
    }
    
    
}

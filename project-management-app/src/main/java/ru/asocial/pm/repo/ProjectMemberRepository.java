package ru.asocial.pm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.asocial.pm.model.entity.ProjectMemberEntity;

public interface ProjectMemberRepository extends JpaRepository<ProjectMemberEntity, Long> {

}

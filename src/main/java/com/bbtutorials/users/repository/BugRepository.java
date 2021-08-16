package com.bbtutorials.users.repository;
import com.bbtutorials.users.entity.Bug;

import com.bbtutorials.users.entity.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface BugRepository extends JpaRepository<Bug, Integer>, JpaSpecificationExecutor<Bug>, QuerydslPredicateExecutor<Bug> {
}

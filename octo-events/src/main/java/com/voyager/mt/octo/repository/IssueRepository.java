package com.voyager.mt.octo.repository;

import com.voyager.mt.octo.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}

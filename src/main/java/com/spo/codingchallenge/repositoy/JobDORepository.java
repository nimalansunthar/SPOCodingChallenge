package com.spo.codingchallenge.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spo.codingchallenge.domain_objects.JobDO;

@Repository
public interface JobDORepository extends JpaRepository<JobDO, Long>{

}



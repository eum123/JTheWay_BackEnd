package net.jtheway.web.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.jtheway.web.sample.entity.SampleEntity;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, String>{

}

package net.jtheway.web.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jtheway.web.sample.entity.SampleEntity;

public interface SampleRepository extends JpaRepository<SampleEntity, String>{

}

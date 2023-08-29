package com.example.callToApi.repository;

import com.example.callToApi.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface IDriverRepository extends JpaRepository<Driver, Integer> {
}

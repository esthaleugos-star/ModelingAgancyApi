package com.example.ModelingAgancyApi.repository;

import com.example.ModelingAgancyApi.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    // Standard CRUD methods are inherited automatically
}
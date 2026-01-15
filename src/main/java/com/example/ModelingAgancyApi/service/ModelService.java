package com.example.ModelingAgancyApi.service;

import com.example.ModelingAgancyApi.model.Model;
import java.util.List;
import java.util.Optional;

public interface ModelService {
    Model saveModel(Model model);
    List<Model> getAllModels();
    Optional<Model> getModelById(Long id);
    Model updateModel(Long id, Model modelDetails); // 🆕 New
    void deleteModel(Long id); // 🆕 New
}
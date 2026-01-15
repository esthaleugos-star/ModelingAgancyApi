package com.example.ModelingAgancyApi.service;

import com.example.ModelingAgancyApi.model.Model;
import com.example.ModelingAgancyApi.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public Optional<Model> getModelById(Long id) {
        return modelRepository.findById(id);
    }

    @Override
    public Model updateModel(Long id, Model modelDetails) {
        return modelRepository.findById(id).map(model -> {
            // 📝 Update fields (adjust these to match your Model.java)
            model.setFirstName(modelDetails.getFirstName());
            model.setLastName(modelDetails.getLastName());
            // Add other fields like model.setAge(modelDetails.getAge());
            return modelRepository.save(model);
        }).orElseThrow(() -> new RuntimeException("Model not found with id: " + id));
    }

    @Override
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }
}
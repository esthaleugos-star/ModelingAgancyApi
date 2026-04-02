package com.example.ModelingAgancyApi.service;

import com.example.ModelingAgancyApi.model.Model;
import com.example.ModelingAgancyApi.model.Product;
import com.example.ModelingAgancyApi.repository.ModelRepository;
import com.example.ModelingAgancyApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ProductRepository productRepository;

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

            model.setFirstName(modelDetails.getFirstName());
            model.setLastName(modelDetails.getLastName());
            model.setEmail(modelDetails.getEmail());
            model.setHeight(modelDetails.getHeight());
            model.setAge(modelDetails.getAge());
            model.setGender(modelDetails.getGender());

            return modelRepository.save(model);

        }).orElseThrow(() -> new RuntimeException("Model not found with id: " + id));
    }

    @Override
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    // ✅ NEW METHOD FOR ASSIGNING PRODUCT
    @Override
    public Model assignProductToModel(Long modelId, Long productId) {

        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new RuntimeException("Model not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        model.getProducts().add(product);

        return modelRepository.save(model);
    }
}
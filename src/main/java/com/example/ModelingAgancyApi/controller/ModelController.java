package com.example.ModelingAgancyApi.controller;

import com.example.ModelingAgancyApi.model.Model;
import com.example.ModelingAgancyApi.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping
    public Model createModel(@RequestBody Model model) {
        return modelService.saveModel(model);
    }

    @GetMapping
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable Long id) {
        return modelService.getModelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable Long id, @RequestBody Model modelDetails) {
        return ResponseEntity.ok(modelService.updateModel(id, modelDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable Long id) {
        modelService.deleteModel(id);
        return ResponseEntity.ok("Model deleted successfully");
    }

    // ✅ NEW ENDPOINT
    @PutMapping("/{modelId}/assign-product/{productId}")
    public ResponseEntity<Model> assignProductToModel(
            @PathVariable Long modelId,
            @PathVariable Long productId) {

        Model updatedModel = modelService.assignProductToModel(modelId, productId);
        return ResponseEntity.ok(updatedModel);
    }
}
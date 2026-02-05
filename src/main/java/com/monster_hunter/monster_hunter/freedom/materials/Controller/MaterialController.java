package com.monster_hunter.monster_hunter.monster_hunter_freedom.materials.Controller;

import com.monster_hunter.monster_hunter.freedom.materials.Entity.Material;
import com.monster_hunter.monster_hunter.freedom.materials.Service.MaterialService;
import com.monster_hunter.monster_hunter.freedom.materials.enums.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    // Obtener todos: GET http://localhost:8080/api/materials
    @GetMapping
    public List<Material> getAll() {
        return materialService.getAllMaterials();
    }

    // Obtener uno por ID: GET http://localhost:8080/api/materials/1
    @GetMapping("/{id}")
    public ResponseEntity<Material> getById(@PathVariable Long id) {
        return materialService.getMaterialById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear material: POST http://localhost:8080/api/materials
    @PostMapping
    public ResponseEntity<Material> create(@RequestBody Material material) {
        Material savedMaterial = materialService.saveMaterial(material);
        return new ResponseEntity<>(savedMaterial, HttpStatus.CREATED);
    }

    // Buscar por categoría: GET http://localhost:8080/api/materials/category/ORE
    @GetMapping("/category/{category}")
    public List<Material> getByCategory(@PathVariable Category category) {
        return materialService.getMaterialsByCategory(category);
    }

    // Borrar: DELETE http://localhost:8080/api/materials/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
package com.monster_hunter.monster_hunter.freedom.materials.Service;

import com.monster_hunter.monster_hunter.freedom.materials.Entity.Material;
import com.monster_hunter.monster_hunter.freedom.materials.Repository.MaterialRepository;
import com.monster_hunter.monster_hunter.freedom.materials.enums.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Genera el constructor para la inyección de dependencias (Lombok)
public class MaterialService {

    private final MaterialRepository materialRepository;

    // Obtener todos los materiales
    @Transactional(readOnly = true)
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    // Buscar por ID
    @Transactional(readOnly = true)
    public Optional<Material> getMaterialById(Long id) {
        return materialRepository.findById(id);
    }

    // Guardar o actualizar un material
    @Transactional
    public Material saveMaterial(Material material) {
        // Aquí podrías agregar validaciones, por ejemplo, que el nombre no esté vacío
        return materialRepository.save(material);
    }

    // Buscar por categoría
    @Transactional(readOnly = true)
    public List<Material> getMaterialsByCategory(Category category) {
        return materialRepository.findByCategory(category);
    }

    // Eliminar un material
    @Transactional
    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}
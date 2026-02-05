package com.monster_hunter.monster_hunter.freedom.materials.Repository;

import com.monster_hunter.monster_hunter.freedom.materials.Entity.Material;
import com.monster_hunter.monster_hunter.freedom.materials.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    //Buscar por categoria exacta
    List<Material> findByCategory(Category category);

    //Ejemplo de búsqueda dentro de un campo JSONB (Native Query para PostgreSQL
    //Esto busca materiales donde el nombre en español coincida
    @Query(value = "SELECT * FROM Material WHERE name ->> 'es' ILIKE %:name%", nativeQuery = true)
    List<Material> findByNameSpanish(@Param("name") String name);
}

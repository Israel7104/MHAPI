package com.monster_hunter.monster_hunter.monster_hunter_freedom.materials.Entity;


import com.monster_hunter.monster_hunter.monster_hunter_freedom.materials.enums.Category;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Name of the objects/materials
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> name;
}

    //Description of the objects/materials
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> description;



    //How to get
    @Type(JsonBinaryType)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> howTo;

    //Category
    @Column(name = "category")
    private Category Category;
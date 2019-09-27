package com.uco.vertilvideos.repository;

import com.uco.vertilvideos.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Serializable> {

}

package com.uco.vertilvideos.repository;

import com.uco.vertilvideos.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Serializable> {

    @Query("select p from PersonEntity p where p.identification = :identification")
    PersonEntity findForIdPerson(@Param("identification") String identification);

}

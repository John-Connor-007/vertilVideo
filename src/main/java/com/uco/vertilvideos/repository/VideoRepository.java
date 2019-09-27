package com.uco.vertilvideos.repository;

import com.uco.vertilvideos.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Serializable> {

    @Query("select v from VideoEntity v where v.idPerson = :idPerson")
    List<VideoEntity> searchAllVideoForPerson(@Param("idPerson")int idPerson);
}

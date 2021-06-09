package com.core.repositories;

import com.core.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {


    @Query(name = "get_default_attrs", nativeQuery = true)
    List<Attribute> getDefaultAttributesByObjectTypeId(@Param("objectTypeId") long objectTypeId);

}

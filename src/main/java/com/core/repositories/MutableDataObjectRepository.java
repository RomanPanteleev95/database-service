package com.core.repositories;

import com.core.model.MutableDataObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MutableDataObjectRepository extends JpaRepository<MutableDataObject, Long> {

    @Query("select o from MutableDataObject o where o.parent.objectId = (:id)")
    List<MutableDataObject> getAllChildren(long id);

    @Query("select o from MutableDataObject o where o.objectType.objectTypeId = (:objectTypeId) and o.parent.objectId = (:parentId)")
    List<MutableDataObject> getChildrenByObjectType(long objectTypeId, long parentId);

    @Modifying
    @Query(value = "insert into params (object_id, attr_id, value) values (:objectId, :attrId, :value)", nativeQuery = true)
    void setStringValue(long objectId, long attrId, String value);

    @Query(value = "select value from params where object_id = :objectId and attr_id = :attrId", nativeQuery = true)
    String getValue(long objectId, long attrId);
}

with recursive tmp as (
    select object_type_id, parent_id from object_types where object_type_id = 2
    union all
    select ot.object_type_id, t.parent_id from tmp t
    inner join object_types ot on ot.parent_id = t.object_type_id

) select object_type_id from tmp;


-- get all attributes by object type
with recursive tmp as (
    select object_type_id, parent_id from object_types where object_type_id = :objectTypeId
    union all
    select ot.object_type_id, t.parent_id from tmp t
                                                   inner join object_types ot on ot.parent_id = t.object_type_id

) select attr.attribute_id, attr.default_value from
    attributes attr,
    tmp t
where t.object_type_id = attr.object_type_id
and attr.default_value is not null;
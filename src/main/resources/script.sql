alter table attributes
add object_type_id bigint references object_types(object_type_id);

-- create table attributes
-- (
--     attribute_id      serial not null
--         constraint attributes_pkey
--             primary key,
--     name              varchar(200),
--     attribute_type_id bigint
--         constraint attributes_attribute_type_id_fkey
--             references attribute_types,
--     description       varchar(500),
--     object_type_id bigint
--         constraint attributes_object_type_id_fkey
--             references object_types,
--     default_value varchar(200)
-- );
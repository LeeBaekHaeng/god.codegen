--https://www.postgresql.org/docs/current/information-schema.html

--https://www.postgresql.org/docs/current/infoschema-columns.html

select
    a.*
from information_schema.columns a
where 1 = 1
    and a.table_schema = 'public'
--    and a.column_name = 'code_id'
    and a.column_name = 'cl_code'
order by
    a.table_catalog, a.table_schema, a.table_name, ordinal_position
;

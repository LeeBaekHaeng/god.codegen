--https://www.postgresql.org/docs/current/information-schema.html

--https://www.postgresql.org/docs/current/infoschema-tables.html

select
    a.*
from information_schema.tables a
where 1 = 1
    and a.table_schema = 'public'
order by
    a.table_catalog, a.table_schema, a.table_name
;

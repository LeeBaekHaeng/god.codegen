select
	*
from
	INFORMATION_SCHEMA.TABLES
where
	1 = 1
	-- 	and TABLE_CATALOG = 'def'
	and TABLE_SCHEMA = 'information_schema'
order by
	TABLE_CATALOG,
	TABLE_SCHEMA,
	TABLE_NAME
;

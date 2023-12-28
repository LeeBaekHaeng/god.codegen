select
	*
from
	INFORMATION_SCHEMA.COLUMNS
where
	1 = 1
	-- 	and TABLE_CATALOG = 'def'
	and TABLE_SCHEMA = 'com'
	and COLUMN_NAME like '%_AT'
order by
	TABLE_CATALOG,
	TABLE_SCHEMA,
	TABLE_NAME,
	ORDINAL_POSITION
;

select
	COLUMN_NAME,
	COLUMN_COMMENT,
	count(*)
from
	INFORMATION_SCHEMA.COLUMNS
where
	1 = 1
	-- 	and TABLE_CATALOG = 'def'
	and TABLE_SCHEMA = 'com'
	and COLUMN_NAME like '%_AT'
group by
	COLUMN_NAME,
	COLUMN_COMMENT
order by
	COLUMN_NAME,
	COLUMN_COMMENT
;

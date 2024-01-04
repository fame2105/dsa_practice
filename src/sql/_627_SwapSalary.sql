
-- CASE clause in mysql :
-- SELECT column1, column2,
-- CASE
-- WHEN condition1 THEN result1
-- WHEN condition2 THEN result2
-- WHEN condition3 THEN result3
-- ELSE result
-- END AS alias_name
-- FROM table_name

UPDATE salary SET sex = (
    CASE
    WHEN sex = 'm' THEN 'f'
    ELSE 'm'
    END
);
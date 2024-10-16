-- Syntax for IF clause :

-- SELECT column1, column2
-- IF(condition, Result if condition is true, Result if condition is false) AS alias_name
-- FROM table_name

-- SOLUTION #1 USING IF CLAUSE:
-- SELECT employee_id,
-- If(employee_id%2 != 0 AND name NOT LIKE 'M%', salary, 0) AS bonus
-- FROM Employees
-- ORDER BY employee_id;


-- CASE clause in mysql :
-- SELECT column1, column2,
-- CASE
-- WHEN condition1 THEN result1
-- WHEN condition2 THEN result2
-- WHEN condition3 THEN result3
-- ELSE result
-- END AS alias_name
-- FROM table_name

-- SOLUTION #2 USING CASE CLAUSE:
SELECT employee_id,
CASE
WHEN employee_id % 2 != 0 AND name NOT LIKE 'M%' THEN salary
ELSE 0
END AS bonus
FROM Employees
ORDER BY employee_id

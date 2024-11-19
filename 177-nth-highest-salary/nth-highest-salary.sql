CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE offset_value INT;
  SET offset_value = N - 1;

  RETURN (
    SELECT Distinct salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET offset_value
  );
END;

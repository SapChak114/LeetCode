# Write your MySQL query statement below
Select d.name as Department, e1.Name as Employee, e1.Salary FROM Employee e1 join Department d ON (e1.DepartmentId=d.id) where 3 > 
(
    Select count(distinct e2.Salary) FROM Employee e2 WHERE e2.Salary > e1.Salary AND e1.DepartmentId = e2.DepartmentId);
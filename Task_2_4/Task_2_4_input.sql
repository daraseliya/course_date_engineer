/* TASK 2.4 */

/*
a.     Попробуйте вывести не просто самую высокую зарплату во всей команде, а вывести именно фамилию сотрудника с самой высокой зарплатой.
*/

SELECT Salary, FullName 
FROM employees
WHERE Salary=(SELECT MAX(Salary) FROM employees);

SELECT FullName
FROM employees
WHERE Salary=(SELECT MAX(Salary) FROM employees);

/*    
b. Попробуйте вывести фамилии сотрудников в алфавитном порядке
*/
SELECT FullName 
FROM employees
ORDER BY FullName ASC;

/*
c.     Рассчитайте средний стаж для каждого уровня сотрудников
*/

/*Можно отдельно: */

SELECT AVG('2022-11-04'-StartDate) AS WorkExperienceDaysAvg
FROM employees
WHERE EmployeeLevel='jun';

/*А можно сгруппировать (стаж выводит в днях): */

SELECT EmployeeLevel,AVG('2022-11-04'-StartDate) AS WorkExperienceDaysAvg
FROM employees
GROUP BY EmployeeLevel;

/*
d.     Выведите фамилию сотрудника и название отдела, в котором он работает
*/

SELECT FullName,DepartmenrTitle
FROM employees
LEFT JOIN departments
ON employees.DepartmentID=departments.Id;

/*
e.     Выведите название отдела и фамилию сотрудника с самой высокой зарплатой в данном отделе и саму зарплату также.
*/

SELECT employees2.MaxSal, DepartmenrTitle, FullName
FROM  departments
INNER JOIN 
(
	SELECT Max(Salary) AS MaxSal, DepartmentID
	FROM employees
	GROUP BY DepartmentID
) AS employees2
ON employees2.DepartmentID=departments.Id
LEFT JOIN employees
ON employees.DepartmentID=departments.Id AND employees2.MaxSal=employees.Salary
 


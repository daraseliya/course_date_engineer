/*
 1. Создать таблицу с основной информацией о сотрудниках: ФИО, дата рождения, дата начала работы, должность, уровень сотрудника (jun, middle, senior, lead), уровень зарплаты, идентификатор отдела, наличие/отсутствие прав(True/False). При этом в таблице обязательно должен быть уникальный номер для каждого сотрудника. 
4. Несколько уточнений по предыдущим заданиям – в первой таблице должны быть записи как минимум о 5 сотрудниках, которые работают как минимум в 2-х разных отделах. Содержимое соответствующих атрибутов остается на совесть вашей фантазии, но, желательно соблюдать осмысленность и правильно выбирать типы данных (для зарплаты – числовой тип, для ФИО – строковый и т.д.) 
*/

-- DROP TABLE employees;

CREATE TABLE employees
(
	Id SERIAL PRIMARY KEY,
	FullName CHARACTER VARYING(80) NOT NULL,
	BirthDate date,
	StartDate date,
	JobTitle CHARACTER VARYING(30),
	EmployeeLevel CHARACTER VARYING(20),
	Salary INTEGER,
	DepartmentID INTEGER,
	DriverLicense BOOLEAN
);

INSERT INTO employees(FullName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,DriverLicense)
VALUES ('Иванов Иван Иванович', '1970-1-1','2012-9-12','Инженер','senior',150000,1,'True');

INSERT INTO employees(FullName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,DriverLicense)
VALUES ('Перов Константин Игоревич', '1971-1-1','2010-9-22','Инженер','lead',155000,1,'True');

INSERT INTO employees(FullName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,DriverLicense)
VALUES ('Яковлев Максим Игоревич', '1991-1-1','2020-5-22','Ассистент','jun',45000,1,'True');

INSERT INTO employees(FullName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,DriverLicense)
VALUES ('Чесноков Игорь Игоревич', '1994-3-1','2021-6-22','Лаборант','jun',40000,2,'False');

INSERT INTO employees(FullName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,DriverLicense)
VALUES ('Числов Игорь Игоревич','1992-3-1','2022-6-12','Лаборант','jun',40000,3,'False');

INSERT INTO employees(FullName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,DriverLicense)
VALUES ('Кротов Игорь Игоревич','1992-3-1','2022-6-12','Лаборант','jun',40000,3,'True');

INSERT INTO employees(FullName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,DriverLicense)
VALUES ('Сидоров Семен Игоревич' ,'1992-3-1','2020-6-12','Инженер','lead',65000,3,'True');

-- SELECT * FROM employees;

/* 
2. Для будущих отчетов аналитики попросили вас создать еще одну таблицу с информацией по отделам – в таблице должен быть идентификатор для каждого отдела, название отдела (например. Бухгалтерский или IT отдел), ФИО руководителя и количество сотрудников.
*/

CREATE TABLE departments
(
	Id SERIAL PRIMARY KEY,
	DepartmenrTitle CHARACTER VARYING(60) NOT NULL,
	LeaderFullName CHARACTER VARYING(80) NOT NULL,
	NumberOfEmployees INTEGER
);

INSERT INTO departments(DepartmenrTitle,LeaderFullName,NumberOfEmployees)
VALUES ('Кафедра ИТ', 'Семенов Василий Иванович', 20);

INSERT INTO departments(DepartmenrTitle,LeaderFullName,NumberOfEmployees)
VALUES ('Институт ПМ', 'Кадров Виктор Викторович', 15);

INSERT INTO departments(DepartmenrTitle,LeaderFullName,NumberOfEmployees)
VALUES ('Кафедра ПХ', 'Орлов Александр Валерьевич', 19);

-- SELECT * FROM departments;

/*        
3. На кону конец года и необходимо выплачивать сотрудникам премию. Премия будет выплачиваться по совокупным оценкам, которые сотрудники получают в каждом квартале года. Создайте таблицу, в которой для каждого сотрудника будут его оценки за каждый квартал. Диапазон оценок от A – самая высокая, до E – самая низкая.
*/

CREATE TABLE estimates
(
	EmplId INTEGER,
	Q1estimate CHARACTER VARYING(2),
	Q2estimate CHARACTER VARYING(2),
	Q3estimate CHARACTER VARYING(2),
	Q4estimate CHARACTER VARYING(2)
);

INSERT INTO estimates(EmplId, Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES (1, 'A','A','A','A');

INSERT INTO estimates(EmplId, Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES (2, 'A','B','A','A');

INSERT INTO estimates(EmplId, Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES (3, 'C','B','D','A');

INSERT INTO estimates(EmplId, Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES (4, 'B','B','B','A');

INSERT INTO estimates(EmplId, Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES (5, 'E','B','D','A');

INSERT INTO estimates(EmplId, Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES (6 ,'D','B','D','A');

INSERT INTO estimates(EmplId, Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES (7,'D','B','D','A');

-- SELECT * FROM estimates;

/* 
5. Ваша команда расширяется и руководство запланировало открыть новый отдел – отдел Интеллектуального анализа данных. На начальном этапе в команду наняли одного руководителя отдела и двух сотрудников. Добавьте необходимую информацию в соответствующие таблицы.
*/

INSERT INTO departments(DepartmenrTitle,LeaderFullName,NumberOfEmployees)
VALUES ('отдел Интеллектуального анализа данных', 'Орехов Иван Алексеевич', 3);

INSERT INTO employees(FullName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,DriverLicense)
VALUES ('Орехов Иван Алексеевич','1972-1-1','2012-9-12','Руководитель отдела','lead',300000,4,'True');

INSERT INTO employees(FullName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,DriverLicense)
VALUES ('Степанов Семен Семенович','1970-1-1','2012-9-12','Дата Инженер','senior',150000,4,'True');

INSERT INTO employees(FullName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,DriverLicense)
VALUES ('Орлов Александр Валерьевич', '1970-1-1','2012-9-12','Инженер','jun',100000,4,'True');

INSERT INTO estimates(EmplId, Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES (8,'A','B','B','A');
INSERT INTO estimates(EmplId, Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES (9,'A','B','B','A');
INSERT INTO estimates(EmplId, Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES (10,'A','B','A','A');

/*
6. Теперь пришла пора анализировать наши данные – напишите запросы для получения следующей информации:
*/
/*
   Уникальный номер сотрудника, его ФИО и стаж работы – для всех сотрудников компании
*/

SELECT Id,FullName,StartDate,'2022-11-04'-StartDate as WorkExperienceDays
FROM employees;


/*
 Уникальный номер сотрудника, его ФИО и стаж работы – только первых 3-х сотрудников
*/

SELECT Id,FullName,'2022-11-04'-StartDate as WorkExperienceDays
FROM employees
WHERE Id<4;


/*
второй вариант:
*/

SELECT Id,FullName,'2022-11-04'-StartDate as WorkExperienceDays
FROM employees
LIMIT 3;



  /*   
Уникальный номер сотрудников - водителей
*/
SELECT Id
FROM employees
WHERE DriverLicense = 'True';


/*
проверка
*/

SELECT Id,FullName,DriverLicense
FROM employees
WHERE DriverLicense = 'True';

/*
Выведите номера сотрудников, которые хотя бы за 1 квартал получили оценку D или E
*/

SELECT EmplId
FROM estimates
WHERE Q1estimate = 'D' OR Q1estimate = 'E' OR Q2estimate = 'D' OR Q2estimate = 'E' OR Q3estimate = 'D' OR Q3estimate = 'E'OR Q4estimate = 'D' OR Q4estimate = 'E';


/*
Выведите самую высокую зарплату в компании.
*/

SELECT MAX(Salary)
FROM employees;


/*
 Выведите название самого крупного отдела
*/
SELECT DepartmenrTitle 
FROM departments
WHERE NumberOfEmployees=(SELECT MAX(NumberOfEmployees) FROM departments);


/*
 Выведите номера сотрудников от самых опытных до вновь прибывших
*/
SELECT Id, '2022-11-04'-StartDate as WorkExperienceDays
FROM employees
ORDER BY StartDate ASC;


/*
 Рассчитайте среднюю зарплату для каждого уровня сотрудников
*/
SELECT AVG(Salary) AS SalaryAvg
FROM employees
WHERE EmployeeLevel='jun';


/*
для всех
*/ 

SELECT EmployeeLevel, AVG(Salary) AS SalaryAvg
FROM employees
GROUP BY EmployeeLevel;



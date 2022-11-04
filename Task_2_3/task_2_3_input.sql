CREATE TABLE employees
(
	Id SERIAL PRIMARY KEY,
	LastName CHARACTER VARYING(20) NOT NULL,
	FirstName CHARACTER VARYING(20) NOT NULL,
	MiddleName CHARACTER VARYING(20),
	BirthDate date,
	StartDate date,
	JobTitle CHARACTER VARYING(30),
	EmployeeLevel CHARACTER VARYING(20),
	Salary INTEGER,
	DepartmentID INTEGER,
	RightsPresenceAbsence BOOLEAN
);

INSERT INTO employees(LastName,FirstName,MiddleName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,RightsPresenceAbsence)
VALUES ('Иванов','Иван','Иванович','1970-1-1','2012-9-12','Инженер','senior',150000,1,'True');

INSERT INTO employees(LastName,FirstName,MiddleName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,RightsPresenceAbsence)
VALUES ('Перов','Константин','Игоревич','1971-1-1','2010-9-22','Инженер','lead',155000,1,'True');

INSERT INTO employees(LastName,FirstName,MiddleName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,RightsPresenceAbsence)
VALUES ('Яковлев','Максим','Игоревич','1991-1-1','2020-5-22','Ассистент','jun',45000,1,'True');

INSERT INTO employees(LastName,FirstName,MiddleName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,RightsPresenceAbsence)
VALUES ('Чесноков','Игорь','Игоревич','1994-3-1','2021-6-22','Лаборант','jun',40000,2,'False');

INSERT INTO employees(LastName,FirstName,MiddleName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,RightsPresenceAbsence)
VALUES ('Числов','Игорь','Игоревич','1992-3-1','2022-6-12','Лаборант','jun',40000,3,'False');

INSERT INTO employees(LastName,FirstName,MiddleName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,RightsPresenceAbsence)
VALUES ('Кротов','Игорь','Игоревич','1992-3-1','2022-6-12','Лаборант','jun',40000,3,'True');

CREATE TABLE departments
(
	Id SERIAL PRIMARY KEY,
	DepartmenrTitle CHARACTER VARYING(60) NOT NULL,
	LeaderLastName CHARACTER VARYING(20),
	LeaderFirstName CHARACTER VARYING(20),
	LeaderMiddleName CHARACTER VARYING(20),
	NumberOfEmployees INTEGER
);

INSERT INTO departments(DepartmenrTitle,LeaderLastName,NumberOfEmployees)
VALUES ('Кафедра ИТ', 'Семенов', 20);

INSERT INTO departments(DepartmenrTitle,LeaderLastName,NumberOfEmployees)
VALUES ('Институт ПМ', 'Кадров', 15);

INSERT INTO departments(DepartmenrTitle,LeaderLastName,NumberOfEmployees)
VALUES ('Кафедра ПХ', 'Орлов', 19);

CREATE TABLE estimates
(
	LastName CHARACTER VARYING(20),
	FirstName CHARACTER VARYING(20),
	MiddleName CHARACTER VARYING(20),
	Q1estimate CHARACTER VARYING(2),
	Q2estimate CHARACTER VARYING(2),
	Q3estimate CHARACTER VARYING(2),
	Q4estimate CHARACTER VARYING(2)
);

INSERT INTO estimates(LastName,FirstName,MiddleName,Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES ('Иванов','Иван','Иванович', 'A','A','A','A');

INSERT INTO estimates(LastName,FirstName,MiddleName,Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES ('Перов','Константин','Игоревич','A','B','A','A');

INSERT INTO estimates(LastName,FirstName,MiddleName,Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES ('Числов','Игорь','Игоревич','E','B','D','A');


INSERT INTO estimates(LastName,FirstName,MiddleName,Q1estimate,Q2estimate,Q3estimate,Q4estimate)
VALUES ('Кротов','Игорь','Игоревич','D','B','D','A');


INSERT INTO departments(DepartmenrTitle,LeaderLastName,NumberOfEmployees)
VALUES ('отдел Интеллектуального анализа данных', 'Орехов', 3);

INSERT INTO employees(LastName,FirstName,MiddleName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,RightsPresenceAbsence)
VALUES ('Орехов','Иван','Алексеевич','1972-1-1','2012-9-12','Руководитель отдела','lead',300000,4,'True');

INSERT INTO employees(LastName,FirstName,MiddleName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,RightsPresenceAbsence)
VALUES ('Степанов','Семен','Семенович','1970-1-1','2012-9-12','Дата Инженер','senior',150000,4,'True');

INSERT INTO employees(LastName,FirstName,MiddleName,BirthDate,StartDate,JobTitle,EmployeeLevel,Salary,DepartmentID,RightsPresenceAbsence)
VALUES ('Орлов','Александр','Валерьевич','1970-1-1','2012-9-12','Инженер','jun',100000,4,'True');


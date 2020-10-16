DROP TABLE IF EXISTS DEPARTMENT;
DROP TABLE IF EXISTS ROLE;
DROP TABLE IF EXISTS USER_ROLE;
DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS EMPLOYMENT_TYPE;
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS PERSON;

create table PERSON
(
    ID   INT auto_increment,
    NAME VARCHAR,
    AGE  INT,
    constraint PERSON_PK
        primary key (ID)
);

create table DEPARTMENT
(
    ID   INT auto_increment,
    NAME VARCHAR,
    constraint DEPARTMENT_PK
        primary key (ID)
);

create table EMPLOYMENT_TYPE
(
    ID   INT auto_increment,
    NAME VARCHAR,
    constraint EMPLOYMENT_TYPE_PK
        primary key (ID)
);

create table EMPLOYEE
(
    PERSON_ID          INT       not null,
    START_DATE         TIMESTAMP not null,
    END_DATE           TIMESTAMP,
    EMPLOYMENT_TYPE_ID INT,
    DEPARTMENT_ID      INT       not null,
    constraint EMPLOYEE_PK
        primary key (PERSON_ID, DEPARTMENT_ID),
    constraint EMPLOYEE_PERSON_ID_FK
        foreign key (PERSON_ID) references PERSON (ID),
    constraint EMPLOYMENT_TYPE_ID_FK
        foreign key (EMPLOYMENT_TYPE_ID) references EMPLOYMENT_TYPE (ID)
);

create table USER
(
    ID            INT auto_increment,
    PERSON_ID     INT,
    USERNAME      VARCHAR,
    PASSWORD_HASH VARCHAR,
    constraint USER_PK
        primary key (ID),
    constraint USER_PERSON_ID_FK
        foreign key (PERSON_ID) references PERSON (ID)
);

create table ROLE
(
    ID    INT AUTO_INCREMENT,
    NAME  VARCHAR NOT NULL,
    LEVEL INT     NOT NULL,
    constraint ROLE_PK
        primary key (ID)
);

create table USER_ROLE
(
    USER_ID INT NOT NULL,
    ROLE_ID INT NOT NULL,
    constraint USER_ROLE_PK
        primary key (USER_ID, ROLE_ID)
);
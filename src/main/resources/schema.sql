-- DDL

CREATE TABLE USERS
(
    ID        INTEGER PRIMARY KEY,
    FIRSTNAME VARCHAR(35) NOT NULL,
    LASTNAME  VARCHAR(35) NOT NULL,
    USERNAME  VARCHAR(20) NOT NULL UNIQUE,
    PASSWORD  VARCHAR(10) NOT NULL,
    IS_ACTIVE BOOLEAN NOT NULL
);

CREATE TABLE TRAINEE
(
    ID INTEGER PRIMARY KEY,
    DATEOFBIRTH DATE,
    ADDRESS VARCHAR(100),
    USERID INT,
    FOREIGN KEY (USERID) REFERENCES USERS (ID)
);

CREATE TABLE TRAINER
(
    ID INTEGER PRIMARY KEY,
    SPECIALIZATION INT,
    USERID INT,
    FOREIGN KEY (USERID) REFERENCES USERS (ID),
    FOREIGN KEY (SPECIALIZATION) REFERENCES TRAININGTYPE (ID),
);

CREATE TABLE TRAINING
(
   ID INTEGER PRIMARY KEY,
   TRAINEEID INT,
   TRAINERID INT,
   TRAININGNAME VARCHAR(55) NOT NULL,
   TRAININGTYPEID INT,
   TRAININGDATE DATE NOT NULL,
   TRAININGDURATION DOUBLE NOT NULL,
   FOREIGN KEY (TRAINEEID) REFERENCES TRAINEE(ID),
   FOREIGN KEY (TRAINERID) REFERENCES TRAINER(ID),
   FOREIGN KEY (TRAININGTYPEID) REFERENCES TRAININGTYPE(ID)
);
CREATE TABLE TRAININGTYPE
(
  ID INTEGER PRIMARY KEY,
  TYPENAME VARCHAR(50) NOT NULL UNIQUE
);

COMMIT;
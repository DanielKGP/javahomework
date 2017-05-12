CREATE TABLE IF NOT EXISTS PIMTodo(
                    Priority TEXT NOT NULL,
                    PIMDate TEXT NOT NULL,
                    Content TEXT,
                    CONSTRAINT PIMTodo_PK PRIMARY KEY (Priority,PIMDate,Content)
                  );

CREATE TABLE IF NOT EXISTS PIMNote(
                    Priority TEXT NOT NULL,
                    Content TEXT,
                    CONSTRAINT PIMNote_PK PRIMARY KEY (Priority,Contains)
                  );

CREATE TABLE IF NOT EXISTS PIMContact(
                    Priority TEXT NOT NULL,
                    FirstName TEXT,
                    LastName TEXT,
                    EmailAddress TEXT,
                    CONSTRAINT PIMCont_PK PRIMARY KEY (Priority,FirstName,LastName,EmailAddress)
                  );

CREATE TABLE IF NOT EXISTS PIMAppointment(
                    Priority TEXT NOT NULL,
                    PIMDate TEXT NOT NULL,
                    Content TEXT,
                    CONSTRAINT PIMAppo_PK PRIMARY KEY (Priority,PIMDate,Content)
                  );

CREATE VIEW IF NOT EXISTS PIMTodoView (PIMEntity) AS
                    SELECT 'TODO   '||Priority||'   '||PIMDate||'   '||Content
                    FROM PIMTodo;


REPLACE INTO PIMTodo VALUES('normal','04/20/2017','hhhh');

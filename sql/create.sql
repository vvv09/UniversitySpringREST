CREATE TABLE subjects
(
   subject_id serial primary key,
   name character varying(70)
);

CREATE TABLE groups
(
   group_id serial primary key,
   name character varying(30)
);

CREATE TABLE students
(
   student_id serial primary key,
   first_name character varying(30),
   middle_name character varying(30),
   last_name character varying(30),
   group_id integer,

   FOREIGN KEY (group_id) REFERENCES groups (group_id) ON DELETE RESTRICT
);

CREATE TABLE teachers
(
    teacher_id serial primary key,
    first_name character varying(30),
    middle_name character varying(30),
    last_name character varying(30)
);

CREATE TABLE classrooms
(
    classroom_id serial primary key,
    name character varying(30)
);

CREATE TYPE day_of_week AS ENUM ('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY');
CREATE TYPE parity AS ENUM ('ODD', 'EVEN');
CREATE TYPE lesson AS ENUM ('FIRST', 'SECOND', 'THIRD', 'FOURTH', 'FIFTH', 'SIXTH');


CREATE TABLE schedule
(
    id serial primary key,
    subject_id integer NOT NULL,
    group_id integer NOT NULL,
    teacher_id integer NOT NULL,
    classroom_id integer NOT NULL,
    day_of_week day_of_week NOT NULL,
    parity parity NOT NULL,
    lesson lesson NOT NULL,

    FOREIGN KEY (subject_id) REFERENCES subjects (subject_id) ON DELETE RESTRICT,
    FOREIGN KEY (group_id) REFERENCES groups (group_id) ON DELETE RESTRICT,
    FOREIGN KEY (teacher_id) REFERENCES teachers (teacher_id) ON DELETE RESTRICT,
    FOREIGN KEY (classroom_id) REFERENCES classrooms (classroom_id) ON DELETE RESTRICT
);

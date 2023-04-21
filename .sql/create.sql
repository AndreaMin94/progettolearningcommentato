create table courses (
    id BIGINT auto_increment primary key,
    name varchar(100) not null,
    description varchar(1000) not null,
    teacher_firstname varchar(100) not null,
    teacher_lastname varchar(100) not null,
    date DATE
);

create table lessons (
    id BIGINT auto_increment primary key,
    description varchar(1000) not null,
    date DATETIME default NOW(),
    course_id BIGINT references courses(id)
);

create table students (
    id BIGINT auto_increment primary key,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(100) not null
);

create table course_student (
    course_id BIGINT references courses(id),
    student_id BIGINT references courses(id)
);
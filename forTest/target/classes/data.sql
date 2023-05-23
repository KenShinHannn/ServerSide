insert into subject (subject_code, title, credit) values ('INT101', 'Computer Programming I', 1);
insert into subject (subject_code, title, credit) values ('INT102', 'Computer Programming 2', 2);
insert into subject (subject_code, title, credit) values ('INT103', 'Computer Programming 3', 3);
insert into subject (subject_code, title, credit) values ('INT104', 'Computer Programming 4', 4);
insert into subject (subject_code, title, credit) values ('INT105', 'Computer Programming 5', 5);

insert into student values (08301, 'Somchai');
insert into student values (08302, 'Apichart');
insert into student values (08303, 'Preeda');
insert into student values (08304, 'Kitichai');
insert into student values (08305, 'Satiya');
insert into student values (08306, 'Meechai');
insert into student values (08307, 'Srisupa');
insert into student values (08308, 'Daranee');
insert into student values (08309, 'Nittaya');

insert into student_grade (student_id, subject_id, grade) values(08301, 1, 3.5);
insert into student_grade (student_id, subject_id, grade) values(08301, 3, 2.5);
insert into student_grade (student_id, subject_id, grade) values(08301, 4, 4);
insert into student_grade (student_id, subject_id, grade) values(08302, 1, 2.5);
insert into student_grade (student_id, subject_id, grade) values(08302, 5, 2.0);
insert into student_grade (student_id, subject_id, grade) values(08303, 1, 2.5);
insert into student_grade (student_id, subject_id, grade) values(08304, 1, 3.5);
insert into student_grade (student_id, subject_id, grade) values(08305, 1, 3.0);
insert into student_grade (student_id, subject_id, grade) values(08305, 2, 4.0);
insert into student_grade (student_id, subject_id, grade) values(08307, 1, 3.0);
insert into student_grade (student_id, subject_id, grade) values(08307, 2, 4.0);
insert into student_grade (student_id, subject_id, grade) values(08308, 1, 3.0);
insert into student_grade (student_id, subject_id, grade) values(08309, 2, 2.5);
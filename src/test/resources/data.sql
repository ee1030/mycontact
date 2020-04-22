insert into person(`id`, `name`, `age`, `blood_type`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`, `job`) values(1, 'John Wick', 35, 'O', 1991, 8, 15, 'Killer');
insert into person(`id`, `name`, `age`, `blood_type`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`) values(2, 'King', 44, 'O', 1992, 7, 10);
insert into person(`id`, `name`, `age`, `blood_type`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`) values(3, 'Winston', 55, 'A', 1993, 1, 5);
insert into person(`id`, `name`, `age`, `blood_type`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`) values(4, 'Harry', 48, 'AB', 1994, 6, 30);
insert into person(`id`, `name`, `age`, `blood_type`, `year_of_birthday`, `month_of_birthday`, `day_of_birthday`) values(5, 'Eminem', 35, 'A', 1995, 8, 30);

insert into block(`id`, `name`) values (1, 'Winston');
insert into block(`id`, `name`) values (2, 'Eminem');

update person set block_id = 1 where id = 3;
update person set block_id = 2 where id = 5;
insert into student(std_ID, FirstName, LastName, Email, Password) values (700001, "John", "Doe", "up700001@myport.ac.uk", "password");
insert into student(std_ID, FirstName, LastName, Email, Password) values (700002, "Jane", "Doe", "up700002@myport.ac.uk", "password");


insert into seat(Floor, isComp) values (1, False);
insert into seat(Floor, isComp) values (0, False);
insert into seat(Floor, isComp) values (2, False);
insert into seat(Floor, isComp) values (0, True);
insert into seat(Floor, isComp) values (1, True);
insert into seat(Floor, isComp) values (2, True);


insert into time_slot (time, date, seat_ID, Avaliable) values ('12:00:00', '2017:01:27', 1, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('12:30:00', '2017:01:27', 1, False);
insert into time_slot (time, date, seat_ID, Avaliable) values ('13:00:00', '2017:01:27', 1, False);
insert into time_slot (time, date, seat_ID, Avaliable) values ('13:30:00', '2017:01:27', 1, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('14:00:00', '2017:01:27', 1, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('14:30:00', '2017:01:27', 1, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('15:00:00', '2017:01:27', 1, False);
insert into time_slot (time, date, seat_ID, Avaliable) values ('15:30:00', '2017:01:27', 1, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('12:00:00', '2017:01:27', 2, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('12:30:00', '2017:01:27', 2, False);
insert into time_slot (time, date, seat_ID, Avaliable) values ('13:00:00', '2017:01:27', 2, False);
insert into time_slot (time, date, seat_ID, Avaliable) values ('13:30:00', '2017:01:27', 2, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('14:00:00', '2017:01:27', 2, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('14:30:00', '2017:01:27', 2, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('15:00:00', '2017:01:27', 2, False);
insert into time_slot (time, date, seat_ID, Avaliable) values ('15:30:00', '2017:01:27', 2, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('12:00:00', '2017:01:27', 6, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('12:30:00', '2017:01:27', 6, False);
insert into time_slot (time, date, seat_ID, Avaliable) values ('13:00:00', '2017:01:27', 6, False);
insert into time_slot (time, date, seat_ID, Avaliable) values ('13:30:00', '2017:01:27', 6, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('14:00:00', '2017:01:27', 6, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('14:30:00', '2017:01:27', 6, True);
insert into time_slot (time, date, seat_ID, Avaliable) values ('15:00:00', '2017:01:27', 6, False);
insert into time_slot (time, date, seat_ID, Avaliable) values ('15:30:00', '2017:01:27', 6, True);



select s.seat_ID "seat ID", t.time "Avaliable Time", t.date "Avaliable date", s.Floor 
from seat s
join time_slot t on t.seat_ID = s.seat_ID
where Avaliable = True AND isComp = True;


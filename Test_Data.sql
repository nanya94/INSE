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



insert into booking (std_ID, slot_ref) values (700001, 2);
insert into booking (std_ID, slot_ref) values (700001, 3);
insert into booking (std_ID, slot_ref) values (700001, 10);





-- find a computer seat --
select s.seat_ID "seat ID", t.time "Avaliable Time", t.date "Avaliable date", s.Floor 
from seat s
join time_slot t on t.seat_ID = s.seat_ID
where Avaliable = True AND isComp = True;


-- find avaliable seat on a given date -- 
select s.seat_ID "Seat ID", t.time "Avaliable time", s.Floor
from seat s 
join time_slot t on t.seat_ID = s.seat_ID
where t.date = '2017:02:01' AND t.Avaliable = True;


-- find number of avaliable seats at a given time -- 
select count(t.Avaliable) AS "Number of Avaliable seats"
from seat s
join time_slot t on t.seat_ID = s.seat_ID
where t.time = '14:00:00' AND t.Avaliable = True;

-- Shows information about students booking -- 
select b.booking_ref as "Reference Number", t.time AS "Booking Time", t.date AS "Booking Date", s.seat_ID
from booking b
join time_slot t on b.slot_ref = t.slot_ref
join seat s on t.seat_ID = s.seat_ID
where b.std_ID = 700001;


-- gives total number of seats
select count(seat_ID) AS "Computer seats"
from seat s
where isComp = True;

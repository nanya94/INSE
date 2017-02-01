create table student(
  std_ID int(6) AUTO_INCREMENT PRIMARY KEY,
  FirstName varchar (40) NOT NULL,
  LastName varchar (40) NOT NULL,
  Email varchar (100) NOT NULL,
  Password varchar (10) NOT NULL
);

create table seat(
    seat_ID int(5) AUTO_INCREMENT PRIMARY KEY,
    Floor int(1)    NOT NULL,
    isComp boolean  NOT NULL
);

create table time_slot(
    slot_ref int(5) AUTO_INCREMENT PRIMARY KEY,
    time TIME NOT NULL,
    date DATE NOT NULL,
    seat_ID int(5),
    Avaliable boolean NOT NULL,
    CONSTRAINT Time_Slot FOREIGN KEY (seat_ID) REFERENCES seat(seat_ID)
);

create table booking(
    booking_ref int(6) AUTO_INCREMENT PRIMARY KEY,
    std_ID int(6),
    seat_ID int(5),
    CONSTRAINT Std_Booking FOREIGN KEY (std_ID) REFERENCES student(std_ID),
    CONSTRAINT Seat_Booking FOREIGN KEY (seat_ID) REFERENCES time_slot(seat_ID)
);

    
    
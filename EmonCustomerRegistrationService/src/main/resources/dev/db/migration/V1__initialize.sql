create table customer(
	customerId integer IDENTITY primary key,
	firstName varchar(50) not null,
	lastName varchar(50) not null,
	primaryPhoneNumber varchar(10) not null,
	secondaryPhoneNumber varchar(10),
	email varchar(128),
	addressLine1 varchar(128) not null,
	city varchar(128) not null, 
	state varchar(2) not null, 
	zip varchar(5) not null,
	emgergencyContactFirstname varchar(50) not null,
	emgergencyContactLastname varchar(50) not null,
	emgergencyContactPhoneNumber varchar(10) not null,
	registrationDate datetime not null,
	lastModified timestamp not null,
	version int not null );
	

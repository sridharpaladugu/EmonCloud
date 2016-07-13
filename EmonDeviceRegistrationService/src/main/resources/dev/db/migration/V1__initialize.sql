create table device(
	deviceId integer IDENTITY primary key,
	manufacturer varchar(150) not null,
	IEMI varchar(50) not null,
	Description varchar(255) not null,
	registrationDate datetime not null,
	lastModified timestamp not null,
	version int not null );
	
create table device_customer(
	deviceId integer,
	customerId interger,
	primary key(deviceId, customerId)
);
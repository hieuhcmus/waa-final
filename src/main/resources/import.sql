insert into airport (id,airportcode,city,country,name) values (54,'AMS','Amsterdam','The Netherlands','Schiphol');
insert into airport (id,airportcode,city,country,name) values (55,'DTW','Detroid','USA','Detroid City');
insert into airport (id,airportcode,city,country,name) values (58,'NRT','Tokyo','Japan','Narita International Airport');
insert into airport (id,airportcode,city,country,name) values (52,'SYD','Sydney','Australia','Kingsford Smith');
insert into airport (id,airportcode,city,country,name) values (53,'LAX','Los Angeles','USA','Los Angeles International');
insert into airport (id,airportcode,city,country,name) values (59,'FRA','Frankfurt','Germany','Frankfurt International Airport');
insert into airport (id,airportcode,city,country,name) values (50,'ORD','Chicago','USA','Chicago O''hare International');
insert into airport (id,airportcode,city,country,name) values (53,'LHR','London','UK','London Heathrow');
insert into airport (id,airportcode,city,country,name) values (57,'JFK','New York','USA','John F. Kennedy International');
insert into airport (id,airportcode,city,country,name) values (59,'SIN','Singapore','Singapore','Changi Airport');

insert into airline (id, name) values (52,'SkyTeam');
insert into airline (id, name) values (50,'oneworld');
insert into airline (id, name) values (57,'North Star');

insert into airplane (id,capacity,model,serialnr) values (53,519,'A380','12345');
insert into airplane (id,capacity,model,serialnr) values (57,416,'747','54321');
insert into airplane (id,capacity,model,serialnr) values (51,519,'A380','23451');
insert into airplane (id,capacity,model,serialnr) values (55,416,'747','43215');
insert into airplane (id,capacity,model,serialnr) values (58,519,'A380','34512');
insert into airplane (id,capacity,model,serialnr) values (52,416,'747','32154');

insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (51,'2015-06-25','09:00:00','2009-08-06','19:10:00','NW 36',52,53,54,55);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (6,'2015-06-25','13:45:00','2009-08-06','15:05:00','NW 96',52,57,55,58);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (9,'2015-06-25','06:15:00','2009-08-05','22:30:00','QF 12',50,51,52,53);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (14,'2015-06-25','06:55:00','2009-08-06','21:55:00','QF 21',50,55,58,52);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (16,'2015-06-25','05:45:00','2009-08-06','14:30:00','UA 944',57,58,59,50);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (21,'2015-06-25','07:30:00','2009-08-06','12:59:00','UA 934',57,52,53,53);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (24,'2015-06-25','07:40:00','2015-06-25','07:15:00','NW 8445',52,53,53,54);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (25,'2015-06-25','12:21:00','2015-06-25','12:05:00','NW 1689',52,57,50,55);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (26,'2015-06-25','23:39:00','2015-06-25','15:00:00','QF 3101',50,51,57,53);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (28,'2015-06-25','17:15:00','2015-06-25','11:05:00','QF 4022',50,55,59,58);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (30,'2015-06-25','14:53:00','2015-06-25','12:45:00','UA 941',57,58,50,59);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (31,'2015-06-25','10:38:00','2015-06-25','08:10:00','UA 4842',57,52,54,53);
insert into flight (id,arrivalDate,arrivalTime,departureDate,departureTime,flightnr,airline_id,airplane_id,destination_id,origin_id) values (32,'2009-08-07','10:38:00','2009-08-07','08:10:00','UA 4842',57,52,54,53);

-- MySQL/Oracle
--UPDATE hibernate_sequence SET next_val = 1000;

--Derby
UPDATE APP."SEQUENCE" SET SEQ_COUNT=1000 WHERE SEQ_NAME='SEQ_GEN';





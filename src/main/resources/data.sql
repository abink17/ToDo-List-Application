insert into users values ('test', 'pwd123');
insert into users values ('user', 'user');

insert into tasks (task, username, update_time) values ('Grocery shopping', 'test', NOW());
insert into tasks (task, username, update_time) values ('Team meeting', 'test', NOW());
insert into tasks (task, username, update_time) values ('Pickup friend', 'test', NOW());
insert into tasks (task, username, update_time) values ('Coffee date', 'user', NOW());
insert into tasks (task, username, update_time) values ('Movie night', 'user', NOW());

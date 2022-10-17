create table fee
(
    amount DECIMAL not null DEFAULT 0.0,
    feetype VARCHAR not null DEFAULT 'TUITION',
    status  VARCHAR not null DEFAULT 'NONE',
    sid VARCHAR unique not null
);
insert into fee (amount, status, sid) values (233.00, 'FULL', '0908976');
insert into fee (amount, status, sid) values (222.35, 'PARTIAL', '0938976');
insert into fee (amount, status, sid) values (568.36, 'NONE', '0904976');
insert into fee (amount, status, sid) values (698.36, 'NONE', '0908676');

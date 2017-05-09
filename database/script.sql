CREATE DATABASE redwire CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use redwire;

create table SYSTEM_USER (
    LASTNAME    varchar(100)         not null,
    FIRSTNAME   varchar(100)         not null,
    PASSWORD    char(32)             not null,
    NICKNAME    varchar(20)          not null,
    TYPE        char(3)              not null,
    WALLET      integer,
    constraint check (TYPE="PLR" or TYPE="MNG"),
    primary key (NICKNAME)
);

create table COMPETITION (
    NAME    varchar(20)             not null,
    DATE    date                    not null,
    primary key (NAME)
);

create table COMPETITOR (
    LASTNAME    varchar(100)         not null,
    FIRSTNAME   varchar(100)         not null,
    ID          integer             not null,
    primary key (ID)
);

create table BET (
    ID          integer             not null,
    AMOUNT      integer             not null,
    TYPE        char(3)             not null,
    FIRST       integer             not null,
    SECOND      integer             not null,
    THIRD       integer             not null,
    COMPETITION varchar(20)         not null,
    PLAYER      varchar(20)         not null,
    primary key (ID),
    foreign key (FIRST) references COMPETITOR(ID),
    foreign key (SECOND) references COMPETITOR(ID),
    foreign key (THIRD) references COMPETITOR(ID),
    foreign key (COMPETITION) references COMPETITION(NAME),
    foreign key (PLAYER) references SYSTEM_USER(NICKNAME),
    constraint check (TYPE="SGL" or TYPE="POD")
);

create table PARTICIPATE (
    COMPETITOR  integer        not null,
    COMPETITION varchar(20)    not null,
    primary key (COMPETITION, COMPETITOR),
    foreign key (COMPETITION) references COMPETITION(NAME),
    foreign key (COMPETITOR) references COMPETITOR(ID)
);

create database redwire with encoding utf8;


create table SYSTEM_USER (
    LASTNAME    varchar(100)         not null,
    FIRSTNAME   varchar(100)         not null,
    PASSWORD    char(32)             not null,
    NICKNAME    varchar(20)          not null,
    TYPE        char(3)              not null,
    WALLET      integer		     not null,
    constraint check_type check (TYPE='PLR' or TYPE='MNG'),
    constraint primary_key_sysuser primary key (NICKNAME)
);

create table COMPETITION (
    NAME    varchar(20)             not null,
    DATE    date                    not null,
    constraint primary_key_competition primary key (NAME)
);

create table COMPETITOR (
    LASTNAME    varchar(100)         not null,
    FIRSTNAME   varchar(100)         not null,
    ID          integer             not null,
    constraint primary_key_competitor primary key (ID)
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
    constraint primary_key_bet primary key (ID),
    constraint foreign_key_first foreign key (FIRST) references COMPETITOR(ID),
    constraint foreign_key_second foreign key (SECOND) references COMPETITOR(ID),
    constraint foreign_key_third foreign key (THIRD) references COMPETITOR(ID),
    constraint foreign_key_competetiton foreign key (COMPETITION) references COMPETITION(NAME),
    constraint foreign_key_player foreign key (PLAYER) references SYSTEM_USER(NICKNAME),
    constraint check_type check (TYPE='SGL' or TYPE='POD')
);

create table PARTICIPATE (
    COMPETITOR  integer        not null,
    COMPETITION varchar(20)    not null,
    constraint primary_key_participate primary key (COMPETITION, COMPETITOR),
    constraint foreign_key_competition foreign key (COMPETITION) references COMPETITION(NAME),
    constraint foreign_key_competitor foreign key (COMPETITOR) references COMPETITOR(ID)
);

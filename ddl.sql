-- noinspection SqlNoDataSourceInspectionForFile

create sequence hibernate_sequence start with 1 increment by 1;
create table passphrase
(
    passphrase_id bigint    not null,
    created       timestamp not null,
    primary key (passphrase_id)
);
create table word
(
    word_id       bigint       not null,
    content       varchar(255) not null,
    position      integer,
    passphrase_id bigint       not null,
    primary key (word_id)
);
alter table word
    add constraint FKpsougjtl2ab3j1new78wig2rv foreign key (passphrase_id) references passphrase;

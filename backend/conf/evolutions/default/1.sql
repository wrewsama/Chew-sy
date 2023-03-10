# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

-- apply changes
create table restaurant (
  id                            varchar(255) not null,
  session_id                    varchar(255),
  name                          varchar(255),
  constraint pk_restaurant primary key (id)
);

create table session (
  id                            varchar(255) not null,
  name                          varchar(255),
  constraint pk_session primary key (id)
);


# --- !Downs

-- drop all
drop table if exists restaurant;

drop table if exists session;


# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table course (
  id                        bigint auto_increment not null, 
  user_info_id              bigint,
  gen_focus                 varchar(255),
  crn                       varchar(255),
  course_name               varchar(255),
  section                   varchar(255),
  course_title              varchar(255),
  credits                   varchar(255),
  instructor                varchar(255),
  department                varchar(255),
  watching                  tinyint(1) default 0,
  constraint pk_course primary key (id))
;

create table meeting (
  id                        bigint auto_increment not null,
  crn                       varchar(255),
  day                       varchar(255),
  start                     varchar(255),
  end                       varchar(255),
  room                      varchar(255),
  constraint pk_meeting primary key (id))
;

create table user_comment (
  id                        bigint auto_increment not null,
  crn                       varchar(255),
  user_name                 varchar(255),
  full_name                 varchar(255),
  comment                   varchar(255),
  post_time                 bigint,
  constraint pk_user_comment primary key (id))
;

create table user_info (
  id                        bigint auto_increment not null,
  user_name                 varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  notification_preference   varchar(255),
  email                     varchar(255),
  telephone                 varchar(255),
  carrier                   varchar(255),
  constraint pk_user_info primary key (id))
;

create table viewed_comment (
  id                        bigint auto_increment not null,
  user_name                 varchar(255),
  crn                       varchar(255),
  constraint pk_viewed_comment primary key (id))
;

alter table course add constraint fk_course_userInfo_1 foreign key (user_info_id) references user_info (id) on delete restrict on update restrict;
create index ix_course_userInfo_1 on course (user_info_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table course;

drop table meeting;

drop table user_comment;

drop table user_info;

drop table viewed_comment;

SET FOREIGN_KEY_CHECKS=1;


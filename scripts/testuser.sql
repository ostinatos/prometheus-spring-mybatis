create table TESTUSER.PERSON_PROFILE
(
  profile_id  INTEGER not null,
  pid integer not null,
  nickname varchar2(100),
  gender char(1),
  loc    varchar2(100),
  intro  varchar2(4000)
);

create table TESTUSER.PERSON_ADDRESS
	(
address_id INTEGER not null,
pid INTEGER not null,
add_desc varchar2(4000),
province varchar2(4000)
		);

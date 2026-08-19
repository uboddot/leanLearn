create table voci_kasten (
   id    varchar(255) primary key,
   level int not null check ( level >= 0
      and level <= 5 ) default 0 --should be between 0 and 5 (inclusive), where 0 is the easiest and 5 is the hardest
);

create table voci (
   id                   varchar(255) primary key,
   original             varchar(255) not null,
   original_language    varchar(255),
   translation          varchar(255) not null,
   translation_language varchar(255),
   created_at           timestamp default current_timestamp,
   voci_kasten_id       varchar(255)
      references voci_kasten ( id )
         on delete set null
);
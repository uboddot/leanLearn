create table voci (
   id                   varchar(255) primary key,
   original             varchar(255) not null,
   original_language    varchar(255),
   translation          varchar(255) not null,
   translation_language varchar(255)
);
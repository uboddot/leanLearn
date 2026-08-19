insert into voci_kasten (
   id,
   level
) values
   ( '1',
     0 ),
   ( '2',
     1 ),
   ( '3',
     2 ),
   ( '4',
     3 );

insert into voci (
   id,
   original,
   original_language,
   translation,
   translation_language,
   voci_kasten_id
) values
   ( '1',
     'danke',
     'de',
     'kiitos',
     'fi',
     '1' ),
   ( '2',
     'ich',
     'de',
     'minä',
     'fi',
     '2' );
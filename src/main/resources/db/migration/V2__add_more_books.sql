insert into author (first_name, last_name) values ('Alan', 'Beaulieu');

insert into book (isbn, publisher, title, author_id) values ('978-0-596-52083-0', 'OReilly Media',
        'Learning SQL',(select id from author where first_name = 'Alan' and last_name = 'Beaulieu') );


insert into author (first_name, last_name) values ('Lorraine', 'Figueroa');

insert into book (isbn, publisher, title, author_id) values ('978-0-999-99999-0', 'Self Published',
        'Ultimate Atari Programming Book',(select id from author where first_name = 'Lorraine' and last_name = 'Figueroa') );

insert into author (first_name, last_name) values ('Matthew', 'Justice');
insert into book (isbn, publisher, title, author_id) values ('1718500661', 'No Starch Press',
            'How Computers Really Work',(select id from author where first_name = 'Matthew' and last_name = 'Justice') );

insert into author (first_name, last_name) values ('Donald', 'Knuth');

insert into book (isbn, publisher, title, author_id) values ('9780201896831', 'Addison-Wesley',
            'The Art of Computer Programming, Vol. 1',
            (select id from author where first_name = 'Donald' and last_name = 'Knuth') );

insert into book (isbn, publisher, title, author_id) values ('9780201896832', 'Addison-Wesley',
            'The Art of Computer Programming, Vol. 2',
            (select id from author where first_name = 'Donald' and last_name = 'Knuth') );

insert into book (isbn, publisher, title, author_id) values ('9780201896833', 'Addison-Wesley',
            'The Art of Computer Programming, Vol. 3',
            (select id from author where first_name = 'Donald' and last_name = 'Knuth') );

insert into book (isbn, publisher, title, author_id) values ('9780201896834', 'Addison-Wesley',
            'The Art of Computer Programming, Vol. 4',
            (select id from author where first_name = 'Donald' and last_name = 'Knuth') );

insert into book (isbn, publisher, title, author_id) values ('9780201896835', 'Addison-Wesley',
            'The Art of Computer Programming, Vol. 5',
            (select id from author where first_name = 'Donald' and last_name = 'Knuth') );

insert into book (isbn, publisher, title, author_id) values ('9780201558029', 'Addison-Wesley',
            'Concrete Mathmatics',
            (select id from author where first_name = 'Donald' and last_name = 'Knuth') );

insert into author (first_name, last_name) values ('Allan', 'Brito');
insert into book (isbn, publisher, title, author_id) values ('Brito', 'Independently Published',
            'Blender 3.6',
            (select id from author where first_name = 'Allan' and last_name = 'Brito') );

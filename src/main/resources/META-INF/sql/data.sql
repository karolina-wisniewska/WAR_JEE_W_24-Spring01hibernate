insert into authors(firstName, lastName, pesel, email) values('Jan', 'Kowalski', '85020711705', 'jkowalski@gmail.com'), ('Adam', 'Mickiewicz', '68060117218', 'amickiewicz@gmail.com');

insert into publishers(name) values ('Helion'), ('Atena'), ('PWN'), ('WKiŁ');

insert into categories(name) values ('Podróże'), ('programowanie');

insert into books(description, pages, rating, title, category_id, publisher_id) values ('Fajna książka o programowaniu',500,6, 'Java techniki kodowania', 2,1);
insert into books_authors(book_id, author_id) values (1,2);

insert into books(description, pages, rating, title, category_id, publisher_id) values ('Druga książka',300,1, 'Aby książka była pierwsza', 2,4);
insert into books_authors(book_id, author_id) values (2,1);
insert into books_authors(book_id, author_id) values (2,2);

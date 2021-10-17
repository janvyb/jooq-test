create type e_enum as enum ('A', 'B');

create table test(
  id text primary key,
  nullable_column text,
  not_null_column text not null,
  discriminator e_enum not null
);

create unique index u_variant_a on test (not_null_column, discriminator) where discriminator = 'A';
create unique index u_variant_b on test (nullable_column, not_null_column, discriminator) where discriminator = 'B';

insert into test
values ('id-1', null, 'Test 1', 'A'),
       ('id-2', null, 'Test 2', 'A'),
       ('id-3', 'X', 'Test 3', 'B'),
       ('id-4', 'Y', 'Test 4', 'B');


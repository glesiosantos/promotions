with data(title) as (values ('Informática'), ('Escritório'), ('Infantil'))
    insert into categories (title) select title
    from data d where not exists (select 1 from categories c where c.title = d.title);
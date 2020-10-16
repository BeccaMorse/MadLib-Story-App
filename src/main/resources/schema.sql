create table users(
    user_id int unique not null generated always as identity,
    username varchar unique not null,
    password varchar not null,
    primary key (user_id)
);

create table story_templates(
    template_id int unique not null generated always as identity,
    name varchar unique not null,
    body varchar not null,
    primary key (template_id)
);

create table stories(
    story_id int unique not null generated always as identity,
    user_id int not null,
    template_id int not null,
    body varchar not null,
    primary key (story_id),
    foreign key (user_id) references users(user_id),
    foreign key (template_id) references story_templates(template_id)
);
create table products (
    product_id int not null auto_increment,
    product_name varchar(100) not null,
    product_price decimal(18, 2) not null,
    primary key (product_id)
);

create table reviews (
    review_id int not null auto_increment,
    product_id int not null,
    reviewer_name varchar(100) not null,
    review_text varchar(1000) not null,
    review_time timestamp,
    primary key (review_id),
    foreign key (product_id) references products(product_id)
);

create table comments (
    comment_id int not null auto_increment,
    review_id int not null,
    commenter_name varchar(100) not null,
    comment_text varchar(1000) not null,
    comment_time timestamp,
    primary key (comment_id),
    foreign key (review_id) references reviews(review_id)
);
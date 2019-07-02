create table tb_feedback
(
    feedback_id      int auto_increment
        primary key,
    user_id          int          not null,
    product_id       int          not null,
    feedback_context varchar(255) null
);

create table tb_feedback_image
(
    feedback_image_id int auto_increment
        primary key,
    feedback_id       int          not null,
    feedback_image    varchar(255) not null,
    constraint image
        foreign key (feedback_id) references tb_feedback (feedback_id)
            on update cascade on delete cascade
);

create index feedback_id
    on tb_feedback_image (feedback_id);

create table tb_product_type
(
    product_type_id   int(3)       not null
        primary key,
    product_type_name varchar(11)  null,
    description       varchar(255) null,
    product_type_pic  varchar(255) null
);

create table tb_product
(
    product_id          int auto_increment
        primary key,
    product_type_id     int(3)             not null,
    product_name        varchar(200)       not null,
    old_product_price   float(100, 2)      null,
    new_product_price   float(100, 2)      not null,
    product_spec        varchar(5128)      null,
    product_size        varchar(50)        null,
    product_flag        int(1)   default 0 null,
    product_broad       varchar(10)        null,
    product_stock       int(255) default 1 null,
    product_pic         varchar(255)       null,
    product_remain_time datetime           null,
    constraint product_type
        foreign key (product_type_id) references tb_product_type (product_type_id)
);

create table tb_product_pic
(
    product_pic_id int(10) auto_increment
        primary key,
    product_id     int(10)      null,
    product_pic    varchar(255) null,
    constraint pic
        foreign key (product_id) references tb_product (product_id)
            on update cascade on delete cascade
);

create table tb_user
(
    user_id                 int auto_increment
        primary key,
    user_name               varchar(11)             not null,
    user_nike               varchar(11)             not null,
    user_password           varchar(18)             not null,
    user_email              varchar(20)             null,
    user_phone              varchar(11)             null,
    user_money              float(255, 0) default 0 not null,
    user_head_icon          varchar(50)             null,
    user_default_address_id int(3)                  null
);

create table tb_address
(
    address_id   int auto_increment
        primary key,
    user_id      int          not null,
    address_name varchar(11)  not null,
    address      varchar(255) not null,
    phone_number int          not null,
    constraint address
        foreign key (user_id) references tb_user (user_id)
            on update cascade on delete cascade
);

create index user_id
    on tb_address (user_id);

create table tb_collection
(
    collection_id int auto_increment
        primary key,
    user_id       int not null,
    product_id    int not null,
    constraint collection
        foreign key (user_id) references tb_user (user_id)
            on update cascade on delete cascade
);

create index user_id
    on tb_collection (user_id);

create table tb_order
(
    order_id        int auto_increment
        primary key,
    order_date      timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    user_id         int                                 not null,
    order_send_type varchar(255)                        null,
    flag            int       default 1                 not null,
    adress_id       int       default 0                 not null,
    constraint `order`
        foreign key (user_id) references tb_user (user_id)
            on update cascade on delete cascade
);

create index user_id
    on tb_order (user_id);

create table tb_order_detail
(
    order_detail_id int(3) auto_increment
        primary key,
    order_id        int(3)  not null,
    product_id      int(3)  not null,
    product_number  int(10) not null,
    constraint detaild
        foreign key (order_id) references tb_order (order_id)
            on update cascade on delete cascade
);

create index order_id
    on tb_order_detail (order_id);

create index product
    on tb_order_detail (product_id);

create table tb_shopping_cart
(
    shopping_cart_id int auto_increment
        primary key,
    user_id          int not null,
    order_id         int null,
    constraint user
        foreign key (user_id) references tb_user (user_id)
            on update cascade on delete cascade
);



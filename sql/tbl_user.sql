CREATE TABLE tbl_user
(
    id         bigint auto_increment comment '用户ID，主键自增'
        primary key,
    account    varchar(50)                         not null comment '用户账号，唯一',
    password   varchar(255)                        not null comment '用户密码，加密存储',
    nickname   varchar(100)                        null comment '用户昵称',
    avatar     varchar(255)                        null comment '用户头像URL',
    email      varchar(100)                        null comment '用户邮箱，唯一',
    created_at timestamp default CURRENT_TIMESTAMP null comment '记录创建时间',
    updated_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '记录更新时间',
    constraint account
        unique (account),
    constraint email
        unique (email)
)
    comment '用户信息表'
    collate = utf8mb4_unicode_ci;
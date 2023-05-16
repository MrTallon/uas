create table activity
(
    id               int unsigned auto_increment comment '主键' primary key,
    key_code         varchar(128) not null comment '活动编码',
    start_time       timestamp    not null comment '开始时间',
    end_time         timestamp    not null comment '结束时间',
    processor        varchar(128) null comment '判断是否能够参加活动的处理器',
    processor_params json         not null comment '判断是否能够参加活动的处理器参数',
    status           varchar(16)  not null comment '状态',
    ext              json         not null comment '扩展字段',
    operator         varchar(64)  not null comment '操作人',
    created_at       timestamp    not null comment '创建时间',
    updated_at       timestamp    not null comment '更新时间'
) comment '活动';
create index uk_activity_key_code on activity (key_code) comment '活动编码索引';

create table task
(
    id                int unsigned auto_increment comment '主键' primary key,
    key_code          varchar(128) not null comment '任务编码',
    activity_key_code varchar(128) not null comment '活动编码',
    reward_rule       json         not null comment '奖励规则',
    match_rule        json         not null comment '匹配规则',
    process_rule      json         not null comment '处理规则',
    status            varchar(16)  not null comment '状态',
    ext               json         not null comment '扩展字段',
    operator          varchar(64)  not null comment '操作人',
    created_at        timestamp    not null comment '创建时间',
    updated_at        timestamp    not null comment '更新时间'
) comment '活动任务';
create index uk_key_code on task (key_code) comment '活动任务编码索引';

create table user_task
(
    id                int unsigned auto_increment comment '主键' primary key,
    user_id           varchar(32)  not null comment '用户id',
    task_key_code     varchar(128) not null comment '任务编码',
    activity_key_code varchar(128) not null comment '活动编码',
    status            varchar(16)  not null comment '状态',
    ext               json         not null comment '扩展字段',
    open_time         timestamp    not null comment '用户任务开始时间',
    complete_time     timestamp    not null comment '用户任务完成时间',
    created_at        timestamp    not null comment '创建时间',
    updated_at        timestamp    not null comment '更新时间'
) comment '用户任务记录';
create index uk_user_id on user_task (user_id) comment '用户id索引';

create table reward_log
(
    id                int unsigned auto_increment comment '主键' primary key,
    user_task_id      int unsigned comment '对应的用户任务id',
    user_id           varchar(32)  not null comment '用户id',
    task_key_code     varchar(128) not null comment '任务编码',
    activity_key_code varchar(128) not null comment '活动编码',
    reward_type       varchar(32)  not null comment '奖品类型',
    amount            int unsigned comment '奖品数量',
    reward            json         not null comment '奖品信息',
    status            varchar(16)  not null comment '奖励发放状态。PROGRESSING=发放中,DONE=发放成功，FAIL=发放失败',
    ext               json         not null comment '扩展字段',
    created_at        timestamp    not null comment '创建时间',
    updated_at        timestamp    not null comment '更新时间'
) comment '奖励记录';

create table user_action
(
    id           int unsigned auto_increment comment '主键' primary key,
    request_id   varchar(64) not null comment '用户行为源id，用于幂等控制',
    user_task_id int unsigned comment '对应的用户任务id',
    user_id      varchar(32) not null comment '用户id',
    action_code  varchar(32) not null comment '事件类型',
    ext          json        not null comment '扩展字段',
    created_at   timestamp   not null comment '创建时间'
) comment '用户行为';

create table user_coin
(
    id         int unsigned auto_increment comment '主键' primary key,
    user_id    varchar(32) not null comment '用户id',
    scene_code varchar(32) not null comment '使用场景',
    amount     int unsigned comment '数量',
    status     varchar(16) not null comment '奖励发放状态。PROGRESSING=发放中,DONE=发放成功，FAIL=发放失败',
    ext        json        not null comment '扩展字段',
    created_at timestamp   not null comment '创建时间',
    updated_at timestamp   not null comment '更新时间'
) comment '用户抽奖币';
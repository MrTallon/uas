package com.uas.service.impl;

import com.uas.entity.UserTask;
import com.uas.mapper.UserTaskMapper;
import com.uas.service.IUserTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户任务记录 服务实现类
 * </p>
 *
 * @author tallon
 * @since 2023-05-20
 */
@Service
public class UserTaskServiceImpl extends ServiceImpl<UserTaskMapper, UserTask> implements IUserTaskService {

}

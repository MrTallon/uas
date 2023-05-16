package com.uas.service.impl;

import com.uas.entity.Task;
import com.uas.mapper.TaskMapper;
import com.uas.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动任务 服务实现类
 * </p>
 *
 * @author tallon
 * @since 2023-05-20
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

}

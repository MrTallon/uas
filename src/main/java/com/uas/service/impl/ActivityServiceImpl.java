package com.uas.service.impl;

import com.uas.entity.Activity;
import com.uas.mapper.ActivityMapper;
import com.uas.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动规则定义 服务实现类
 * </p>
 *
 * @author tallon
 * @since 2023-05-19
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

}

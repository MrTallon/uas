package com.uas.service.impl;

import com.uas.entity.UserAction;
import com.uas.mapper.UserActionMapper;
import com.uas.service.IUserActionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户行为 服务实现类
 * </p>
 *
 * @author tallon
 * @since 2023-05-20
 */
@Service
public class UserActionServiceImpl extends ServiceImpl<UserActionMapper, UserAction> implements IUserActionService {

}

package com.uas.service.impl;

import com.uas.entity.User;
import com.uas.mapper.UserMapper;
import com.uas.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户列表（临时使用，实际开发以用户中心为准） 服务实现类
 * </p>
 *
 * @author tallon
 * @since 2023-05-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

package com.uas.service.impl;

import com.uas.entity.UserCoin;
import com.uas.mapper.UserCoinMapper;
import com.uas.service.IUserCoinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户抽奖币 服务实现类
 * </p>
 *
 * @author tallon
 * @since 2023-05-21
 */
@Service
public class UserCoinServiceImpl extends ServiceImpl<UserCoinMapper, UserCoin> implements IUserCoinService {

}

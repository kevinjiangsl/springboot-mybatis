package org.spring.springboot.service.impl;

import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.spring.springboot.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Selim on 2017/8/14.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
}

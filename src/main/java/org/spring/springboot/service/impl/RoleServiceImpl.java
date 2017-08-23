package org.spring.springboot.service.impl;

import org.spring.springboot.domain.Role;
import org.spring.springboot.service.RoleService;
import org.spring.springboot.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Selim on 2017/8/18.
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
}

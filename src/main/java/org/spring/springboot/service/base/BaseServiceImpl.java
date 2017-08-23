package org.spring.springboot.service.base;

import org.springframework.stereotype.Service;

/**
 * Created by Selim on 2017/6/23.
 */
@Service
public abstract class BaseServiceImpl<T>  extends BaseCrudServiceImpl<T> implements BaseService<T> {

}


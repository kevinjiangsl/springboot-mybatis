package org.spring.springboot.service.base;

import com.github.pagehelper.PageHelper;
import org.spring.springboot.util.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Selim on 2017/6/23.
 */
@Service
public abstract class BaseCrudServiceImpl<T>  implements BaseCrudService<T> {

    @Autowired
    protected MyMapper<T> myMapper;

    public int save(T entity) {
        return myMapper.insert(entity);
    }

    public int delete(T entity) {
        return myMapper.delete(entity);
    }

    public int deleteById(Long id){
        return myMapper.deleteByPrimaryKey(id);
    }

    public int update(T entity) {
        return myMapper.updateByPrimaryKeySelective(entity);
    }

    public T findById(Long id) {
        return myMapper.selectByPrimaryKey(id);
    }

    public List<T> listAll() {
        return myMapper.selectAll();
    }

    public T findByDomain(T t) {
        return myMapper.selectOne(t);
    }

    public List<T> listByDomain(T t) {
        return myMapper.select(t);
    }

    public List<T> listPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return myMapper.select(null);
    }

}

package org.spring.springboot.service.base;

import java.util.List;

/**
 * Created by Selim on 2017/6/23.
 */
public interface BaseCrudService<T> {

    /**
     * 新增一条数据
     * @param entity
     * @return
     */
    int save(T entity);

    /**
     * 根据实体类属性删除数据
     * @param entity
     * @return
     */
    int delete(T entity);

    /**
     * 通过id删除一条数据
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 更新一条数据，依赖id
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 根据id 查询一条数据
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 查询 所有数据
     * @return
     */
    List<T> listAll();

    /**
     * 通过条件查询一条数据
     * @param t
     * @return
     */
    T findByDomain(T t);

    /**
     * 通过条件获取多条数据
     * @param t
     * @return
     */
    List<T> listByDomain(T t);

    /**
     * 分页查询数据
     * @param page
     * @param pageSize
     * @return
     */
    List<T> listPage(int page, int pageSize);


}

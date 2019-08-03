package com.fightingheart.student_core.base.mybatis;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public abstract class BaseService<K,T> {

    @Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper(){
        return mapper;
    }
    public T selectByKey(K key){
        return mapper.selectByPrimaryKey(key);
    }
    public List<T> selectListByExample(Example example){
        return mapper.selectByExample(example);
    }
    public List<T> selectListByExample(Example example, int page, int rows) {
        PageHelper.startPage(page, rows);   //分页查询
        return mapper.selectByExample(example);
    }
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    public int count(T t) {
        return mapper.selectCount(t);
    }
    public T insert(T entity){
        mapper.insert(entity);
        return entity;
    }
    public int update(T entity){
        return mapper.updateByPrimaryKey(entity);
    }
    public int updateByExample(T entity,Example example){
        return mapper.updateByExample(entity,example);
    }
    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }
    public int updateNotNullByExample(T entity, Example example) {
        return mapper.updateByExampleSelective(entity, example);
    }
    public int delete(K key){
        return mapper.deleteByPrimaryKey(key);
    }
    public int deleteByExample(Example example){
        return mapper.deleteByExample(example);
    }
    public int deleteByEntity(T entity){
        return mapper.delete(entity);
    }
}

package com.yangzq.study.dao;

import com.yangzq.study.eneity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author yangzq_sinosoft
 * @Date 2019/11/27 23:10
 * @Version 1.0.0
 * @return
 */
@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}

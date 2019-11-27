package com.yangzq.study.service;

import com.yangzq.study.eneity.Dept;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author yangzq_sinosoft
 * @Date 2019/11/27 23:08
 * @Version 1.0.0
 * @return
 */
public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}

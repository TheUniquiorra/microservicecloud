package com.yangzq.study.service.impl;


import com.yangzq.study.dao.DeptDao;
import com.yangzq.study.eneity.Dept;
import com.yangzq.study.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description: </p>
 *
 * @author yangzq_sinosoft
 * @Date 2019/11/27 23:09
 * @Version 1.0.0
 * @return
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;


    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return dao.findAll();
    }

}

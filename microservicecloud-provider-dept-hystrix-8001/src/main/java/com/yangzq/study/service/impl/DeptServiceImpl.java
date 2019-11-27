package com.yangzq.study.service.impl;

import com.yangzq.study.eneity.Dept;
import com.yangzq.study.mapper.DeptMapper;
import com.yangzq.study.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: microservicecloud
 * @Package: com.yangzq.study.service.impl
 * @ClassName: DeptServiceImpl
 * @Author: yangzq_sinosoft
 * @Description:
 * @Date: 2019/11/12 22:58
 * @Version: 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept getDept(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> DeptList() {
        return deptMapper.findAll();
    }
}

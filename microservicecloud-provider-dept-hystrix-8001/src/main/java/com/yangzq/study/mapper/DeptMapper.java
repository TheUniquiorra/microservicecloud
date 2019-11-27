package com.yangzq.study.mapper;

import com.yangzq.study.eneity.Dept;

import java.util.List;

/**
 * @ProjectName: microservicecloud
 * @Package: com.yangzq.study.mapper
 * @ClassName: DeptMapper
 * @Author: yangzq_sinosoft
 * @Description:
 * @Date: 2019/11/12 22:58
 * @Version: 1.0
 */
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();

}

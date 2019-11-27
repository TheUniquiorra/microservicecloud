package com.yangzq.study.mapper;

import com.yangzq.study.eneity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ProjectName: microservicecloud
 * @Package: com.yangzq.study.mapper
 * @ClassName: DeptMapperTest
 * @Author: yangzq_sinosoft
 * @Description:
 * @Date: 2019/11/12 22:59
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptMapperTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void addDept() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
        List<Dept> depts = deptMapper.findAll();
        System.out.println(depts.size());
    }
}

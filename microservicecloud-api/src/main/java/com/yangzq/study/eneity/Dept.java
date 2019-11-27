package com.yangzq.study.eneity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ProjectName: microservicecloud
 * @Package: com.yangzq.study.eneity
 * @ClassName: Dept
 * @Author: yangzq_sinosoft
 * @Description:
 * @Date: 2019/11/11 22:12
 * @Version: 1.0
 */
@Data
@Getter
@Setter
public class Dept implements Serializable {
    public Object set;
    private Long  deptno;   //主键
    private String  dname;   //部门名称
    private String  db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

}

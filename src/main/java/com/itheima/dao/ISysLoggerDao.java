package com.itheima.dao;


import com.itheima.domian.SysLog;
import com.itheima.paging.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loggerDao")
public interface ISysLoggerDao {

    int saveLog(SysLog log);

    List<SysLog> findByPaging(Page page);

    int findRows();

}

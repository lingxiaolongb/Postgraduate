package com.itheima.service;

import com.itheima.domian.SysLog;
import com.itheima.paging.Page;

import java.util.List;

public interface ISysLogService {


    List<SysLog> findByPaging(Page page);

    int findRows();
}

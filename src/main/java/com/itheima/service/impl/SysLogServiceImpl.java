package com.itheima.service.impl;

import com.itheima.dao.ISysLoggerDao;
import com.itheima.domian.SysLog;
import com.itheima.paging.Page;
import com.itheima.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("logService")
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLoggerDao loggerDao;

    @Override
    public List<SysLog> findByPaging(Page page) {
        return loggerDao.findByPaging(page);
    }

    @Override
    public int findRows() {
        return loggerDao.findRows();
    }
}

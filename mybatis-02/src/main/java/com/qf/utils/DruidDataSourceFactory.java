package com.qf.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

public class DruidDataSourceFactory extends PooledDataSourceFactory {

    public DruidDataSourceFactory(){
        this.dataSource = new DruidDataSource();//替换Druid数据源
    }
}

package cn.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
   @Override
    protected  Object determineCurrentLookupKey(){
    System.out.println("determineCurrentLookupKey");
    return  JdbcContextHolder.getJdbcType();
}
}

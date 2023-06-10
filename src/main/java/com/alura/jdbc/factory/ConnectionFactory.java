package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
  public DataSource dataSource;

  public ConnectionFactory(){
    ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
    pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel?useTimeZone=true&serverTimezone=UTC");
    pooledDataSource.setUser("root");
    pooledDataSource.setPassword("Yanosequemas55#");
    pooledDataSource.setMaxPoolSize(10);

    this.dataSource = pooledDataSource;
  }
  
  public Connection recuperaConexion(){
    try{
    return this.dataSource.getConnection();
  }catch(SQLException e){
    throw new RuntimeException(e);
  }
  }
}

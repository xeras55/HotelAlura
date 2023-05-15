package com.alura.jdbc.controller;

import com.alura.jdbc.dao.HuespuedDao;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Huesped;

public class HuespedController {
  

  private HuespuedDao huespuedDao;

  public HuespedController(){
    var factory = new ConnectionFactory();
    this.huespuedDao = new HuespuedDao(factory.recuperaConexion());
  }

  public void guardar(Huesped huespued){
    huespuedDao.registrarHuesped(huespued);
  }
  
}

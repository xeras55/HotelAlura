package com.alura.jdbc.controller;

import java.sql.Date;
import java.util.List;

import com.alura.jdbc.dao.HuespuedDao;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Huesped;

public class HuespedController {
  
  private HuespuedDao huespuedDao;

  public HuespedController(){
    ConnectionFactory factory = new ConnectionFactory();
    this.huespuedDao = new HuespuedDao(factory.recuperaConexion());
  }

  public void guardar(Huesped huespued){
    huespuedDao.registrarHuesped(huespued);
  }

  public void guardar1(Huesped huespued){
    huespuedDao.registrarHuesped1(huespued);
  }

  public List<Huesped> listar(){
    return huespuedDao.listarHuesped();
  }

  public List<Huesped> listarPorId(Long id){
    return huespuedDao.buscarHuespedId(id);
  }

  public List<Huesped> listarPorNombre(String nombre){
    return huespuedDao.buscarHuespedNombreFecha(nombre);
  }

  public List<Huesped> listarPorNombreFecha(String nombre, Date cum) {
    return huespuedDao.buscarHuespedNombreFechaAhorasi(nombre, cum);
  }
}
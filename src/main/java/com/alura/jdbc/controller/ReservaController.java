package com.alura.jdbc.controller;

import java.util.List;

import com.alura.jdbc.dao.ReservaDao;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Reserva;

public class ReservaController {

  private ReservaDao reservaDao;

  public ReservaController(){
    var factory = new ConnectionFactory();
    this.reservaDao = new ReservaDao(factory.recuperaConexion());
  }

  public void guardarReserva(Reserva reserva){
    reservaDao.resgistrarReserva(reserva);
  }

  public List<Reserva> listarReserva(){
    return reservaDao.listarReserva();
  }

  public List<Reserva> listarPorId(){
    return reservaDao.buscarPorId();
  }
  public List<Reserva> listarPorId1(Long id){
    return reservaDao.buscarPorId1(id);
  }

  public void registrarReserva(Reserva reserva){
    reservaDao.resgistrarReserva1(reserva);
  }

  public List<Reserva> buscarUltimoId(){
    return reservaDao.buscarIdPasar();
  }
}

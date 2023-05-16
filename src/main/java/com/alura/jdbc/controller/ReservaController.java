package com.alura.jdbc.controller;

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

}

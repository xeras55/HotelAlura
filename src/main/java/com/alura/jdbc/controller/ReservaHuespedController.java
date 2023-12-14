package com.alura.jdbc.controller;

import com.alura.jdbc.dao.RegistroReservaHuesped;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Huesped;
import com.alura.jdbc.modelo.Reserva;

public class ReservaHuespedController {
  private RegistroReservaHuesped registroReservaHuesped;

  public ReservaHuespedController() {
    ConnectionFactory factory = new ConnectionFactory();
    this.registroReservaHuesped = new RegistroReservaHuesped(factory.recuperaConexion());
  }

  public void agendarHR(Reserva reserva, Huesped huesped) {
    registroReservaHuesped.resgistrarReserva1(reserva, huesped);
  }

  public void agendarRH(Reserva reserva, Huesped huesped) {
    registroReservaHuesped.registrarReserva3(reserva, huesped);
  }

}

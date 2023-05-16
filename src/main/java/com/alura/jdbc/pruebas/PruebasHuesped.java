package com.alura.jdbc.pruebas;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.controller.HuespedController;
import com.alura.jdbc.controller.ReservaController;
import com.alura.jdbc.modelo.Huesped;
import com.alura.jdbc.modelo.Reserva;

public class PruebasHuesped {
  private static HuespedController HuespedController;
  private static ReservaController ReservaController;

  public static void main(String[] args) throws ParseException {
    // guardar();
    // cargarDatos();
    //registrarReserva();
  }

  private static void guardar() throws ParseException {

    HuespedController = new HuespedController();

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fechaUtil = formato.parse("30/08/1998");
    java.sql.Date fechaDeNacimiento = new java.sql.Date(fechaUtil.getTime());

    Huesped huesped = new Huesped("Juan", "Pérez", fechaDeNacimiento, "Argentina", "123456789");
    Huesped huesped1 = new Huesped("Gerardo", "Sanchez", fechaDeNacimiento, "Mexicana", "123456789");
    // this.productoController.guardar(producto, categoria.getId());
    HuespedController.guardar(huesped1);
  }

  private static void cargarDatos() {
    HuespedController = new HuespedController();
    var huespedes = HuespedController.listar();
    huespedes.forEach(huesped -> System.out.println(huesped.getNombre()));
  }

  private static void registrarReserva() throws ParseException {
    ReservaController = new ReservaController();

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date fechaUtil1 = formato.parse("16/05/2023");
    java.util.Date fechaUtil2 = formato.parse("18/05/2023");
    java.sql.Date  fecha_de_entrada = new java.sql.Date(fechaUtil1.getTime());
    java.sql.Date fecha_de_salida = new java.sql.Date(fechaUtil2.getTime());

    Reserva reserva = new Reserva(fecha_de_entrada, fecha_de_salida, 500.00, "Efectivo");
    ReservaController.guardarReserva(reserva);
  }
}

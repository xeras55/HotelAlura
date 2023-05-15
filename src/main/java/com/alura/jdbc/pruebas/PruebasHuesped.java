package com.alura.jdbc.pruebas;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.alura.jdbc.controller.HuespedController;


import com.alura.jdbc.modelo.Huesped;

public class PruebasHuesped {
  private static HuespedController HuespedController;
public static void main(String[] args) throws ParseException {
  //guardar();
}



  private static  void guardar() throws ParseException{

  HuespedController = new HuespedController();
  /*
  Huesped huesped = new Huesped("Gerardo", "Sanchez", 1620832399000L, "Mexicana", "5613631885","1");
 */

SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
java.util.Date fechaUtil = formato.parse("30/08/1998");
java.sql.Date fechaDeNacimiento = new java.sql.Date(fechaUtil.getTime());


Huesped huesped = new Huesped("Juan", "Pérez", fechaDeNacimiento, "Argentina", "123456789");
Huesped huesped1 = new Huesped("Gerardo", "Sanchez", fechaDeNacimiento, "Mexicana", "123456789");
  //this.productoController.guardar(producto, categoria.getId());
  HuespedController.guardar(huesped1);
  }
}

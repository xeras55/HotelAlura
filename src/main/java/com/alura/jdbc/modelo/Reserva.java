package com.alura.jdbc.modelo;

import java.sql.Date;

public class Reserva {
  
  private Long id;

  private Date fechaDeEntrada;

  private Date fechaDeSalida;

  private Date fecha_de_entrada;
  ;

  private Date fecha_de_salida;

  private Double valor;

  private String formaDePago;

  private String forma_de_pago;

/*
public Reserva(Long id,Date fecha_de_entrada, Date fecha_de_salida, Double valor, String forma_de_pago) {
    this.id = id;
    this.fecha_de_entrada = fecha_de_entrada;
    this.fecha_de_salida = fecha_de_salida;
    this.valor = valor;
    this.forma_de_pago = forma_de_pago;
  }

  
  public Reserva(Date fecha_de_entrada, Date fecha_de_salida, Double valor, String forma_de_pago) {
  this.fecha_de_entrada = fecha_de_entrada;
  this.fecha_de_salida = fecha_de_salida;
  this.valor = valor;
  this.forma_de_pago = forma_de_pago;
}
 */


  public Reserva(Date fechaDeEntrada, Date fechaDeSalida, Double valor, String formaDePago) {
    this.fechaDeEntrada = fechaDeEntrada;
    this.fechaDeSalida = fechaDeSalida;
    this.valor = valor;
    this.formaDePago = formaDePago;
  }

  public Reserva(Long id, Date fechaDeEntrada, Date fechaDeSalida, Double valor, String formaDePago) {
    this.id = id;
    this.fechaDeEntrada = fechaDeEntrada;
    this.fechaDeSalida = fechaDeSalida;
    this.valor = valor;
    this.formaDePago = formaDePago;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getFechaDeEntrada() {
    return fechaDeEntrada;
  }

  public void setFechaDeEntrada(Date fechaDeEntrada) {
    this.fechaDeEntrada = fechaDeEntrada;
  }

  public Date getFechaDeSalida() {
    return fechaDeSalida;
  }

  public void setFechaDeSalida(Date fechaDeSalida) {
    this.fechaDeSalida = fechaDeSalida;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String getFormaDePago() {
    return formaDePago;
  }

  public void setFormaDePago(String formaDePago) {
    this.formaDePago = formaDePago;
  }
  public Date getFecha_de_entrada() {
    return fecha_de_entrada;
  }
  public void setFecha_de_entrada(Date fecha_de_entrada) {
    this.fecha_de_entrada = fecha_de_entrada;
  }
  public Date getFecha_de_salida() {
    return fecha_de_salida;
  }
  public void setFecha_de_salida(Date fecha_de_salida) {
    this.fecha_de_salida = fecha_de_salida;
  }
  public String getForma_de_pago() {
    return forma_de_pago;
  }
  public void setForma_de_pago(String forma_de_pago) {
    this.forma_de_pago = forma_de_pago;
  }

}

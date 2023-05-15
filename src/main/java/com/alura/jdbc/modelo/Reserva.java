package com.alura.jdbc.modelo;

import java.sql.Date;

public class Reserva {
  
  private Long id;

  private Date fechaDeEntrada;

  private Date fechaDeSalida;

  private Double valor;

  private String formaDePago;

  

  public Reserva(Date fechaDeEntrada, Date fechaDeSalida, Double valor, String formaDePago) {
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

}

package com.alura.jdbc.modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Huesped {

  private Long id;

  private String nombre;

  private String apellido;


  //Date fecha = new Date();
  private Date fechaDeNacimiento;
  

  private String nacionalidad;

  private String telefono;

  private Long idReserva;

  public Huesped(String nombre, String apellido, Date fechaDeNacimiento, String nacionalidad,
      String telefono) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaDeNacimiento = fechaDeNacimiento;
    this.nacionalidad = nacionalidad;
    this.telefono = telefono;
  }

  public Huesped(Long id, String nombre, String apellido, Date fechaDeNacimiento, String nacionalidad, String telefono
      ) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaDeNacimiento = fechaDeNacimiento;
    this.nacionalidad = nacionalidad;
    this.telefono = telefono;
    
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }


  public Date getFechaDeNacimiento() {
    return fechaDeNacimiento;
  }

  public void setFechaDeNacimiento(Date fechaDeNacimiento) {
    this.fechaDeNacimiento = fechaDeNacimiento;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public Long getIdReserva() {
    return this.idReserva;
  }

  public void setIdReserva(Long idReserva) {
    this.idReserva = idReserva;
  }

}

package com.alura.modelo;

import java.sql.Date;

public class Huespuedes {

  private Integer id;

  private String nombre;

  private String apellido;

  private Date fechaDeNacimiento;

  private String nacionalidad;

  private String telefono;

  private int idReserva;

  public Huespuedes() {
  } 


  public Huespuedes(String nombre, String apellido, Date fechaDeNacimiento, String nacionalidad,
      String telefono) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaDeNacimiento = fechaDeNacimiento;
    this.nacionalidad = nacionalidad;
    this.telefono = telefono;
  }


  public Integer getId() {
    return id;
  }


  
  public String getNombre() {
    return nombre;
  }



  public String getApellido() {
    return apellido;
  }


  public Date getFechaDeNacimiento() {
    return fechaDeNacimiento;
  }



  public String getNacionalidad() {
    return nacionalidad;
  }


  public String getTelefono() {
    return telefono;
  }


  public int getIdReserva() {
    return idReserva;
  }


  public void setId(Integer id) {
    this.id = id;
  }
  
}

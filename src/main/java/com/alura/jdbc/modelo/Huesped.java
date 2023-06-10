package com.alura.jdbc.modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Huesped {

  private Long id;

  private Long id_reserva;

  private String nombre;

  private String apellido;

  private Date fecha_de_nacimiento;

  private String nacionalidad;

  private String telefono;

  private Long idReserva;

  private String todas_id;

  private boolean borrar;

  
  public Huesped(Long id, String nombre, String apellido, Date fecha_de_nacimiento, String nacionalidad, String telefono
      ) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fecha_de_nacimiento = fecha_de_nacimiento;
    this.nacionalidad = nacionalidad;
    this.telefono = telefono;
    
  }

  
  
  public Huesped(String nombre, String apellido, Date fecha_de_nacimiento, String nacionalidad, String telefono, long id) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fecha_de_nacimiento = fecha_de_nacimiento;
    this.nacionalidad = nacionalidad;
    this.telefono = telefono;
    this.id = id;
  }



  public Huesped(String nombre, String apellido, Date fecha_de_nacimiento, String nacionalidad,
      String telefono,Long id_reserva) {
    this.id_reserva = id_reserva;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fecha_de_nacimiento = fecha_de_nacimiento;
    this.nacionalidad = nacionalidad;
    this.telefono = telefono;
  }
  
  public Huesped(String nombre, String apellido, Date fecha_de_nacimiento, String nacionalidad,
      String telefono) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fecha_de_nacimiento = fecha_de_nacimiento;
    this.nacionalidad = nacionalidad;
    this.telefono = telefono;
  }
  
  

  
  public Huesped(String nombre, String apellido, Date fecha_de_nacimiento, String nacionalidad, String telefono,
      Long id_reserva, boolean borrar) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fecha_de_nacimiento = fecha_de_nacimiento;
    this.nacionalidad = nacionalidad;
    this.telefono = telefono;
    this.id_reserva = id_reserva;
    this.borrar = borrar;
  }



  public Huesped(Long id, String nombre, String apellido, Date fecha_de_nacimiento, String nacionalidad,
      String telefono,Long id_reserva) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fecha_de_nacimiento = fecha_de_nacimiento;
    this.nacionalidad = nacionalidad;
    this.telefono = telefono;
    this.id_reserva = id_reserva;
    //this.borrar = borrar;
  }



  public Huesped(Long id_reserva) {
    this.id_reserva = id_reserva;
  }

  
  public Huesped(String todas_id) {
    this.todas_id = todas_id;
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


  public Date getfecha_de_nacimiento() {
    return fecha_de_nacimiento;
  }

  public void setfecha_de_nacimiento(Date fecha_de_nacimiento) {
    this.fecha_de_nacimiento = fecha_de_nacimiento;
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

  public Long getId_reserva() {
    return id_reserva;
  }

  public void setId_reserva(Long id_reserva) {
    this.id_reserva = id_reserva;
  }

  public Date getFecha_de_nacimiento() {
    return fecha_de_nacimiento;
  }

  public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
    this.fecha_de_nacimiento = fecha_de_nacimiento;
  }

  public String getTodas_id() {
    return todas_id;
  }

  public void setTodas_id(String todas_id) {
    this.todas_id = todas_id;
  }



  public boolean isBorrar() {
    return borrar;
  }



  public void setBorrar(boolean borrar) {
    this.borrar = borrar;
  }


}

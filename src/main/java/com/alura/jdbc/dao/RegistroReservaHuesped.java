package com.alura.jdbc.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Huesped;
import com.alura.jdbc.modelo.Reserva;


public class RegistroReservaHuesped {

  private Connection con;

public RegistroReservaHuesped(Connection con){
  this.con = con;
}

  
  public void resgistrarReserva1(Reserva reserva, Huesped huesped){
    Long idReservaa;
    try {
      
      PreparedStatement statement;
      statement = con.prepareStatement(
        "INSERT INTO RESERVAS"
        +"(fecha_de_entrada, fecha_de_salida, valor, forma_de_pago)"
        +"VALUES (?, ?, ? ,?)", Statement.RETURN_GENERATED_KEYS);
      
      try(statement){
        statement.setDate(1, reserva.getFecha_de_entrada());
        statement.setDate(2, reserva.getFecha_de_salida());
        statement.setDouble(3, reserva.getValor());
        statement.setString(4, reserva.getForma_de_pago());
        
        
        statement.execute();
        ResultSet resultSet = statement.getGeneratedKeys();
        try(resultSet){
          while (resultSet.next()) {
            reserva.setId(resultSet.getLong(1));
            if(statement.getGeneratedKeys().next()){
              long lastIdReserva = statement.getGeneratedKeys().getLong(1);
              try {
                PreparedStatement statementH;
                statementH = con.prepareStatement(
                  "INSERT INTO HUESPEDES"
                  + "(id_reserva, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono)"
                  + "VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
          
                  try(statementH){
                    statementH.setLong(1, lastIdReserva);
                    statementH.setString(2, huesped.getNombre());
                    statementH.setString(3, huesped.getApellido());
                    statementH.setDate(4, huesped.getfecha_de_nacimiento());
                    statementH.setString(5, huesped.getNacionalidad());
                    statementH.setString(6, huesped.getTelefono());
          
                  statementH.execute();
                  final ResultSet resultSetH = statementH.getGeneratedKeys();
          
                  try(resultSetH){
                    while (resultSetH.next()) {
                      huesped.setId(resultSetH.getLong(1));
                      
                      System.out.println(String.format("Fue registrado el huesped: %s", huesped.getNombre()));
                  }
                }
              }
              } catch (SQLException e) {
                throw new RuntimeException(e);
              }
            }
           //System.out.println(String.format("Su reserva fue agendada con exito: %s", reserva.getId()));
        }
      }
    } 
  }catch (SQLException e) {
      throw new RuntimeException(e);
  }
  }
  /*
  public void registrar2(){
    // Reemplaza estos valores con los detalles de tu base de datos
    String url = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    String user = "mi_usuario";
    String password = "mi_contraseña";

    // Conéctate a la base de datos
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      // Inserta en la tabla reservas
      String insertReservas = "INSERT INTO reservas(fecha_de_entrada, fecha_de_salida, valor, forma_de_pago, habitacion) VALUES(?, ?, ?, ?, ?)";
      try (PreparedStatement pstmt = conn.prepareStatement(insertReservas, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setString(1, "2023-05-22 14:30:00");
        pstmt.setString(2, "2023-05-25 14:30:00");
        pstmt.setDouble(3, 500.00);
        pstmt.setString(4, "Efectivo");
        pstmt.setString(5, "A1");
        pstmt.executeUpdate();

        // Obtén el ID generado
        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            long lastIdReserva = generatedKeys.getLong(1);

            // Inserta en la tabla huespedes
            String insertHuespedes = "INSERT INTO huespedes(nombre, apellido, id_reserva ,fecha_de_nacimiento, nacionalidad, telefono) VALUES(?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt2 = conn.prepareStatement(insertHuespedes)) {
              pstmt2.setString(1, "Eduardo");
              pstmt2.setString(2, "Sanchez");
              pstmt2.setLong(3, lastIdReserva);
              pstmt2.setString(4, "1998-08-30 14:30:00");
              pstmt2.setString(5, "Mexicana");
              pstmt2.setString(6, "5613631885");
              pstmt2.executeUpdate();
            }
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  */
  public void registrarReserva3(Reserva reserva, Huesped huesped){
    try {
      PreparedStatement statement;
      statement = con.prepareStatement(
        "INSERT INTO RESERVAS"
        +"(fecha_de_entrada, fecha_de_salida, valor, forma_de_pago)"
        +"VALUES (?, ?, ? ,?)", Statement.RETURN_GENERATED_KEYS);
        try(statement){
          statement.setDate(1, reserva.getFecha_de_entrada());
          statement.setDate(2, reserva.getFecha_de_salida());
          statement.setDouble(3, reserva.getValor());
          statement.setString(4, reserva.getForma_de_pago());
          statement.execute();
          

          try(ResultSet resultSet = statement.getGeneratedKeys();){
            if (resultSet.next()) {
              long lastIdReserva1 = resultSet.getLong(1);
              PreparedStatement statementH;
                statementH = con.prepareStatement(
                  "INSERT INTO HUESPEDES"
                  + "(nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, id_reserva)"
                  + "VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
              try(statementH){
                statementH.setString(1, huesped.getNombre());
                statementH.setString(2, huesped.getApellido());
                statementH.setDate(3, huesped.getfecha_de_nacimiento());
                statementH.setString(4, huesped.getNacionalidad());
                statementH.setString(5, huesped.getTelefono());
                statementH.setLong(6, lastIdReserva1);
      
              statementH.execute();
              }
            }
          }
        }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alura.jdbc.modelo.Reserva;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class ReservaDao {
  
  private Connection con;


  public ReservaDao(Connection con){
    this.con = con;
  }
  

  public void resgistrarReserva(Reserva reserva){
    Long idReservaa;
    try {
      
      PreparedStatement statement;
      statement = con.prepareStatement(
        "INSERT INTO RESERVAS"
        +"(fecha_de_entrada, fecha_de_salida, valor, forma_de_pago, habitacion)"
        +"VALUES (?, ?, ? ,?, ?)", Statement.RETURN_GENERATED_KEYS);
      
      try(statement){
        statement.setDate(1, reserva.getFecha_de_entrada());
        statement.setDate(2, reserva.getFecha_de_salida());
        statement.setDouble(3, reserva.getValor());
        statement.setString(4, reserva.getForma_de_pago());
        statement.setString(5, reserva.getHabitacion());
        
        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();

        try(resultSet){
          while (resultSet.next()) {
            reserva.setId(resultSet.getLong(1));
            idReservaa =reserva.getId();
           //System.out.println(String.format("Su reserva fue agendada con exito: %s", reserva.getId()));
        }
      }
    } 
  }catch (SQLException e) {
      throw new RuntimeException(e);
  }
}




public List<Reserva> listarReserva(){
  List<Reserva> resultado = new ArrayList<>(); 
  try {
    final PreparedStatement statement = con
    .prepareStatement("SELECT * FROM RESERVAS");

    try(statement){
      statement.execute();
      final ResultSet resultSet = statement.getResultSet();
      try(resultSet){
        while (resultSet.next()) {
          resultado.add(new Reserva(resultSet.getLong("id"),
          resultSet.getDate("fecha_de_entrada"),
          resultSet.getDate("fecha_de_salida"),
          resultSet.getDouble("valor"),
          resultSet.getString("forma_de_pago")));
        }
      }
    }
  } catch (SQLException e) {
    throw new RuntimeException(e);
  }
  return resultado;
}

public List<Reserva> buscarPorId(){
  List<Reserva> resultado = new ArrayList<>(); 
  try {
    final PreparedStatement statement = con
    .prepareStatement("SELECT * FROM RESERVAS"
                      + "WHERE id = ?");

    try(statement){
      statement.execute();
      final ResultSet resultSet = statement.getResultSet();
      try(resultSet){
        while (resultSet.next()) {
          resultado.add(new Reserva(resultSet.getLong("id"),
                                    resultSet.getDate("fecha_de_entrada"),
                                    resultSet.getDate("fecha_de_salida"),
                                    resultSet.getDouble("valor"),
                                    resultSet.getString("forma_de_pago")));
        }
      }
    }
  } catch (SQLException e) {
    throw new RuntimeException(e);
  }
  return resultado;
}


public List<Reserva> buscarPorId1(long id) {
  List<Reserva> resultado = new ArrayList<>();
  try {
      final PreparedStatement statement = con
              .prepareStatement("SELECT * FROM RESERVAS WHERE id = ?");

      statement.setLong(1, id);

      try (statement) {
          statement.execute();
          final ResultSet resultSet = statement.getResultSet();
          try (resultSet) {
              while (resultSet.next()) {
                  resultado.add(
                          new Reserva(
                          resultSet.getLong("id"),
                          resultSet.getDate("fecha_de_entrada"),
                          resultSet.getDate("fecha_de_salida"),
                          resultSet.getDouble("valor"),
                          resultSet.getString("forma_de_pago")));
              }
          }
      }
  } catch (SQLException e) {
      throw new RuntimeException(e);
  }
  return resultado;
}


}

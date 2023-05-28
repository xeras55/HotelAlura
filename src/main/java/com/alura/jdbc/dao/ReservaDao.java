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
    try {
      PreparedStatement statement;
      statement = con.prepareStatement(
        "INSERT INTO RESERVAS"
        +"(fechaDeEntrada, fechaDeSalida, valor, formaDePago)"
        +"VALUES (?, ?, ? ,?)", Statement.RETURN_GENERATED_KEYS);
      
      try(statement){
        statement.setDate(1, reserva.getFechaDeEntrada());
        statement.setDate(2, reserva.getFechaDeSalida());
        statement.setDouble(3, reserva.getValor());
        statement.setString(4, reserva.getFormaDePago());
        
        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();

        try(resultSet){
          while (resultSet.next()) {
            reserva.setId(resultSet.getLong(1));
            
            System.out.println(String.format("Su reserva fue agendada con exito: %s", reserva.getId()));
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
          resultSet.getDate("fechaDeEntrada"),
          resultSet.getDate("fechaDeSalida"),
          resultSet.getDouble("valor"),
          resultSet.getString("formaDePAgo")));
        }
      }
    }
  } catch (SQLException e) {
    throw new RuntimeException(e);
  }
  return resultado;
}

}


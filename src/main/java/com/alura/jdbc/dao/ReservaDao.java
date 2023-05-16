package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alura.jdbc.modelo.Reserva;
import java.sql.Statement;
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
        +"(fecha_de_entrada, fecha_de_salida, valor, forma_de_pago)"
        +"VALUES (?, ?, ? ,?)", Statement.RETURN_GENERATED_KEYS);
      
      try(statement){
        statement.setDate(1, reserva.getFecha_de_entrada());
        statement.setDate(2, reserva.getFecha_de_salida());
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
}


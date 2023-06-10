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
  

  public Long resgistrarReserva(Reserva reserva){
    Long idReservaa = null;
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
            idReservaa = reserva.getId();
           //System.out.println(String.format("Su reserva fue agendada con exito: %s", reserva.getId()));
        }
      }
    } 
  }catch (SQLException e) {
      throw new RuntimeException(e);
  }
    return idReservaa;
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


public List<Reserva> buscarIdPasar() {
  List<Reserva> resultado = new ArrayList<>();
  try {
      final PreparedStatement statement = con
              .prepareStatement("SELECT id FROM RESERVAS ");

      try (statement) {
          statement.execute();
          final ResultSet resultSet = statement.getResultSet();
          try (resultSet) {
              while (resultSet.next()) {
                  resultado.add(
                          new Reserva(
                          resultSet.getLong("id")));
              }
          }
      }
  } catch (SQLException e) {
      throw new RuntimeException(e);
  }
  return resultado;
}

public void resgistrarReserva1(Reserva reserva){
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

public void editarReservas(Date fecha_de_entrada, Date fecha_de_salida, Double valor, String forma_de_pago, Long id){
  try {
    final PreparedStatement statement = con.prepareStatement(
      "UPDATE RESERVAS SET "
      +"fecha_de_entrada = ?, "
      +"fecha_de_salida = ?, "
      +"valor = ?, "
      +"forma_de_pago = ? "
      +"WHERE id = ?"
    );
    try(statement){
      statement.setDate(1, fecha_de_entrada);
      statement.setDate(2, fecha_de_salida);
      statement.setDouble(3, valor);
      statement.setString(4, forma_de_pago);
      statement.setLong(5, id);
      statement.execute();
    }
  }catch (SQLException e) {
    throw new RuntimeException(e);
  }
}



public void borrarReservas(Long id){
  try {
    final PreparedStatement statement = con.prepareStatement(
      "UPDATE RESERVAS SET borrar = false"
      +" WHERE ID = ?"
    );
    try(statement){
      statement.setLong(1, id);
      statement.execute();
    }
  } catch (SQLException e) {
    throw new RuntimeException(e);
  }
}

}


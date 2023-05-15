package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.jdbc.modelo.Huesped;

public class HuespuedDao {
  private Connection con;


  public HuespuedDao(Connection con){
    this.con = con;
  }


  public void registrarHuesped(Huesped huesped){
    try {
      PreparedStatement statement;
      statement = con.prepareStatement(
        "INSERT INTO HUESPEDES"
        + "(nombre, apellido, fechaDeNacimiento, nacionalidad, telefono)"
        + "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

      try(statement){
        statement.setString(1, huesped.getNombre());
        statement.setString(2, huesped.getApellido());
        statement.setDate(3, huesped.getFechaDeNacimiento());
        statement.setString(4, huesped.getNacionalidad());
        statement.setString(5, huesped.getTelefono());

        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();

        try(resultSet){
          while (resultSet.next()) {
            huesped.setId(resultSet.getLong(1));
            
            System.out.println(String.format("Fue registrado el huesped: %s", huesped.getNombre()));
        }
      }
    }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

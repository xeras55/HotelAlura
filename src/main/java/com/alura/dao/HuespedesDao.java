package com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.alura.modelo.Huespuedes;

public class HuespedesDao {
  
  private Connection con;


  public HuespedesDao(Connection con){
    this.con = con;
  }


  public void registrarHuesped(Huespuedes huespedes){
    try {
      PreparedStatement statement;
      statement = con.prepareStatement(
        "INSERT INTO HUESPEDES"
        + "(nombre, apellido, fechaDeNacimiento, nacionalidad, telefono)"
        + "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

      try(statement){
        statement.setString(1, huespedes.getNombre());
        statement.setString(2, huespedes.getApellido());
        statement.setDate(3, huespedes.getFechaDeNacimiento());
        statement.setString(4, huespedes.getNacionalidad());
        statement.setString(5, huespedes.getTelefono());

        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();

        try(resultSet){
          while (resultSet.next()) {
            huespedes.setId(resultSet.getInt(1));
            
            System.out.println(String.format("Fue insertado el producto: %s", huespedes));
        }
      }
    }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

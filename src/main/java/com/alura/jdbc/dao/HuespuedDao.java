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

public class HuespuedDao {
  private Connection con;

  public HuespuedDao(Connection con) {
    this.con = con;
  }

  public void registrarHuesped(Huesped huesped) {
    try {
      PreparedStatement statement;
      statement = con.prepareStatement(
          "INSERT INTO HUESPEDES"
              + "(nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono)"
              + "VALUES (?, ?, ?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS);

      try (statement) {
        statement.setString(1, huesped.getNombre());
        statement.setString(2, huesped.getApellido());
        statement.setDate(3, huesped.getfecha_de_nacimiento());
        statement.setString(4, huesped.getNacionalidad());
        statement.setString(5, huesped.getTelefono());

        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();

        try (resultSet) {
          while (resultSet.next()) {
            huesped.setId(resultSet.getLong(1));
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void registrarHuesped1(Huesped huesped) {
    try {
      PreparedStatement statement;
      statement = con.prepareStatement(
          "INSERT INTO HUESPEDES"
              + "(id_reserva, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono)"
              + "VALUES (?, ?, ?, ?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS);

      try (statement) {
        statement.setLong(1, huesped.getId_reserva());
        statement.setString(2, huesped.getNombre());
        statement.setString(3, huesped.getApellido());
        statement.setDate(4, huesped.getfecha_de_nacimiento());
        statement.setString(5, huesped.getNacionalidad());
        statement.setString(6, huesped.getTelefono());

        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();

        try (resultSet) {
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

  public List<Huesped> listarHuesped() {
    List<Huesped> resultado = new ArrayList<>();
    try {
      final PreparedStatement statement = con
          .prepareStatement("SELECT * FROM HUESPEDES");

      try (statement) {
        statement.execute();
        final ResultSet resultSet = statement.getResultSet();

        try (resultSet) {
          while (resultSet.next()) {
            resultado.add(new Huesped(resultSet.getLong("id"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido"),
                resultSet.getDate("fecha_de_nacimiento"),
                resultSet.getString("nacionalidad"),
                resultSet.getString("telefono")));
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return resultado;
  }

  public List<Huesped> buscarHuespedId(Long id) {
    List<Huesped> resultado = new ArrayList<>();
    try {
      final PreparedStatement statement = con
          .prepareStatement("SELECT * FROM HUESPEDES WHERE id = ?  AND borrar = TRUE");

      statement.setLong(1, id);

      try (statement) {
        statement.execute();
        final ResultSet resultSet = statement.getResultSet();
        try (resultSet) {
          while (resultSet.next()) {
            resultado.add(new Huesped(resultSet.getLong("id"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido"),
                resultSet.getDate("fecha_de_nacimiento"),
                resultSet.getString("nacionalidad"),
                resultSet.getString("telefono"),
                resultSet.getLong("id_reserva")));
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return resultado;
  }

  public List<Huesped> buscarHuespedNombreFecha(String nombre) {
    List<Huesped> resultado = new ArrayList<>();
    try {
      final PreparedStatement statement = con
          .prepareStatement("SELECT * FROM HUESPEDES WHERE nombre = ? AND borrar = TRUE");
      statement.setString(1, nombre);

      try (statement) {
        statement.execute();
        final ResultSet resultSet = statement.getResultSet();
        try (resultSet) {
          while (resultSet.next()) {
            resultado.add(new Huesped(resultSet.getLong("id"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido"),
                resultSet.getDate("fecha_de_nacimiento"),
                resultSet.getString("nacionalidad"),
                resultSet.getString("telefono")));
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return resultado;
  }

  public List<Huesped> buscarHuespedNombreFechaAhorasi(String nombre, Date cum) {
    List<Huesped> resultado = new ArrayList<>();
    try {
      final PreparedStatement statement = con
          .prepareStatement("SELECT * FROM HUESPEDES WHERE nombre = ? AND fecha_de_nacimiento = ? AND borrar = TRUE");

      statement.setString(1, nombre);
      statement.setDate(2, cum, null);

      try (statement) {
        statement.execute();
        final ResultSet resultSet = statement.getResultSet();
        try (resultSet) {
          while (resultSet.next()) {
            resultado.add(new Huesped(resultSet.getLong("id"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido"),
                resultSet.getDate("fecha_de_nacimiento"),
                resultSet.getString("nacionalidad"),
                resultSet.getString("telefono"),
                resultSet.getLong("id_reserva")));
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return resultado;
  }

  public void editarDatosHuesped(String nombre, String apellido, Date fecha_de_nacimiento, String nacionalidad,
      String telefono, long id) {
    try {
      final PreparedStatement statement = con.prepareStatement(
          "UPDATE HUESPEDES SET "
              + "nombre = ?, "
              + "apellido = ?, "
              + "fecha_de_nacimiento = ?, "
              + "nacionalidad = ?, "
              + "telefono = ? "
              + "WHERE id = ?");
      try (statement) {
        statement.setString(1, nombre);
        statement.setString(2, apellido);
        statement.setDate(3, fecha_de_nacimiento);
        statement.setString(4, nacionalidad);
        statement.setString(5, telefono);
        statement.setLong(6, id);

        statement.execute();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void registrarHuespedF(Huesped huesped) {
    try {
      PreparedStatement statement;
      statement = con.prepareStatement(
          "INSERT INTO HUESPEDES"
              + "(id_reserva, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, borrar)"
              + "VALUES (?, ?, ?, ?, ?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS);

      try (statement) {
        statement.setLong(1, huesped.getId_reserva());
        statement.setString(2, huesped.getNombre());
        statement.setString(3, huesped.getApellido());
        statement.setDate(4, huesped.getfecha_de_nacimiento());
        statement.setString(5, huesped.getNacionalidad());
        statement.setString(6, huesped.getTelefono());
        statement.setBoolean(7, true);

        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();

        try (resultSet) {
          while (resultSet.next()) {
            huesped.setId(resultSet.getLong(1));

          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void borrarHuesped(Long id) {
    try {
      final PreparedStatement statement = con.prepareStatement(
          "UPDATE HUESPEDES SET borrar = false"
              + " WHERE ID = ?");
      try (statement) {
        statement.setLong(1, id);
        statement.execute();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dominio.Seguro;

public class SeguroDao {
	private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "segurosgroup?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";

    public SeguroDao(){
        }

    public int agregarSeguro(Seguro seguro) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String query = "INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) VALUES ('"
                   + seguro.getDescripcion() + "', "
                   + seguro.getIdTipo() + ", "
                   + seguro.getCostoContratacion() + ", "
                   + seguro.getCostoAsegurado() + ")";

        Connection cn = null;
        int filas = 0;

        try
        {
            cn = DriverManager.getConnection(host+dbName, user,pass);
            Statement st = cn.createStatement();
            filas = st.executeUpdate(query);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
        	try {
        		if(cn != null)
        			cn.close();
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
        }
        return filas;
    }

    public int obtenerProximoId() {

    	try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (ClassNotFoundException e){
             e.printStackTrace();
         }

    	  String query = "SELECT MAX(idSeguro) FROM seguros";
          Connection cn = null;
          int proximoId = 1;

          try {
              cn = DriverManager.getConnection( host + dbName, user, pass);
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(query);

              if(rs.next()) {
            	  proximoId = rs.getInt(1) + 1;
              }
          }
          catch(Exception e) {
              e.printStackTrace();
          }
          finally {
        	  try {
        		  if(cn != null)
        			  cn.close();
        	  } catch (SQLException e) {
        		  e.printStackTrace();
        	  }
          }

          return proximoId;
      }


    }

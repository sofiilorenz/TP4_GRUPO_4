package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.TipoSeguro;

public class TipoSeguroDao {

    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "segurosgroup?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";


    public TipoSeguroDao() {

    }

    public ArrayList<TipoSeguro> listarTipos() {

		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		 } catch (ClassNotFoundException e){
			 e.printStackTrace();
		 }


	    ArrayList<TipoSeguro> lTipoSeguros = new ArrayList<TipoSeguro>();
		 Connection cn = null;
		 try
		 {
			 cn= DriverManager.getConnection(host+dbName,user,pass);
			 String query = "SELECT idTipo, descripcion FROM tiposeguros";
			 Statement st = cn.createStatement();
			 ResultSet rs = st.executeQuery(query);
			 while(rs.next())
			 {
				 TipoSeguro t = new TipoSeguro();
				 t.setIdTipo(rs.getInt("idTipo"));
				 t.setDescripcion(rs.getString("descripcion"));
				 lTipoSeguros.add(t);
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println("ERROR EN listarTipos:");
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

		 return lTipoSeguros;
	}


}

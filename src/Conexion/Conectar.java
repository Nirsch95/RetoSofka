package Conexion;

import java.sql.*;

public class Conectar{

    static String bd = "reto";
    static String login = "root";
    static String password = "N1a9n9i5*";
    static String url = "jdbc:mysql://localhost/"+bd;
    Connection connection = null;

    public Conectar(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,login,password);
        if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" OK\n");
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void desconectar(){
        try{
            System.out.println("Cerrando conexion");
            connection.close();
        }catch(Exception ex){}
    }


}

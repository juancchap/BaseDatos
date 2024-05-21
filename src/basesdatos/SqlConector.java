package basesdatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConector {
    private Connection sqlConnection;

    public SqlConector() {
        String host = "localhost";
        String puerto = "3306";
        String nameDb = "jajaxdbasedatos";

        // Acceder a la url
        String usuario = "root";
        String pass = "";
        String driver = "com.mysql.cj.jdbc.Driver";

        // Construir URL
        String databaseUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + nameDb + "?useSSL=false";

        try {
            Class.forName(driver);
            sqlConnection = DriverManager.getConnection(databaseUrl, usuario, pass);
            System.out.println("Base de datos conectada y Lista para ejecutarse");
        } catch (ClassNotFoundException e) {
            System.err.println("No se pudo encontrar la clase del controlador: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos por favor checa tu conexion o verifica que el servidor enste en linea: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return sqlConnection;
        
    }

    public static void main(String[] args) {
        // Crear una instancia de SqlConector
        SqlConector conector = new SqlConector();

        // Obtener la conexión
        Connection connection = conector.getConnection();

        // Aqu
    }
}

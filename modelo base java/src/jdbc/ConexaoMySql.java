package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConexaoMySql {
    private static Connection conexao;
    private static String host = "localhost";
    private static String database = "db2info_rebeca";
    private static String login = "root";
    private static String senha = "123";

    public static Connection getConexao() {
        try {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName(host);
            ds.setDatabaseName(database);
            ds.setUser(login);
            ds.setPassword(senha);
            ds.setConnectTimeout(2000);

            conexao = ds.getConnection();

            System.out.println("Boa");

            return conexao;
        }catch (SQLException e) {
            System.out.println("Ruim" + e.getMessage());
            return null;
        }
    }
}

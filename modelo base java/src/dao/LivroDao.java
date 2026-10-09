package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySql;
import model.Livro;

public class LivroDao {
    
    public static boolean cadastrar (Livro livro) {
        String sql;
        sql = "(INSERT INTO Livro (titulo, nPaginas, valor, dataLanc)";
        sql += "VALUES (?,?,?,?)";

    try (Connection con = ConexaoMySql.getConexao()) {
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, livro.getTitulo());
        ps.setInt(2, livro.getnPaginas());
        ps.setDouble(2, livro.getValor());
        ps.setObject(4, livro.getDatalanc());

        return (ps.executeUpdate()>0);
     
    } catch(SQLException erro){
        System.out.println("ERRO AO INSERIR:"+erro.getMessage());
        return false;
         }
    }
}

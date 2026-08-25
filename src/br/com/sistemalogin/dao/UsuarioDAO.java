package br.com.sistemalogin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.sistemalogin.connection.Conexao;
import br.com.sistemalogin.model.Usuario;
import br.com.sistemalogin.util.SenhaUtil;

public class UsuarioDAO {

    public boolean cadastrar(Usuario usuario) {

        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    public Usuario fazerLogin(String email, String senha) {

        String senhaHash = SenhaUtil.gerarHash(senha);

        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senhaHash);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setSenha(resultado.getString("senha"));

                return usuario;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}
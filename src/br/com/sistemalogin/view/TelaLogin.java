package br.com.sistemalogin.view;

import javax.swing.*;
import java.awt.*;

import br.com.sistemalogin.dao.UsuarioDAO;
import br.com.sistemalogin.model.Usuario;

public class TelaLogin extends JFrame {

    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;
    private JButton botaoCadastrar;

    public TelaLogin() {

        setTitle("Sistema de Login");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel();

        painel.setBorder(
            BorderFactory.createEmptyBorder(20, 40, 20, 40)
        );

        painel.setLayout(new GridLayout(7, 1, 10, 8));

        JLabel titulo = new JLabel(
            "LOGIN",
            SwingConstants.CENTER
        );

        titulo.setFont(
            new Font("Arial", Font.BOLD, 24)
        );

        JLabel labelEmail = new JLabel("E-mail:");

        JLabel labelSenha = new JLabel("Senha:");

        campoEmail = new JTextField();

        campoSenha = new JPasswordField();

        botaoEntrar = new JButton("Entrar");

        botaoCadastrar = new JButton("Criar conta");

        painel.add(titulo);
        painel.add(labelEmail);
        painel.add(campoEmail);
        painel.add(labelSenha);
        painel.add(campoSenha);
        painel.add(botaoEntrar);
        painel.add(botaoCadastrar);

        add(painel);

        botaoEntrar.addActionListener(
            e -> fazerLogin()
        );

        botaoCadastrar.addActionListener(
            e -> abrirCadastro()
        );
    }

    private void fazerLogin() {

        String email = campoEmail.getText();

        String senha = new String(
            campoSenha.getPassword()
        );

        if (email.isEmpty() || senha.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Preencha o e-mail e a senha."
            );

            return;
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario usuario =
            usuarioDAO.fazerLogin(email, senha);

        if (usuario != null) {

            TelaPrincipal telaPrincipal =
                new TelaPrincipal(usuario.getNome());

            telaPrincipal.setVisible(true);

            dispose();

        } else {

            JOptionPane.showMessageDialog(
                this,
                "E-mail ou senha incorretos."
            );
        }
    }

    private void abrirCadastro() {

        TelaCadastro telaCadastro =
            new TelaCadastro();

        telaCadastro.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TelaLogin tela = new TelaLogin();

            tela.setVisible(true);
        });
    }
}
package br.com.sistemalogin.view;

import javax.swing.*;
import java.awt.*;

import br.com.sistemalogin.dao.UsuarioDAO;
import br.com.sistemalogin.model.Usuario;
import br.com.sistemalogin.util.SenhaUtil;

public class TelaCadastro extends JFrame {

    private JTextField campoNome;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JPasswordField campoConfirmarSenha;
    private JButton botaoCadastrar;

    public TelaCadastro() {

        setTitle("Criar Conta");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel();

        painel.setBorder(
            BorderFactory.createEmptyBorder(20, 40, 20, 40)
        );

        painel.setLayout(new GridLayout(9, 1, 10, 6));

        JLabel titulo = new JLabel(
            "CRIAR CONTA",
            SwingConstants.CENTER
        );

        titulo.setFont(
            new Font("Arial", Font.BOLD, 24)
        );

        JLabel labelNome = new JLabel("Nome:");

        JLabel labelEmail = new JLabel("E-mail:");

        JLabel labelSenha = new JLabel("Senha:");

        JLabel labelConfirmarSenha =
            new JLabel("Confirmar senha:");

        campoNome = new JTextField();

        campoEmail = new JTextField();

        campoSenha = new JPasswordField();

        campoConfirmarSenha =
            new JPasswordField();

        botaoCadastrar =
            new JButton("Cadastrar");

        painel.add(titulo);
        painel.add(labelNome);
        painel.add(campoNome);
        painel.add(labelEmail);
        painel.add(campoEmail);
        painel.add(labelSenha);
        painel.add(campoSenha);
        painel.add(labelConfirmarSenha);
        painel.add(campoConfirmarSenha);

        add(painel);

        JPanel painelPrincipal =
            new JPanel(new BorderLayout());

        painelPrincipal.setBorder(
            BorderFactory.createEmptyBorder(20, 40, 20, 40)
        );

        painelPrincipal.add(
            painel,
            BorderLayout.CENTER
        );

        painelPrincipal.add(
            botaoCadastrar,
            BorderLayout.SOUTH
        );

        setContentPane(painelPrincipal);

        botaoCadastrar.addActionListener(
            e -> cadastrarUsuario()
        );
    }

    private void cadastrarUsuario() {

        String nome = campoNome.getText();

        String email = campoEmail.getText();

        String senha = new String(
            campoSenha.getPassword()
        );

        String confirmarSenha = new String(
            campoConfirmarSenha.getPassword()
        );

        if (nome.isEmpty()
                || email.isEmpty()
                || senha.isEmpty()
                || confirmarSenha.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Preencha todos os campos."
            );

            return;
        }

        if (!senha.equals(confirmarSenha)) {

            JOptionPane.showMessageDialog(
                this,
                "As senhas não são iguais."
            );

            return;
        }

        String senhaHash =
            SenhaUtil.gerarHash(senha);

        Usuario usuario =
            new Usuario(
                nome,
                email,
                senhaHash
            );

        UsuarioDAO usuarioDAO =
            new UsuarioDAO();

        boolean sucesso =
            usuarioDAO.cadastrar(usuario);

        if (sucesso) {

            JOptionPane.showMessageDialog(
                this,
                "Usuário cadastrado com sucesso!"
            );

        } else {

            JOptionPane.showMessageDialog(
                this,
                "Erro ao cadastrar usuário."
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TelaCadastro tela =
                new TelaCadastro();

            tela.setVisible(true);
        });
    }
}
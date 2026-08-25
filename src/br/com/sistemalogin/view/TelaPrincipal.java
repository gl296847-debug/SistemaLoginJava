package br.com.sistemalogin.view;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

	public TelaPrincipal(String nomeUsuario) {

		setTitle("Sistema de Login");
		setSize(500, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel painel = new JPanel();
		painel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

		painel.setLayout(new BorderLayout());

		JLabel titulo = new JLabel("Bem-vindo, " + nomeUsuario + "!", SwingConstants.CENTER);

		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton botaoSair = new JButton("Sair");
		
		botaoSair.addActionListener(e -> {

		    dispose();

		    TelaLogin telaLogin = new TelaLogin();
		    telaLogin.setVisible(true);

		});
		
		painel.add(titulo, BorderLayout.CENTER);
		
		painel.add(botaoSair, BorderLayout.SOUTH);

		add(painel);
	}
}
package view;

import javax.swing.*;

import dao.UsuarioDAO;

public class TelaLogin extends JFrame {
    // Declaração das variáveis
    private JLabel labelTitulo;
    private JLabel labelSubTitulo;
    private JLabel labelUsuario;
    private JLabel labelSenha;
    private JLabel labelErro;

    private JTextField campoUsuario;
    private JPasswordField campoSenha;

    private JButton bEntrar;

    // Construtor da tela
    public TelaLogin() {
        initComponents();

        setSize(1000, 700);
        setLocationRelativeTo(null);  // centraliza a janela na tela
        setResizable(false);  // impede que o usuário redimensione a janela
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // define que o programa será encerrado ao fechar a janela

        getContentPane().setBackground(java.awt.Color.WHITE);  // define a cor de fundo da janela como branca
    }

    // Método responsável pela montagem da interface gráfica da tela
    private void initComponents() {
        // Posicionamento absoluto
        setLayout(null);

        // TÍTULO
        labelTitulo = new JLabel("SISTEMA DE OFICINA MECÂNICA");
        labelTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(150, 50, 700, 50);
        add(labelTitulo);

        // SUBTÍTULO
        labelSubTitulo = new JLabel("Faça seu login para continuar");
        labelSubTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 24));
        labelSubTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelSubTitulo.setBounds(200, 120, 600, 35);
        add(labelSubTitulo);

        // LABEL USUÁRIO
        labelUsuario = new JLabel("Usuário:");
        labelUsuario.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
        labelUsuario.setBounds(160, 240, 120, 25);
        add(labelUsuario);

        // CAMPO USUÁRIO
        campoUsuario = new JTextField();
        campoUsuario.setBounds(160, 275, 680, 40);
        add(campoUsuario);

        // LABEL SENHA
        labelSenha = new JLabel("Senha:");
        labelSenha.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
        labelSenha.setBounds(160, 350, 120, 25);
        add(labelSenha);

        // CAMPO SENHA
        campoSenha = new JPasswordField();
        campoSenha.setBounds(160, 385, 680, 40);
        add(campoSenha);

        // LABEL ERRO
        labelErro = new JLabel();
        labelErro.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        labelErro.setHorizontalAlignment(SwingConstants.CENTER);
        labelErro.setForeground(java.awt.Color.RED);
        labelErro.setBounds(250, 450, 500, 30);
        add(labelErro);

        // BOTÃO ENTRAR
        bEntrar = new JButton("Entrar");
        bEntrar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bEntrar.setBackground(java.awt.Color.BLACK);
        bEntrar.setForeground(java.awt.Color.WHITE);
        bEntrar.setBounds(430, 520, 140, 55);
        bEntrar.addActionListener(this::bEntrarActionPerformed);
        add(bEntrar);
    }

    
    // Método executado quando o botão "Entrar" é clicado
    private void bEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        String usuario, senha;
        
        // Obtém o usuário digitado no campo de texto
        usuario = campoUsuario.getText();
        
        // Obtém a senha digitada e converte para String
        senha = String.valueOf(campoSenha.getPassword());

        // Cria um objeto DAO para acessar os dados dos usuários
        UsuarioDAO dao = new UsuarioDAO();

        // Verifica se o usuário e a senha estão corretos
        if (dao.login(usuario, senha)) {
            labelErro.setText("");  // limpa a mensagem de erro, caso exista

            // Abre a tela principal do sistema
            TelaMenu tela = new TelaMenu();
            tela.setVisible(true);

            // Fecha a tela de login
            dispose();
        } else {
            // Exibe mensagem de erro caso o login seja inválido
            labelErro.setText("Usuário ou senha inválidos!");
        }
    }
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
    
}
package view;

import dao.UsuarioDAO;

import javax.swing.SwingConstants;

public class TelaLogin extends javax.swing.JFrame {
    // Declaração das variáveis
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelSubTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelErro;

    private javax.swing.JTextField campoUsuario;
    private javax.swing.JPasswordField campoSenha;

    private javax.swing.JButton bEntrar;

    // Construtor da tela
    public TelaLogin() {
        initComponents();

        setSize(1000, 700);
        setLocationRelativeTo(null);  // centraliza a janela na tela
        setResizable(false);  // impede que o usuário redimensione a janela
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  // define que o programa será encerrado ao fechar a janela

        getContentPane().setBackground(java.awt.Color.WHITE);  // define a cor de fundo da janela como branca
    }


    private void initComponents() {
        // Componentes
        labelTitulo = new javax.swing.JLabel();
        labelSubTitulo = new javax.swing.JLabel();

        labelUsuario = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        labelErro = new javax.swing.JLabel();

        campoUsuario = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();

        bEntrar = new javax.swing.JButton();

        // Posicionamento absoluto
        setLayout(null);

        // TÍTULO
        labelTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
        labelTitulo.setText("SISTEMA DE OFICINA MECÂNICA");
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(150, 50, 700, 50);
        add(labelTitulo);

        // SUBTÍTULO
        labelSubTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 24));
        labelSubTitulo.setText("Faça seu login para continuar");
        labelSubTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelSubTitulo.setBounds(200, 120, 600, 35);
        add(labelSubTitulo);

        // LABEL USUÁRIO
        labelUsuario.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
        labelUsuario.setText("Usuário:");
        labelUsuario.setBounds(160, 240, 120, 25);
        add(labelUsuario);

        // CAMPO USUÁRIO
        campoUsuario.setBounds(160, 275, 680, 40);
        add(campoUsuario);

        // LABEL SENHA
        labelSenha.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
        labelSenha.setText("Senha:");
        labelSenha.setBounds(160, 350, 120, 25);
        add(labelSenha);

        // CAMPO SENHA
        campoSenha.setBounds(160, 385, 680, 40);
        add(campoSenha);

        // LABEL ERRO
        labelErro.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        labelErro.setHorizontalAlignment(SwingConstants.CENTER);
        labelErro.setForeground(java.awt.Color.RED);
        labelErro.setBounds(250, 450, 500, 30);
        add(labelErro);

        // BOTÃO ENTRAR
        bEntrar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bEntrar.setBackground(java.awt.Color.BLACK);
        bEntrar.setForeground(java.awt.Color.WHITE);
        bEntrar.setText("Entrar");
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
package view;

import javax.swing.*;

public class TelaMenu extends JFrame {
    // Declaração das variáveis
    private JLabel labelSubTitulo;
    private JLabel labelTitulo;

    private JButton bBuscarVeiculo;
    private JButton bCadastrarVeiculo;
    private JButton bSair;

    // Construtor da tela
    public TelaMenu() {
        initComponents();

        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        getContentPane().setBackground(java.awt.Color.WHITE);
    }

    // Método responsável pela montagem da interface gráfica da tela
    private void initComponents() {
        // Posicionamento absoluto
        setLayout(null);


        // TÍTULO
        labelTitulo = new JLabel("MENU PRINCIPAL");
        labelTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(200, 80, 600, 50);
        add(labelTitulo);

        // SUBTÍTULO
        labelSubTitulo = new JLabel("Seja bem-vindo!");
        labelSubTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 24));
        labelSubTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelSubTitulo.setBounds(250, 145, 500, 35);
        add(labelSubTitulo);

        // BOTÃO CADASTRAR VEÍCULO
        bCadastrarVeiculo = new JButton("Cadastrar Veículo");
        bCadastrarVeiculo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bCadastrarVeiculo.setBackground(java.awt.Color.WHITE);
        bCadastrarVeiculo.setForeground(java.awt.Color.BLACK);
        bCadastrarVeiculo.setBounds(275, 280, 450, 90);
        bCadastrarVeiculo.addActionListener(this::bCadastrarVeiculoActionPerformed);
        add(bCadastrarVeiculo);

        // BOTÃO BUSCAR VEÍCULO
        bBuscarVeiculo = new JButton("Buscar Veículo");
        bBuscarVeiculo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bBuscarVeiculo.setBackground(java.awt.Color.WHITE);
        bBuscarVeiculo.setForeground(java.awt.Color.BLACK);
        bBuscarVeiculo.setBounds(275, 400, 450,90);
        bBuscarVeiculo.addActionListener(this::bBuscarVeiculoActionPerformed);
        add(bBuscarVeiculo);
        
        // BOTÃO SAIR
        bSair = new JButton("Sair");
        bSair.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bSair.setBackground(java.awt.Color.BLACK);
        bSair.setForeground(java.awt.Color.WHITE);
        bSair.setBounds( 410, 530, 180, 55);
        bSair.addActionListener(this::bSairActionPerformed);
        add(bSair);
    }
    
    
    // Método executado quando o botão "Cadastrar Veículo" é clicado
     private void bCadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {
        TelaEscolherTipoVeiculo tela = new TelaEscolherTipoVeiculo();
        tela.setVisible(true);
        dispose();
    }
     
     // Método executado quando o botão "Buscar Veículo" é clicado
    private void bBuscarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {
        TelaBuscarVeiculos tela = new TelaBuscarVeiculos();
        tela.setVisible(true);
        dispose();
    }
    
    // Método executado quando o botão "Sair" é clicado
    private void bSairActionPerformed(java.awt.event.ActionEvent evt){
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        dispose();
    }
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaMenu().setVisible(true);
        });
    }
    
}
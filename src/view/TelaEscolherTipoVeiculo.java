package view;

import javax.swing.*;

public class TelaEscolherTipoVeiculo extends JFrame {
    // Declaração das variáveis
    private JLabel labelTitulo;
    private JLabel labelSubTitulo;

    private JButton bCadastrarCarro;
    private JButton bCadastrarMoto;
    private JButton bVoltar;

    // Construtor da tela
    public TelaEscolherTipoVeiculo() {
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
        labelTitulo = new JLabel("CADASTRAR VEÍCULO");
        labelTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(200, 70, 600, 50);
        add(labelTitulo);

        // SUBTÍTULO
        labelSubTitulo = new JLabel("Selecione o tipo de veículo");
        labelSubTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 24));
        labelSubTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelSubTitulo.setBounds(250, 135, 500, 35);
        add(labelSubTitulo);

        // BOTÃO CADASTRAR CARRO
        bCadastrarCarro = new JButton("Cadastrar Carro");
        bCadastrarCarro.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bCadastrarCarro.setBackground(java.awt.Color.WHITE);
        bCadastrarCarro.setForeground(java.awt.Color.BLACK);
        bCadastrarCarro.setBounds(275, 250, 450, 90);
        bCadastrarCarro.addActionListener(this::bCadastrarCarroPerformed);
        add(bCadastrarCarro);

        // BOTÃO CADASTRAR MOTO
        bCadastrarMoto = new JButton("Cadastrar Moto");
        bCadastrarMoto.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bCadastrarMoto.setBackground(java.awt.Color.WHITE);
        bCadastrarMoto.setForeground(java.awt.Color.BLACK);
        bCadastrarMoto.setBounds(275, 380, 450, 90);
        bCadastrarMoto.addActionListener(this::bCadastrarMotoPerformed);
        add(bCadastrarMoto);

        // BOTÃO VOLTAR
        bVoltar = new JButton("Voltar");
        bVoltar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bVoltar.setBackground(java.awt.Color.BLACK);
        bVoltar.setForeground(java.awt.Color.WHITE);
        bVoltar.setBounds(410, 530, 180, 55);
        bVoltar.addActionListener(this::bVoltarActionPerformed);
        add(bVoltar);
    }
    
    
    // Método executado quando o botão "Cadastrar Carro" é clicado
    private void bCadastrarCarroPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastrarCarro tela = new TelaCadastrarCarro();
        tela.setVisible(true);
        dispose();
    }
    
    // Método executado quando o botão "Cadastrar Moto" é clicado
    private void bCadastrarMotoPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastrarMoto tela = new TelaCadastrarMoto();
        tela.setVisible(true);
        dispose();
    }
    
    // Método executado quando o botão "Voltar" é clicado
    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt){
        TelaMenu tela = new TelaMenu();
        tela.setVisible(true);
        dispose();
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaEscolherTipoVeiculo().setVisible(true);
        });
    }
}
package view;

import javax.swing.SwingConstants;

public class TelaEscolherTipoVeiculo extends javax.swing.JFrame {
    // Declaração das variáveis
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelSubTitulo;

    private javax.swing.JButton bCadastrarCarro;
    private javax.swing.JButton bCadastrarMoto;
    private javax.swing.JButton bVoltar;

    // Construtor
    public TelaEscolherTipoVeiculo() {
        initComponents();

        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        getContentPane().setBackground(java.awt.Color.WHITE);
    }

    private void initComponents() {
        // Componentes
        labelTitulo = new javax.swing.JLabel();
        labelSubTitulo = new javax.swing.JLabel();

        bCadastrarCarro = new javax.swing.JButton();
        bCadastrarMoto = new javax.swing.JButton();
        bVoltar = new javax.swing.JButton();

        // Posicionamento absoluto
        setLayout(null);

        // TÍTULO
        labelTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
        labelTitulo.setText("CADASTRAR VEÍCULO");
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(200, 70, 600, 50);
        add(labelTitulo);

        // SUBTÍTULO
        labelSubTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 24));
        labelSubTitulo.setText("Selecione o tipo de veículo");
        labelSubTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelSubTitulo.setBounds(250, 135, 500, 35);
        add(labelSubTitulo);

        // BOTÃO CADASTRAR CARRO
        bCadastrarCarro.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bCadastrarCarro.setBackground(java.awt.Color.WHITE);
        bCadastrarCarro.setForeground(java.awt.Color.BLACK);
        bCadastrarCarro.setText("Cadastrar Carro");
        bCadastrarCarro.setBounds(275, 250, 450, 90);
        bCadastrarCarro.addActionListener(this::bCadastrarCarroPerformed);
        add(bCadastrarCarro);

        // BOTÃO CADASTRAR MOTO
        bCadastrarMoto.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bCadastrarMoto.setBackground(java.awt.Color.WHITE);
        bCadastrarMoto.setForeground(java.awt.Color.BLACK);
        bCadastrarMoto.setText("Cadastrar Moto");
        bCadastrarMoto.setBounds(275, 380, 450, 90);
        bCadastrarMoto.addActionListener(this::bCadastrarMotoPerformed);
        add(bCadastrarMoto);

        // BOTÃO VOLTAR
        bVoltar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bVoltar.setBackground(java.awt.Color.BLACK);
        bVoltar.setForeground(java.awt.Color.WHITE);
        bVoltar.setText("Voltar");
        bVoltar.setBounds(410, 530, 180, 55);
        bVoltar.addActionListener(this::bVoltarActionPerformed);
        add(bVoltar);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaEscolherTipoVeiculo().setVisible(true);
        });
    }
    private void bCadastrarCarroPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastrarCarro tela = new TelaCadastrarCarro();
        tela.setVisible(true);
        dispose();
    }
    private void bCadastrarMotoPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastrarMoto tela = new TelaCadastrarMoto();
        tela.setVisible(true);
        dispose();
    }
    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt){
        TelaMenu tela = new TelaMenu();
        tela.setVisible(true);
        dispose();
    }
}
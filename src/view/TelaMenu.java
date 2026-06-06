package view;

public class TelaMenu extends javax.swing.JFrame {
    // Declaração das variáveis
    private javax.swing.JLabel labelSubTitulo;
    private javax.swing.JLabel labelTitulo;

    private javax.swing.JButton bBuscarVeiculo;
    private javax.swing.JButton bCadastrarVeiculo;
    private javax.swing.JButton bSair;


    // Construtor da tela
    public TelaMenu() {
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

        bCadastrarVeiculo = new javax.swing.JButton();
        bBuscarVeiculo = new javax.swing.JButton();
        bSair = new javax.swing.JButton();

        // Usar posicionamento absoluto
        setLayout(null);


        // TÍTULO
        labelTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
        labelTitulo.setText("MENU PRINCIPAL");
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setBounds(200, 80, 600, 50);
        add(labelTitulo);

        // SUBTÍTULO
        labelSubTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 24));
        labelSubTitulo.setText("Seja bem-vindo!");
        labelSubTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubTitulo.setBounds(250, 145, 500, 35);
        add(labelSubTitulo);

        // BOTÃO CADASTRAR VEÍCULO
        bCadastrarVeiculo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bCadastrarVeiculo.setBackground(java.awt.Color.WHITE);
        bCadastrarVeiculo.setForeground(java.awt.Color.BLACK);
        bCadastrarVeiculo.setText("Cadastrar Veículo");
        bCadastrarVeiculo.setBounds(275, 280, 450, 90);
        bCadastrarVeiculo.addActionListener(this::bCadastrarVeiculoActionPerformed);
        add(bCadastrarVeiculo);

        // BOTÃO BUSCAR VEÍCULO
        bBuscarVeiculo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bBuscarVeiculo.setBackground(java.awt.Color.WHITE);
        bBuscarVeiculo.setForeground(java.awt.Color.BLACK);
        bBuscarVeiculo.setText("Buscar Veículo");
        bBuscarVeiculo.setBounds(275, 400, 450,90);
        bBuscarVeiculo.addActionListener(this::bBuscarVeiculoActionPerformed);
        add(bBuscarVeiculo);
        
        // BOTÃO SAIR
        bSair.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bSair.setBackground(java.awt.Color.BLACK);
        bSair.setForeground(java.awt.Color.WHITE);
        bSair.setText("Sair");
        bSair.setBounds( 410, 530, 180, 55);
        bSair.addActionListener(this::bSairActionPerformed);
        add(bSair);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaMenu().setVisible(true);
        });
    }
     private void bCadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {
        TelaEscolherTipoVeiculo tela = new TelaEscolherTipoVeiculo();
        tela.setVisible(true);
        dispose();
    }
    private void bBuscarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {
        TelaBuscarVeiculos tela = new TelaBuscarVeiculos();
        tela.setVisible(true);
        dispose();
    }
    private void bSairActionPerformed(java.awt.event.ActionEvent evt){
    TelaLogin tela = new TelaLogin();
    tela.setVisible(true);
    dispose();
    }
    
}
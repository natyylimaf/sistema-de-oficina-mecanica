package view;

import javax.swing.*;

public class TelaCadastrarMoto extends JFrame {
    // Declaração das variáveis
    private JPanel painel;

    private JLabel labelTitulo;

    private JLabel labelNomeCliente;
    private JLabel labelCPF;
    private JLabel labelTelefone;
    private JLabel labelModelo;
    private JLabel labelPlaca;
    private JLabel labelCor;
    private JLabel labelAno;
    private JLabel labelCilindradas;
    private JLabel labelDataChegada;
    private JLabel labelMotivoEntrada;
    private JLabel labelDiagnostico;
    private JLabel labelStatus;

    private JTextField campoNomeCliente;
    private JTextField campoCPF;
    private JTextField campoTelefone;
    private JTextField campoModeloVeiculo;
    private JTextField campoPlaca;
    private JTextField campoCor;
    private JTextField campoAnoVeiculo;
    private JTextField campoCilindradas;
    private JTextField campoDataChegada;

    private JTextArea campoMotivoEntrada;
    private JTextArea campoDiagnostico;

    private JComboBox<String> comboStatus;

    private JButton bSalvar;
    private JButton bCancelar;

    // Construtor da tela
    public TelaCadastrarMoto() {
        initComponents();

        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(java.awt.Color.WHITE);

        setVisible(true);
    }

    private void initComponents() {
        painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(java.awt.Color.WHITE);

        JScrollPane scrollTela = new JScrollPane(painel);
        scrollTela.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTela.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setContentPane(scrollTela);

        // TÍTULO
        labelTitulo = new JLabel("CADASTRAR MOTO");
        labelTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(250, 20, 500, 40);
        painel.add(labelTitulo);

        // NOME CLIENTE
        labelNomeCliente = new JLabel("Nome do Cliente:");
        labelNomeCliente.setBounds(80, 90, 150, 25);
        painel.add(labelNomeCliente);

        campoNomeCliente = new JTextField();
        campoNomeCliente.setBounds(80, 120, 800, 35);
        painel.add(campoNomeCliente);

        // CPF
        labelCPF = new JLabel("CPF:");
        labelCPF.setBounds(80, 175, 100, 25);
        painel.add(labelCPF);

        campoCPF = new JTextField();
        campoCPF.setBounds(80, 205, 350, 35);
        painel.add(campoCPF);

        // TELEFONE
        labelTelefone = new JLabel("Telefone:");
        labelTelefone.setBounds(530, 175, 100, 25);
        painel.add(labelTelefone);

        campoTelefone = new JTextField();
        campoTelefone.setBounds(530, 205, 350, 35);
        painel.add(campoTelefone);

        // MODELO
        labelModelo = new JLabel("Modelo:");
        labelModelo.setBounds(80, 265, 100, 25);
        painel.add(labelModelo);

        campoModeloVeiculo = new JTextField();
        campoModeloVeiculo.setBounds(80, 295, 350, 35);
        painel.add(campoModeloVeiculo);

        // PLACA
        labelPlaca = new JLabel("Placa:");
        labelPlaca.setBounds(530, 265, 100, 25);
        painel.add(labelPlaca);

        campoPlaca = new JTextField();
        campoPlaca.setBounds(530, 295, 350, 35);
        painel.add(campoPlaca);

        // COR
        labelCor = new JLabel("Cor:");
        labelCor.setBounds(80, 355, 100, 25);
        painel.add(labelCor);

        campoCor = new JTextField();
        campoCor.setBounds(80, 385, 350, 35);
        painel.add(campoCor);

        // ANO
        labelAno = new JLabel("Ano:");
        labelAno.setBounds(530, 355, 100, 25);
        painel.add(labelAno);

        campoAnoVeiculo = new JTextField();
        campoAnoVeiculo.setBounds(530, 385, 350, 35);
        painel.add(campoAnoVeiculo);

        // CILINDRADAS
        labelCilindradas = new JLabel("Cilindradas:");
        labelCilindradas.setBounds(80, 445, 180, 25);
        painel.add(labelCilindradas);

        campoCilindradas = new JTextField();
        campoCilindradas.setBounds(80, 475, 350, 35);
        painel.add(campoCilindradas);

        // DATA CHEGADA
        labelDataChegada = new JLabel("Data de Chegada:");
        labelDataChegada.setBounds(530, 445, 150, 25);
        painel.add(labelDataChegada);

        campoDataChegada = new JTextField();
        campoDataChegada.setBounds(530, 475, 350, 35);
        painel.add(campoDataChegada);

        // MOTIVO DA ENTRADA
        labelMotivoEntrada = new JLabel("Motivo da Entrada:");
        labelMotivoEntrada.setBounds(80, 535, 150, 25);
        painel.add(labelMotivoEntrada);

        campoMotivoEntrada = new JTextArea();

        JScrollPane scrollMotivoEntrada = new JScrollPane(campoMotivoEntrada);
        scrollMotivoEntrada.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollMotivoEntrada.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        campoMotivoEntrada.setLineWrap(true);
        campoMotivoEntrada.setWrapStyleWord(true);

        scrollMotivoEntrada.setBounds(80, 565, 350, 60);
        painel.add(scrollMotivoEntrada);

        // DIAGNÓSTICO
        labelDiagnostico = new JLabel("Diagnóstico:");
        labelDiagnostico.setBounds(530, 535, 120, 25);
        painel.add(labelDiagnostico);

        campoDiagnostico = new JTextArea();

        JScrollPane scrollDiagnostico = new JScrollPane(campoDiagnostico);
        scrollDiagnostico.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollDiagnostico.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        campoDiagnostico.setLineWrap(true);
        campoDiagnostico.setWrapStyleWord(true);

        scrollDiagnostico.setBounds(530, 565, 350, 60);
        painel.add(scrollDiagnostico);

        // STATUS
        labelStatus = new JLabel("Status:");
        labelStatus.setBounds(80, 640, 100, 25);
        painel.add(labelStatus);

        comboStatus = new JComboBox<>();
        comboStatus.setModel(
                new DefaultComboBoxModel<>(
                        new String[]{
                                "PENDENTE",
                                "EM ANDAMENTO",
                                "CONCLUÍDO"
                        }
                )
        );

        comboStatus.setBounds(150, 640, 200, 30);
        painel.add(comboStatus);

        // BOTÕES SALVAR E CANCELAR
        bSalvar = new JButton("Salvar");
        bSalvar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bSalvar.setBackground(java.awt.Color.BLACK);
        bSalvar.setForeground(java.awt.Color.WHITE);
        bSalvar.setBounds(650, 640, 120, 40);
        painel.add(bSalvar);

        bCancelar = new JButton("Cancelar");
        bCancelar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bCancelar.setBackground(java.awt.Color.WHITE);
        bCancelar.setForeground(java.awt.Color.BLACK);
        bCancelar.setBounds(790, 640, 140, 40);
        painel.add(bCancelar);

        painel.setPreferredSize(new java.awt.Dimension(980, 1200));
    }

    public static void main(String[] args) {
        new TelaCadastrarMoto();
    }
}
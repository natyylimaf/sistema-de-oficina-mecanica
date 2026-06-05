package view;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.*;

import model.Moto;
import dao.MotoDAO;

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
    
    private JSpinner campoDataChegada;

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
        labelNomeCliente.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelNomeCliente.setBounds(80, 90, 150, 25);
        painel.add(labelNomeCliente);

        campoNomeCliente = new JTextField();
        campoNomeCliente.setBounds(80, 120, 800, 35);
        painel.add(campoNomeCliente);

        
        // CPF
        labelCPF = new JLabel("CPF:");
        labelCPF.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelCPF.setBounds(80, 175, 100, 25);
        painel.add(labelCPF);

        campoCPF = new JTextField();
        campoCPF.setBounds(80, 205, 350, 35);
        painel.add(campoCPF);

        
        // TELEFONE
        labelTelefone = new JLabel("Telefone:");
        labelTelefone.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelTelefone.setBounds(530, 175, 100, 25);
        painel.add(labelTelefone);

        campoTelefone = new JTextField();
        campoTelefone.setBounds(530, 205, 350, 35);
        painel.add(campoTelefone);

        
        // MODELO
        labelModelo = new JLabel("Modelo:");
        labelModelo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelModelo.setBounds(80, 265, 100, 25);
        painel.add(labelModelo);

        campoModeloVeiculo = new JTextField();
        campoModeloVeiculo.setBounds(80, 295, 350, 35);
        painel.add(campoModeloVeiculo);

        
        // PLACA
        labelPlaca = new JLabel("Placa:");
        labelPlaca.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelPlaca.setBounds(530, 265, 100, 25);
        painel.add(labelPlaca);

        campoPlaca = new JTextField();
        campoPlaca.setBounds(530, 295, 350, 35);
        painel.add(campoPlaca);

        
        // COR
        labelCor = new JLabel("Cor:");
        labelCor.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelCor.setBounds(80, 355, 100, 25);
        painel.add(labelCor);

        campoCor = new JTextField();
        campoCor.setBounds(80, 385, 350, 35);
        painel.add(campoCor);

        
        // ANO
        labelAno = new JLabel("Ano:");
        labelAno.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelAno.setBounds(530, 355, 100, 25);
        painel.add(labelAno);

        campoAnoVeiculo = new JTextField();
        campoAnoVeiculo.setBounds(530, 385, 350, 35);
        painel.add(campoAnoVeiculo);

        
        // CILINDRADAS
        labelCilindradas = new JLabel("Cilindradas:");
        labelCilindradas.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelCilindradas.setBounds(80, 445, 180, 25);
        painel.add(labelCilindradas);

        campoCilindradas = new JTextField();
        campoCilindradas.setBounds(80, 475, 350, 35);
        painel.add(campoCilindradas);

        
        // DATA CHEGADA
        labelDataChegada = new JLabel("Data de Chegada:");
        labelDataChegada.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelDataChegada.setBounds(530, 445, 150, 25);
        painel.add(labelDataChegada);

        campoDataChegada = new JSpinner(new SpinnerDateModel());

        JSpinner.DateEditor editor = new JSpinner.DateEditor(campoDataChegada, "dd/MM/yyyy");
        campoDataChegada.setEditor(editor);
        
        campoDataChegada.setBounds(530, 475, 350, 35);
        painel.add(campoDataChegada);

        
        // MOTIVO DA ENTRADA
        labelMotivoEntrada = new JLabel("Motivo da Entrada:");
        labelMotivoEntrada.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
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
        labelDiagnostico.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
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
        labelStatus.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
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
        bSalvar.addActionListener(this::bSalvarActionPerformed);
        painel.add(bSalvar);

        bCancelar = new JButton("Cancelar");
        bCancelar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bCancelar.setBackground(java.awt.Color.WHITE);
        bCancelar.setForeground(java.awt.Color.BLACK);
        bCancelar.setBounds(790, 640, 140, 40);
        painel.add(bCancelar);

        painel.setPreferredSize(new java.awt.Dimension(980, 1200));
    }
    
    // Método executado quando o botão "Salvar" é clicado
    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        String nomeCliente, cpf, celular, modelo, placa, cor, motivo, diagnostico, status;
        int cilindradas, ano;
        Date dataAntiga;
        LocalDate data;
        
        try {
            // Obtém os dados dos campos de texto
            nomeCliente = campoNomeCliente.getText();
            cpf = campoCPF.getText();
            celular = campoTelefone.getText();
            modelo = campoModeloVeiculo.getText();
            placa = campoPlaca.getText();
            cor = campoCor.getText();

            // Converte os campos numéricos de String para int
            cilindradas = Integer.parseInt(campoCilindradas.getText());
            ano = Integer.parseInt(campoAnoVeiculo.getText());

            
            // Obtém a data selecionada no JSpinner
            dataAntiga = (Date) campoDataChegada.getValue();
            
            // Converte Date para LocalDate
            data = dataAntiga.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            
            // Obtém os textos dos campos de descrição
            motivo = campoMotivoEntrada.getText();
            diagnostico = campoDiagnostico.getText();
            
            // Obtém o status selecionado no ComboBox
            status = (String) comboStatus.getSelectedItem();

            // Cria um objeto Moto com os dados informados
            Moto novaMoto = new Moto(
                    nomeCliente,
                    cpf,
                    celular,
                    modelo,
                    placa,
                    cor,
                    ano,
                    data,
                    motivo,
                    diagnostico,
                    status,
                    cilindradas
            );

            // Cria o objetoDAO responsável pela comunicação com o banco
            MotoDAO dao = new MotoDAO(util.Conexao.conectar());
            // Salva a moto no banco de dados
            dao.salvar(novaMoto);

            // Exibe mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Moto salva com sucesso!");

        } catch (Exception e) {
            // Exibe mensagem de erro caso ocorra alguma exceção
            JOptionPane.showMessageDialog(this, "Erro ao salvar moto. Verifique os dados.\n" + e.getMessage());
            
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TelaCadastrarMoto();
    }
}
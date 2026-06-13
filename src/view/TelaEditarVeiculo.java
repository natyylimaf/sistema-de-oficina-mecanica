package view;

import javax.swing.*;
import dao.VeiculoDAO;

public class TelaEditarVeiculo extends JFrame {
    // Declaração das variáveis
    private JPanel painel;

    private JLabel labelTitulo;

    private JLabel labelNomeMotorista;
    private JLabel labelCPF;
    private JLabel labelTelefone;
    private JLabel labelModelo;
    private JLabel labelPlaca;
    private JLabel labelCor;
    private JLabel labelAno;
    private JLabel labelQuantidadePortas;
    private JLabel labelCilindradas;
    private JLabel labelDataChegada;
    private JLabel labelMotivoEntrada;
    private JLabel labelDiagnostico;
    private JLabel labelStatus;
    private JLabel labelMaoDeObra;
    private JLabel labelValorPecas;
    private JLabel labelOrcamento;

    private JTextField campoNomeMotorista;
    private JTextField campoCPF;
    private JTextField campoTelefone;
    private JTextField campoModelo;
    private JTextField campoPlaca;
    private JTextField campoCor;
    private JTextField campoAno;
    private JTextField campoQuantidadePortas;
    private JTextField campoCilindradas;
    private JTextField campoMaoDeObra;
    private JTextField campoValorPecas;
    private JTextField campoOrcamento;

    private JSpinner campoDataChegada;

    private JTextArea campoMotivoEntrada;
    private JTextArea campoDiagnostico;

    private JComboBox<String> comboStatus;
    

    private JButton bGerarOrcamento;
    private JButton bSalvar;
    private JButton bCancelar;
    
    private int idVeiculo;

    // Construtor da tela
    public TelaEditarVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
        
        initComponents();
        
        carregarDadosVeiculo();

        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        getContentPane().setBackground(java.awt.Color.WHITE);
        
        setVisible(true);
    }

    // Método responsável pela montagem da interface gráfica da tela
    private void initComponents() {
        painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(java.awt.Color.WHITE);

        JScrollPane scrollTela = new JScrollPane(painel);
        scrollTela.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTela.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setContentPane(scrollTela);

        // TÍTULO
        labelTitulo = new JLabel("EDITAR VEÍCULO");
        labelTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(250, 20, 500, 40);
        painel.add(labelTitulo);
        
        // NOME DO MOTORISTA
        labelNomeMotorista = new JLabel("Nome do Motorista:");
        labelNomeMotorista.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelNomeMotorista.setBounds(80, 90, 150, 25);
        painel.add(labelNomeMotorista);

        campoNomeMotorista = new JTextField();
        campoNomeMotorista.setBounds(80, 120, 800, 35);
        painel.add(campoNomeMotorista);
        
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

        campoModelo = new JTextField();
        campoModelo.setBounds(80, 295, 350, 35);
        painel.add(campoModelo);
        
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

        campoAno = new JTextField();
        campoAno.setBounds(530, 385, 350, 35);
        painel.add(campoAno);
        
        // QUANTIDADE DE PORTAS
        labelQuantidadePortas = new JLabel("Quantidade de Portas:");
        labelQuantidadePortas.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelQuantidadePortas.setBounds(80, 445, 180, 25);
        painel.add(labelQuantidadePortas);

        campoQuantidadePortas = new JTextField();
        campoQuantidadePortas.setBounds(80, 475, 350, 35);
        painel.add(campoQuantidadePortas);
        
        // CILINDRADAS
        labelCilindradas = new JLabel("Cilindradas:");
        labelCilindradas.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelCilindradas.setBounds(80, 445, 180, 25);
        painel.add(labelCilindradas);

        campoCilindradas = new JTextField();
        campoCilindradas.setBounds(80, 475, 350, 35);
        painel.add(campoCilindradas);
        
        // DATA
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
                            "PRONTO",
                            "DESATIVADO"
                        }
                )
        );

        comboStatus.setBounds(180, 640, 200, 30);
        painel.add(comboStatus);

        // MÃO DE OBRA
        labelMaoDeObra = new JLabel("Mão de Obra:");
        labelMaoDeObra.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelMaoDeObra.setBounds(80, 740, 100, 25);
        painel.add(labelMaoDeObra);

        campoMaoDeObra = new JTextField();
        campoMaoDeObra.setBounds(180, 740, 200, 30);
        campoMaoDeObra.setEditable(false);
        painel.add(campoMaoDeObra);
        
        // VALOR DAS PEÇAS
        labelValorPecas = new JLabel("Valor das Peças:");
        labelValorPecas.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelValorPecas.setBounds(80, 800, 100, 25);
        painel.add(labelValorPecas);
        
        campoValorPecas = new JTextField();
        campoValorPecas.setBounds(180, 800, 200, 30);
        painel.add(campoValorPecas);
        
        // ORÇAMENTO
        labelOrcamento = new JLabel("Orçamento:");
        labelOrcamento.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelOrcamento.setBounds(80, 860, 100, 25);
        painel.add(labelOrcamento);
        
        campoOrcamento = new JTextField();
        campoOrcamento.setBounds(180, 860, 200, 30);
        campoOrcamento.setEditable(false);
        painel.add(campoOrcamento);
        
        // BOTÃO GERAR ORÇAMENTO
        bGerarOrcamento = new JButton("Gerar Orçamento");
        bGerarOrcamento.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        bGerarOrcamento.setBounds(80, 920, 170, 40);
        painel.add(bGerarOrcamento);
        
        // BOTÃO SALVAR ALTERAÇÕES
        bSalvar = new JButton("Salvar Alterações");
        bSalvar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bSalvar.setBackground(java.awt.Color.BLACK);
        bSalvar.setForeground(java.awt.Color.WHITE);
        bSalvar.setBounds(80, 1020, 190, 40);
        bSalvar.addActionListener(e -> salvarAlteracoes());
        painel.add(bSalvar);
        
        // BOTÃO CANCELAR
        bCancelar = new JButton("Cancelar");
        bCancelar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bCancelar.setBackground(java.awt.Color.WHITE);
        bCancelar.setForeground(java.awt.Color.BLACK);
        bCancelar.setBounds(278, 1020, 140, 40);
        bCancelar.addActionListener(e -> cancelar());
        painel.add(bCancelar);
        
        
        // Escondendo campos que não devem aparecer inicialmente
        labelQuantidadePortas.setVisible(false);
        campoQuantidadePortas.setVisible(false);

        labelCilindradas.setVisible(false);
        campoCilindradas.setVisible(false);

        
        // Define o tamanho preferido do painel
        painel.setPreferredSize(new java.awt.Dimension(980, 1300));
    }

    
    // Método que configura a tela para exibir campos de CARRO
    public void mostrarCamposCarro() {
        labelQuantidadePortas.setVisible(true);
        campoQuantidadePortas.setVisible(true);

        labelCilindradas.setVisible(false);
        campoCilindradas.setVisible(false);
    }

    // Método que configura a tela para exibir campos de MOTO
    public void mostrarCamposMoto() {
        labelQuantidadePortas.setVisible(false);
        campoQuantidadePortas.setVisible(false);

        labelCilindradas.setVisible(true);
        campoCilindradas.setVisible(true);
    }
    
    // Método responsável por carregar os dados do veículo selecionado
    private void carregarDadosVeiculo() {
        VeiculoDAO dao = new VeiculoDAO();
        Object[] dados = dao.buscarPorId(idVeiculo);

        if (dados == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Veículo não encontrado!"
            );
            return;
        }

        campoNomeMotorista.setText(dados[1].toString());
        campoCPF.setText(dados[2].toString());
        campoTelefone.setText(dados[3].toString());
        campoModelo.setText(dados[4].toString());
        campoPlaca.setText(dados[5].toString());
        campoCor.setText(dados[6].toString());
        campoAno.setText(dados[7].toString());

        campoMotivoEntrada.setText(
                dados[9] == null ? "" : dados[9].toString()
        );

        campoDiagnostico.setText(
                dados[10] == null ? "" : dados[10].toString()
        );

        if (dados[12] != null) {
            comboStatus.setSelectedItem(
                    dados[12].toString()
            );
        }

        String tipo = dados[11].toString();

        if (tipo.equals("CARRO")) {

            mostrarCamposCarro();

            if (dados[13] != null) {
                campoQuantidadePortas.setText(
                        dados[13].toString()
                );
            }

        } else {

            mostrarCamposMoto();

            if (dados[14] != null) {
                campoCilindradas.setText(
                        dados[14].toString()
                );
            }
        }
    }
    
    // Método responsável por salvar as alterações do veículo
    private void salvarAlteracoes() {
        VeiculoDAO dao = new VeiculoDAO();

        boolean sucesso = dao.atualizarVeiculo(
                idVeiculo,
                campoNomeMotorista.getText(),
                campoCPF.getText(),
                campoTelefone.getText(),
                campoModelo.getText(),
                campoPlaca.getText(),
                campoCor.getText(),
                Integer.parseInt(campoAno.getText()),
                campoMotivoEntrada.getText(),
                campoDiagnostico.getText(),
                comboStatus.getSelectedItem().toString()
        );

        if (sucesso) {

            JOptionPane.showMessageDialog(
                    this,
                    "Veículo atualizado com sucesso!"
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao atualizar veículo!"
            );
        }
    }
    
    // Método responsável por cancelar a edição e retornar à tela de busca
    private void cancelar() {
        TelaBuscarVeiculos tela = new TelaBuscarVeiculos();
        tela.setVisible(true);
        dispose();
    }
}
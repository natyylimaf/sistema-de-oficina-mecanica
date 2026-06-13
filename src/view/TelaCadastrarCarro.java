package view;

import java.time.LocalDate;
import java.time.ZoneId;

import model.Carro;
import dao.CarroDAO;

import java.util.Date;
import javax.swing.*;

public class TelaCadastrarCarro extends JFrame {
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
    private JLabel labelDataChegada;
    private JLabel labelMotivoEntrada;
    private JLabel labelStatus;

    private JTextField campoNomeMotorista;
    private JTextField campoCPF;
    private JTextField campoTelefone;
    private JTextField campoModelo;
    private JTextField campoPlaca;
    private JTextField campoCor;
    private JTextField campoAno;
    private JTextField campoQuantidadePortas;
    private JTextField campoStatus;

    private JSpinner campoDataChegada;

    private JTextArea campoMotivoEntrada;

    private JButton bSalvar;
    private JButton bCancelar;

    // Construtor da tela
    public TelaCadastrarCarro() {
        initComponents();

        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
        labelTitulo = new JLabel("CADASTRAR CARRO");
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

        
        // PORTAS
        labelQuantidadePortas = new JLabel("Quantidade de Portas:");
        labelQuantidadePortas.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelQuantidadePortas.setBounds(80, 445, 180, 25);
        painel.add(labelQuantidadePortas);

        campoQuantidadePortas = new JTextField();
        campoQuantidadePortas.setBounds(80, 475, 350, 35);
        painel.add(campoQuantidadePortas);

        
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

        
        // STATUS
        labelStatus = new JLabel("Status:");
        labelStatus.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelStatus.setBounds(530, 535, 100, 25);
        painel.add(labelStatus);

        campoStatus = new JTextField("PENDENTE");
        campoStatus.setBounds(530, 565, 350, 35);
        campoStatus.setEditable(false);
        painel.add(campoStatus);
        
        // BOTÃO SALVAR
        bSalvar = new JButton("Salvar");
        bSalvar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bSalvar.setBackground(java.awt.Color.BLACK);
        bSalvar.setForeground(java.awt.Color.WHITE);
        bSalvar.setBounds(80, 650, 140, 40);
        bSalvar.addActionListener(this::bSalvarActionPerformed);
        painel.add(bSalvar);


        // BOTÃO CANCELAR
        bCancelar = new JButton("Cancelar");
        bCancelar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        bCancelar.setBackground(java.awt.Color.WHITE);
        bCancelar.setForeground(java.awt.Color.BLACK);
        bCancelar.setBounds(240, 650, 140, 40);
        bCancelar.addActionListener(this::bCancelarActionPerformed);
        painel.add(bCancelar);

        painel.setPreferredSize(new java.awt.Dimension(980, 1200));
    }

    
    // Método executado quando o botão "Salvar" é clicado
    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        String nomeMotorista, cpf, celular, modelo, placa, cor, motivo;
        int portas, ano;
        Date dataAntiga;
        LocalDate data;
        
        
        try {
            // Verifica se todos os campos obrigatórios foram preenchidos
            if (campoNomeMotorista.getText().trim().isEmpty() ||
                campoCPF.getText().trim().isEmpty() ||
                campoTelefone.getText().trim().isEmpty() ||
                campoModelo.getText().trim().isEmpty() ||
                campoPlaca.getText().trim().isEmpty() ||
                campoCor.getText().trim().isEmpty() ||
                campoAno.getText().trim().isEmpty() ||
                campoQuantidadePortas.getText().trim().isEmpty() ||
                campoMotivoEntrada.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Todos os campos são obrigatórios!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }
            
            
            // Obtém os dados dos campos de texto
            nomeMotorista = campoNomeMotorista.getText();
            cpf = campoCPF.getText();
            celular = campoTelefone.getText();
            modelo = campoModelo.getText();
            placa = campoPlaca.getText();
            cor = campoCor.getText();

            // Converte os campos numéricos de String para int
            portas = Integer.parseInt(campoQuantidadePortas.getText());
            ano = Integer.parseInt(campoAno.getText());

            
            // Obtém a data selecionada no JSpinner
            dataAntiga = (Date) campoDataChegada.getValue();
            
            // Converte Date para LocalDate
            data = dataAntiga.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            
            // Obtém os textos dos campos de descrição
            motivo = campoMotivoEntrada.getText();

            // Cria um objeto Carro com os dados informados
            Carro novoCarro = new Carro(
                    nomeMotorista,
                    cpf,
                    celular,
                    modelo,
                    placa,
                    cor,
                    ano,
                    data,
                    motivo,
                    "",
                    "PENDENTE",
                    portas
            );

            // Cria o objetoDAO responsável pela comunicação com o banco
            CarroDAO dao = new CarroDAO(util.Conexao.conectar());
            // Salva a moto no banco de dados
            boolean salvo = dao.salvar(novoCarro);

            if (salvo) {
                JOptionPane.showMessageDialog(
                        this,
                        "Carro salvo com sucesso!"
                );

                limparCampos();
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Não foi possível salvar o carro. Verifique a conexão com o banco de dados.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
            }

        } catch (Exception e) {
            // Exibe mensagem de erro caso ocorra alguma exceção
            JOptionPane.showMessageDialog(this, "Erro ao salvar. Verifique os dados.\n" + e.getMessage());
        }
    }
    
    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt){
        TelaEscolherTipoVeiculo tela = new TelaEscolherTipoVeiculo();
        tela.setVisible(true);
        dispose();
    }
    
    
    // Método para limpar os campos após o cadastro do carro
    private void limparCampos() {
        campoNomeMotorista.setText("");
        campoCPF.setText("");
        campoTelefone.setText("");
        campoModelo.setText("");
        campoPlaca.setText("");
        campoCor.setText("");
        campoAno.setText("");
        campoQuantidadePortas.setText("");
        campoMotivoEntrada.setText("");

        campoDataChegada.setValue(new Date());

        campoStatus.setText("PENDENTE");
    }
    
    
    
    
    public static void main(String[] args) {
        new TelaCadastrarCarro();
    }
}
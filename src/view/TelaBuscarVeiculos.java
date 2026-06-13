package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.List;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dao.VeiculoDAO;

public class TelaBuscarVeiculos extends JFrame {
    // Declaração das variáveis
    private JPanel painel;

    private JLabel labelTitulo;
    private JLabel labelTipo;
    private JLabel labelStatus;
    private JLabel labelPesquisar;

    private JComboBox<String> comboTipo;
    private JComboBox<String> comboStatus;

    private JTextField campoPesquisar;

    private JButton bBuscar;
    private JButton bVoltar;

    private JTable tabelaVeiculos;
    private JScrollPane scrollTabela;

    private DefaultTableModel modeloTabela;
    
    // Construtor da tela
    public TelaBuscarVeiculos() {
        initComponents();
        
        carregarTabela();
        
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
        
        // TÍTULO
        labelTitulo = new JLabel("BUSCAR VEÍCULOS");
        labelTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(250, 20, 500, 40);
        painel.add(labelTitulo);
        
        
        // FILTRO TIPO
        labelTipo = new JLabel("Tipo:");
        labelTipo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelTipo.setBounds(80, 100, 80, 25);
        painel.add(labelTipo);
        
        // COMBOBOX TIPO
        comboTipo = new JComboBox<>();
        comboTipo.setModel(
                new DefaultComboBoxModel<>(
                        new String[]{
                            "Todos",
                            "CARRO",
                            "MOTO"
                        }
                )
        );

        comboTipo.setBounds(80, 130, 180, 35);
        painel.add(comboTipo);
        
        
        // FILTRO STATUS
        labelStatus = new JLabel("Status:");
        labelStatus.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelStatus.setBounds(300, 100, 80, 25);
        painel.add(labelStatus);
        
        // COMBOBOX STATUS
        comboStatus = new JComboBox<>();
        comboStatus.setModel(
                new DefaultComboBoxModel<>(
                        new String[]{
                            "Todos",
                            "PENDENTE",
                            "EM ANDAMENTO",
                            "PRONTO",
                            "DESATIVADO"
                        }
                )
        );

        comboStatus.setBounds(300, 130, 180, 35);
        painel.add(comboStatus);
        
        
        // PESQUISAR
        labelPesquisar = new JLabel("Pesquisar:");
        labelPesquisar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        labelPesquisar.setBounds(520, 100, 100, 25);
        painel.add(labelPesquisar);
        
        // CAMPO PESQUISAR
        campoPesquisar = new JTextField();
        campoPesquisar.setBounds(520, 130, 250, 35);
        painel.add(campoPesquisar);
        
        
        // BOTÃO BUSCAR
        bBuscar = new JButton("Buscar");
        bBuscar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        bBuscar.setBackground(java.awt.Color.WHITE);
        bBuscar.setForeground(java.awt.Color.BLACK);
        bBuscar.setBounds(790, 130, 100, 35);
        painel.add(bBuscar);
        
        
        // TABELA
        modeloTabela = new DefaultTableModel();

        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Tipo");
        modeloTabela.addColumn("Modelo");
        modeloTabela.addColumn("Placa");
        modeloTabela.addColumn("Cliente");
        modeloTabela.addColumn("Status");

        // Cria a tabela utilizando o modelo de dados
        tabelaVeiculos = new JTable(modeloTabela) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Adiciona um listener de mouse para detectar cliques na tabela
        tabelaVeiculos.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int linha = tabelaVeiculos.getSelectedRow();
                    int idVeiculo = Integer.parseInt(tabelaVeiculos.getValueAt(linha, 0).toString());

                    String tipo = tabelaVeiculos
                            .getValueAt(linha, 1)
                            .toString();

                    TelaEditarVeiculo tela = new TelaEditarVeiculo(idVeiculo);

                    if (tipo.equals("CARRO")) {
                        tela.mostrarCamposCarro();
                    } else {
                        tela.mostrarCamposMoto();
                    }
                }
            }
        });

        scrollTabela = new JScrollPane(tabelaVeiculos);
        scrollTabela.setBounds(80, 200, 810, 350);

        painel.add(scrollTabela);
        
        
        // BOTÃO VOLTAR
        bVoltar = new JButton("Voltar");
        bVoltar.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
        bVoltar.setBounds(760, 580, 130, 40);
        bVoltar.setBackground(java.awt.Color.BLACK);
        bVoltar.setForeground(java.awt.Color.WHITE);
        bVoltar.addActionListener(this::bVoltarActionPerformed);
        painel.add(bVoltar);
        
        // Clique no botão Buscar
        bBuscar.addActionListener(e -> carregarTabela());

        // Enter no campo de pesquisa
        campoPesquisar.addActionListener(e -> carregarTabela());
        
        setContentPane(painel);  
    }
    
    
    // Método responsável por carregar os veículos na tabela
    private void carregarTabela() {
        // Remove todas as linhas atuais da tabela
        modeloTabela.setRowCount(0);

        // Cria um objeto para acessar os métodos do VeiculoDAO
        VeiculoDAO dao = new VeiculoDAO();

        // Busca os veículos no banco de dados de acordo com os filtros selecionados
        List<Object[]> lista = dao.buscarVeiculos(
                campoPesquisar.getText(),
                comboTipo.getSelectedItem().toString(),
                comboStatus.getSelectedItem().toString()
        );

        // Percorre a lista de veículos retornada pela consulta
        for (Object[] linha : lista) {
            modeloTabela.addRow(linha);  // adiciona cada veículo como uma nova linha na tabela
        }
    }
    
    // Método executado quando o botão "Voltar" é clicado
    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt){
        TelaMenu tela = new TelaMenu();
        tela.setVisible(true);
        dispose();
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        new TelaBuscarVeiculos();
    }
}

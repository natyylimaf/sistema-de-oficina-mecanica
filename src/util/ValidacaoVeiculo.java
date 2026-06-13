package util;

import java.time.LocalDate;
import java.time.Year;

public class ValidacaoVeiculo {

    public static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do motorista é obrigatório.");
        }
    }

    public static void validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF é obrigatório.");
        }
        cpf = cpf.replace(".", "").replace("-", "");
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido. Informe 11 dígitos numéricos.");
        }
    }

    public static void validarTelefone(String tel) {
        if (tel == null || tel.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório.");
        }
        tel = tel.replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
        if (!tel.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Telefone inválido. Informe 10 ou 11 dígitos numéricos.");
        }
    }

    public static void validarModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo é obrigatório.");
        }
    }

    public static void validarPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("Placa é obrigatória.");
        }
    }

    public static void validarCor(String cor) {
        if (cor == null || cor.trim().isEmpty()) {
            throw new IllegalArgumentException("Cor é obrigatória.");
        }
    }

    public static void validarAno(int ano) {
        int anoAtual = Year.now().getValue();
        if (ano < 1950 || ano > anoAtual) {
            throw new IllegalArgumentException("Ano inválido. Informe um ano entre 1950 e " + anoAtual + ".");
        }
    }

    public static void validarMotivo(String motivo) {
        if (motivo == null || motivo.trim().isEmpty()) {
            throw new IllegalArgumentException("Motivo da entrada é obrigatório.");
        }
    }

    public static void validarData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data de chegada é obrigatória.");
        }
        if (data.getYear() < 2000) {
            throw new IllegalArgumentException("Data de chegada inválida. O ano não pode ser anterior a 2000.");
        }
        if (data.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de chegada inválida. Não pode ser uma data futura.");
        }
    }

    public static void validarQuantidadePortas(int portas) {
        if (portas <= 0 || portas > 6) {
            throw new IllegalArgumentException("Quantidade de portas inválida. Informe um valor entre 1 e 6.");
        }
    }

    public static void validarCilindradas(int cilindradas) {
        if (cilindradas <= 0) {
            throw new IllegalArgumentException("Cilindradas inválidas. Informe um valor maior que zero.");
        }
    }

    public static void validarIdVeiculo(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID do veículo inválido.");
        }
    }
}
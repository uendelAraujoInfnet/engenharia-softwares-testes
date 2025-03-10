package com.uendel.exercicio_04;

import java.util.regex.Pattern;

public class CustomerService {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-.]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$");

    public boolean registerCustomer(Customer customer) {
        if (customer.getAge() < 18 || customer.getAge() > 99) {
            return false; // Idade inválida
        }
        if (!EMAIL_PATTERN.matcher(customer.getEmail()).matches()) {
            return false; // E-mail inválido
        }
        return true; // Cadastro bem-sucedido
    }

    public boolean updateCustomer(Customer customer, String newName, String newEmail, int newAge) {
        if (!customer.isActive()) {
            return false; // Cliente inativo não pode ser atualizado
        }
        customer.setName(newName);
        customer.setEmail(newEmail);
        customer.setAge(newAge);
        return true;
    }

    public boolean deleteCustomer(Customer customer) {
        return customer.isActive(); // Cliente só pode ser excluído se estiver ativo
    }
}

package com.henriqueproject.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order") // já existe uma operação order no H2 por isso que da conflito
// colocar o nome da tabela de order
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment; // a partir do Java 8 surgiu o instant que é melhor que a classe
    // Date

    //Associação com a entitidade usuário
    @ManyToOne // implementando relação no banco de dados
    // isso vai fazer o JPA criar uma chave extrangeira lá na tabela Usuário
    @JoinColumn(name = "client_id") // Aqui você passa o nome da chave estrangeira
    private User client;

    // Construtores
    public Order() {
    }
    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    // Get

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Instant getMoment(){
        return moment;
    }
    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }

// Hash code e equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

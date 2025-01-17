package com.henriqueproject.course.entities;

import com.henriqueproject.course.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId // para indicar que o método abaixo é um Id composto (ou seja Id de duas tabelas
    // unificado
    private OrderItemPK id;
    private Integer quantity;
    private Double price;


    public OrderItem() {

    }
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        // Estamos instanciando aqui o orderItem passando o pedido e o produto como argumento
        // como colocamos a classe que tem chave primaria composta OrderItemPK
        // aqui colocamos como argumento o Id de cada tabela juntada para fazer parte dessa tabela
        // é importante fazer o get e set do order e product
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    // G

    public Order getOrder() {
        return id.getOrder();
    }
    public void setOrder(Order order) {
        id.setOrder(order); // esse método jog um order(pedido lá na tabela OrderItemPK
    }
    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct(Product product) {
        id.setProduct(product); // esse método jog um produto lá na tabela OrderItemPK
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    // HashCode e equals da classe id
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

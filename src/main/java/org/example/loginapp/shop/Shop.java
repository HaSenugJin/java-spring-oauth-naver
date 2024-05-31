package org.example.loginapp.shop;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "shop_tb")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name; // 상품명
    private String price; // 상품가격
    private Integer qty; // 재고

    @Builder
    public Shop(Integer id, String name, String price, Integer qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
}
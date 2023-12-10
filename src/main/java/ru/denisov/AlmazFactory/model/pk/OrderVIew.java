package ru.denisov.AlmazFactory.model.pk;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.denisov.AlmazFactory.model.Product;

@Embeddable
@Getter
@Setter
public class OrderVIew {
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @Column(name = "count_left")
    private int countLeft;
}

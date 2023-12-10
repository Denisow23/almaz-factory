package ru.denisov.AlmazFactory.model.viewEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Immutable;
import ru.denisov.AlmazFactory.model.Product;
import ru.denisov.AlmazFactory.model.pk.OrderVIew;

@Entity(name = "orders2workers")
@Immutable
@Getter
@Setter
public class Orders2WorkerEntity {

    @EmbeddedId
    private OrderVIew orderVIew;
}

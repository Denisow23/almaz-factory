package ru.denisov.AlmazFactory.repository;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import ru.denisov.AlmazFactory.model.Supply;

import java.util.Date;

@Repository
public interface SupplyRepository extends CrudRepository<Supply, Integer> {

    @Procedure("delete_supply")
    void deleteSupply(Integer id);

    @Procedure("add_supply")
    void addMySupply(Boolean compl,
                            Integer materialId,
                            Double supplyWeight);

}

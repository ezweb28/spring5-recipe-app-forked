package guru.springframework.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptions;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String descriptions, BigDecimal amount, UnitOfMeasure uom) {
        this.descriptions = descriptions;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(String descriptions, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.descriptions = descriptions;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }

}

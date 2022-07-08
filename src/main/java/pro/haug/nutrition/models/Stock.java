package pro.haug.nutrition.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

    @Temporal(TemporalType.DATE)
    private Date bestBeforeDate;

    private double entity_count;

    private String comments;
    private BigDecimal price;
}

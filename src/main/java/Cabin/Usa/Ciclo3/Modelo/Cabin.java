package Cabin.Usa.Ciclo3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="cabin")
@Data
public class Cabin implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String name;
    private Integer rooms;
    
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("cabins")
    private Categoria category; 
    
}

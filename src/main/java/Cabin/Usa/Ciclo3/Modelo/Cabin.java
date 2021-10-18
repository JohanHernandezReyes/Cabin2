package Cabin.Usa.Ciclo3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="cabin")
@Data
public class Cabin implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 45)
    private String brand;
    @Column(length = 45)
    private String name;
    @Column(length = 250)
    private String description;
    private Integer rooms;
    
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("cabins")
    private Categoria category_id; 
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="cabin_id")
    @JsonIgnoreProperties("cabin_id")
    public List<Message> cabinsmessages;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="cabin_id")
    @JsonIgnoreProperties("cabin_id")
    public List<Reservation> cabinsreservations;
    
}

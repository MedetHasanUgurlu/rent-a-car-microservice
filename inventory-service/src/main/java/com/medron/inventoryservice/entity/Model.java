package com.medron.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @OneToMany(mappedBy = "model",cascade = CascadeType.REMOVE)
    List<Car> cars;
}

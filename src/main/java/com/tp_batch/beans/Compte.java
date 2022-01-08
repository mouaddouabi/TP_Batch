package com.tp_batch.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compte {
    @Id
    private Long idCompte;
    private double solde;
    @OneToMany(mappedBy = "compte")
    private List<Transaction> transaction;
}

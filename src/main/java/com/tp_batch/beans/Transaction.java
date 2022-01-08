package com.tp_batch.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
    @Id
    private Long idTransaction;
    private double montant;
    private Date dateTransaction;
    private Date dateDebit;
    @ManyToOne
    @JoinColumn(name = "idCompte")
    private Compte compte;

}

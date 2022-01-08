package com.tp_batch.beans;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class TransactionFile {
    @Id
    private Long idTransaction;
    private Long idCompte;
    private double montant;
    private String dateTransction;
}

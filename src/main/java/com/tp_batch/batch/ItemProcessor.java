package com.tp_batch.batch;

import com.tp_batch.beans.Compte;
import com.tp_batch.beans.Transaction;
import com.tp_batch.beans.TransactionFile;
import com.tp_batch.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class ItemProcessor  implements org.springframework.batch.item.ItemProcessor<TransactionFile, Transaction> {
    @Autowired
    CompteRepository compteRepository;
    @Override
    public Transaction process(TransactionFile transactionFile) throws Exception {

        Compte compte =compteRepository.getById(transactionFile.getIdCompte());
        compte.setSolde(compte.getSolde()-transactionFile.getMontant());
        compte = compteRepository.save(compte);
        Transaction transaction = new Transaction();
        transaction.setIdTransaction(transactionFile.getIdTransaction());
        transaction.setCompte(compte);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        transaction.setDateTransaction(dateFormat.parse(transactionFile.getDateTransction()));
        transaction.setMontant(transactionFile.getMontant());
        transaction.setDateDebit(new Date());
        return transaction;

    }
}

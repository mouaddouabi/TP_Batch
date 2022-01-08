package com.tp_batch.batch;

import com.tp_batch.beans.Transaction;
import com.tp_batch.repositories.TransactionRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer implements ItemWriter<Transaction> {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    public Writer (TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void write(List<? extends Transaction> transactions) throws Exception{
        System.out.println("Data Saved for Users: " + transactions);
        transactionRepository.saveAll(transactions);
    }
}

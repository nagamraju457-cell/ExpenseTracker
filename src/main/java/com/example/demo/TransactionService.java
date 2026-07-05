package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository repo;
	public Transaction addTransaction(Transaction tran)
	{
		return repo.save(tran);
	}
	public List<Transaction> getAll()
	{
		return repo.findAll();
	}
	public double income()
	{
		double income=0;
		List<Transaction> list=repo.findAll();
		for(Transaction t: list)
		{
			if(t.getType()== TransactionType.INCOME)
			{
				 income+=t.getAmount();
			}
		}
		return income;
	}
	public double expense()
	{
		double expense=0;
		List<Transaction>list = repo.findAll();
		for(Transaction t : list)
		{
			if(t.getType()== TransactionType.EXPENSE)
			{
				expense+=t.getAmount();
			}
		}
		return expense;
	}
	public double balance()
	{
		return income() - expense();
	}
	
	public String  delete(Long id)
	{
		if(repo.existsById(id)) {
			 repo.deleteById(id);
			 return "Transaction Deleted Successfully";
		}
		return "Transaction not Found";
		
	}
	public Transaction update(Long id,Double amount)
	{
		if(repo.existsById(id))
		{
			Optional<Transaction> opt=repo.findById(id);
			Transaction t=opt.get();
			t.setAmount(amount);
			 return repo.save(t);
		}
		return null;
	}
	public void deleteAll()
	{
		repo.deleteAll();
	}
}


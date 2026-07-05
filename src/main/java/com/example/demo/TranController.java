package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranController {
	@Autowired
	private TransactionService serv;
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	@GetMapping("/insert")
	public String  insertpage()
	{
		return "insert";
	}
	@PostMapping("/insert")
	public String insert(@ModelAttribute Transaction t)
	{
		 t.setDate(java.time.LocalDate.now());
		serv.addTransaction(t);
		return "redirect:/read";
	}
	@GetMapping("/read")
	public String read(Model model)
	{
		List<Transaction>list =serv.getAll();
		model.addAttribute("transactions",list);
		model.addAttribute("income",serv.income());
		model.addAttribute("expense",serv.expense());
		model.addAttribute("balance",serv.balance());
		return "read";
	}
	@GetMapping("/update")
		public String updatePage()
		{
			return "update";
		}
	@PostMapping("/update")
	public String update(@RequestParam Long id,@RequestParam Double amount)
	{
		serv.update(id, amount);
		return "redirect:/read";
	}
	@GetMapping("/delete")
	public String delete()
	{
		return "delete";
	}
	@PostMapping("/delete")
	public String delete(@RequestParam Long id)
	{
		serv.delete(id);
		return "redirect:/read";
	}
	@PostMapping("/deleteAll")
	public String deleteAll()
	{
		serv.deleteAll();
		return "redirect:/";
	}
	
	
	

}

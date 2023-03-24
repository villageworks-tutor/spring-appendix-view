package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.ItemView;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemViewController {

	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("items/view")
	public String index(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		
		// キーワード検索を実行
		List<ItemView> list = itemRepository.findView(keyword);
		// 商品リストをリクエストスコープに登録
		model.addAttribute("items", list);
		return "itemsView";
	}
	
}

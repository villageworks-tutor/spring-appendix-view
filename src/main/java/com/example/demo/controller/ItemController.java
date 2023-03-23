package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

import jakarta.transaction.Transactional;

/**
 * 商品表示処理に関するコントローラ
 * @author tutor
 */
@Controller
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	/**
	 * 商品一覧を表示する
	 * @return 商品一覧画面ファイル名
	 */
	@GetMapping("/items")
	public String index(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		// すべての商品のリストを取得
		List<Item> list = this.itemRepository.findByKeyword(keyword);
		// 取得した商品リストをリクエストスコープに登録
		model.addAttribute("items", list);
		// 遷移先ファイル名を返却
		return "items";
	}
	
	/**
	 * 商品登録画面を表示する
	 * @return 商品登録画面ファイル名
	 */
	@GetMapping("/items/add")
	public String addItem() {
		return "addItem";
	}
	
	/**
	 * 商品を新規登録する
	 * @param categoryId カテゴリーID
	 * @param name       商品名
	 * @param price      価格
	 * @return 商品一覧画面ファイル名
	 */
	@PostMapping("/items/add")
	@Transactional
	public String insert(
			@RequestParam("categoryId") Integer categoryId,
			@RequestParam("name") String name,
			@RequestParam("price") Integer price) {
		
		// 登録する商品をインスタンス化
		Item item = new Item(categoryId, name, price);
		// 商品の登録
		itemRepository.insert(item);
		// 商品一覧画面に戻る
		return "redirect:/items";
	}
	
}

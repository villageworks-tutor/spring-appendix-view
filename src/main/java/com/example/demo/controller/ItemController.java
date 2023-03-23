package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

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
}

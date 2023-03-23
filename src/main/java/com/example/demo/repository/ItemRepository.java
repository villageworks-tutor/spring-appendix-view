package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Item;

/**
 * itemsテーブルにアクセスするインタフェース
 * @author tutor
 */
@Repository
public interface ItemRepository {

	/**
	 * すべての商品のリストを取得する
	 * @return すべての商品を格納したリスト
	 */
	// List<Item> findAll();

	/**
	 * キーワードで商品を検索する
	 * @param keyword 検索キーワード
	 * @return きーわーどｎ
	 */
	List<Item> findByKeyword(String keyword);

	/**
	 * 商品を登録する
	 * @param item 登録する商品のインスタンス
	 */
	void insert(Item item);

}

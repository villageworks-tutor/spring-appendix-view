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
	List<Item> findAll();

}

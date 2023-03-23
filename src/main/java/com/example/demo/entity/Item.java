package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * itemsテーブルの1件分のレコードを管理するクラス
 * @author tutor
 */
@Entity
@Table(name = "items")
@Data
public class Item {

	@Id
	private Integer id;
	@Column(name = "category_id")
	private Integer categoryId;

	private String name;
	private Integer price;

	/**
	 * デフォルトコンストラクタ
	 */
	public Item() {
	}

	/**
	 * コンストラクタ
	 * @param categoryId カテゴリーID
	 * @param name       商品名
	 * @param price      価格
	 */
	public Item(Integer categoryId, String name, Integer price) {
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}

}

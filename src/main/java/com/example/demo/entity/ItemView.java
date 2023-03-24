package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "v_items")
@Data
public class ItemView {
	
	@Id
	private Integer id;
	@Column(name = "category_id")
	private Integer categoryId;
	@Column(name = "category_name")
	private String categoryName;
	private String name;
	private Integer price;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public ItemView() {
	}

	/**
	 * コンストラクタ
	 * @param id           商品ID
	 * @param categoryId   カテゴリーID
	 * @param categoryName カテゴリー名
	 * @param name         商品名
	 * @param price        価格
	 */
	public ItemView(Integer id, Integer categoryId, String categoryName, String name, Integer price) {
		this.id = id;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.name = name;
		this.price = price;
	}
	
}

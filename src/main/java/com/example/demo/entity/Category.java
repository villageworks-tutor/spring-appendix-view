package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class Category {

	@Id
	private Integer id;
	private String name;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Category() {
	}

	/**
	 * コンストラクタ
	 * @param id   カテゴリーID
	 * @param name カテゴリー名
	 */
	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
}

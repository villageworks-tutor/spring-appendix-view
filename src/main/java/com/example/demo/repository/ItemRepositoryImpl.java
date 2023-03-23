package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 * ItemRepositoryインタフェースの実装クラス
 * @author tutor
 */
@Component
public class ItemRepositoryImpl implements ItemRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Item> findAll() {
		// 実行するSQLの設定
		String sql = "SELECT * FROM items ORDER BY id";
		// SQL実行オブジェクトの取得
		Query query = entityManager.createNativeQuery(sql, Item.class);
		// SQLの実行
		@SuppressWarnings("unchecked")
		List<Item> list = query.getResultList();
		// SQLの結果を返却
		return list;
	}

}

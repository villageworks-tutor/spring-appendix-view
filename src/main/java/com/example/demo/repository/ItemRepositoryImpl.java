package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemView;

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

	@Override
	public List<Item> findByKeyword(String keyword) {
		// 実行するSQLの設定
		String sql = "SELECT * FROM items";
		if (!(keyword == null || keyword.isEmpty())) {
			// キーワードが指定されている場合
			sql += " WHERE name LIKE :name";
		}
		sql += " ORDER BY id";
		// SQL実行オブジェクトを取得
		Query query = entityManager.createNativeQuery(sql, Item.class);
		// パラメータバインディング：キーワードが指定されている場合
		if (!(keyword == null || keyword.isEmpty())) {
			query.setParameter("name", "%" + keyword + "%");
		}
		// SQLの実行
		@SuppressWarnings("unchecked")
		List<Item> list = query.getResultList();
		// SQLの結果を返却
		return list;
	}

	@Override
	public void insert(Item item) {
		// 実行するSQLの設定
		String sql = "INSERT INTO items (category_id, name, price) VALUES (:categoryId, :name, :price)";
		// SQL実行オブジェクトの取得
		Query query = entityManager.createNativeQuery(sql, Item.class);
		// パラメータバインディング
		query.setParameter("categoryId", item.getCategoryId());
		query.setParameter("name", item.getName());
		query.setParameter("price", item.getPrice());
		// SQLの実行
		query.executeUpdate();
	}

	@Override
	public List<ItemView> findView(String keyword) {
		// 実行するSQLの設定
		String sql = "SELECT * FROM v_items";
		if (!(keyword == null || keyword.isEmpty())) {
			// キーワードが指定されている場合
			sql += " WHERE name LIKE :name";
		}
		sql += " ORDER BY id";
		// SQL実行オブジェクトの取得
		Query query = entityManager.createNativeQuery(sql, ItemView.class);
		// パラメータバインディング
		if (!(keyword == null || keyword.isEmpty())) {
			query.setParameter("name", "%" + keyword + "%");
		}
		// SQLの実行
		@SuppressWarnings("unchecked")
		List<ItemView> list = query.getResultList();
		// SQLの結果を返却
		return list;
	}

}

-- 各種テーブル削除
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS items CASCADE;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS order_details CASCADE;

-- カテゴリーテーブル
CREATE TABLE categories (
	id   SERIAL PRIMARY KEY,
	name TEXT
);
-- 商品テーブル
CREATE TABLE items (
	id          SERIAL PRIMARY KEY,
	category_id INTEGER,
	name        TEXT,
	price       INTEGER
);
-- 顧客テーブル
CREATE TABLE customers (
	id      SERIAL PRIMARY KEY,
	name    TEXT,
	address TEXT,
	tel     TEXT,
	email   TEXT
);
-- 注文テーブル
CREATE TABLE orders (
	id          SERIAL PRIMARY KEY,
	customer_id INTEGER,
	ordered_on  DATE,
	total_price INTEGER
);
-- 注文明細テーブル
CREATE TABLE order_details (
	id       SERIAL PRIMARY KEY,
	order_id INTEGER,
	item_id  INTEGER,
	quantity INTEGER
);

-- 商品一覧view
CREATE VIEW v_items AS (
  SELECT
    items.id, 
    categories.id AS category_id, 
    categories.name AS category_name, 
    items.name, 
    items.price
  FROM items
  INNER JOIN categories ON categories.id = items.category_id
);

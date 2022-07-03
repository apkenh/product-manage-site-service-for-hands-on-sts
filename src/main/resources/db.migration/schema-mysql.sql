CREATE TABLE tbl_user_mst (
	user_seq INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_account VARCHAR(20) NOT NULL UNIQUE,
    user_encoded_password VARCHAR(128) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    user_locale VARCHAR(30) NOT NULL,
    user_timezone VARCHAR(30) NOT NULL,
    user_timezone_offset VARCHAR(5) NOT NULL,
    user_currency VARCHAR(3) NOT NULL,
    user_sub_menu_role VARCHAR(10) NOT NULL,
    user_token VARCHAR(1024) NOT NULL DEFAULT '',
    enter_date DATETIME NOT NULL,
    enter_user VARCHAR(50) NOT NULL,
    update_date DATETIME NOT NULL,
    update_user VARCHAR(50) NOT NULL,
    CONSTRAINT tbl_user_mst_pk PRIMARY KEY (user_seq)
);

CREATE TABLE tbl_product_mst (
	product_seq INT UNSIGNED NOT NULL AUTO_INCREMENT,
    product_code VARCHAR(20) UNIQUE,
    product_name VARCHAR(50),
    product_genre VARCHAR(20),
    product_size_standard VARCHAR(50),
    product_color VARCHAR(20),
    product_unit_price DECIMAL(11,3),
    end_of_sale BOOLEAN,
    end_of_sale_date DATETIME,
    enter_date DATETIME NOT NULL,
    enter_user VARCHAR(50) NOT NULL,
    update_date DATETIME NOT NULL,
    update_user VARCHAR(50) NOT NULL,
    CONSTRAINT tbl_product_mst_pk PRIMARY KEY (product_seq)
);

CREATE TABLE tbl_product_stock_mst (
	product_stock_seq INT UNSIGNED NOT NULL AUTO_INCREMENT,
    product_seq INT UNSIGNED NOT NULL UNIQUE,
    product_stock_quantity DECIMAL(9,0) NOT NULL,
    enter_date DATETIME NOT NULL,
    enter_user VARCHAR(50) NOT NULL,
    update_date DATETIME NOT NULL,
    update_user VARCHAR(50) NOT NULL,
    CONSTRAINT tbl_product_stock_mst_pk PRIMARY KEY (product_stock_seq)
);

CREATE TABLE tbl_product_purchase (
	product_purchase_seq INT UNSIGNED NOT NULL AUTO_INCREMENT,
    product_seq INT UNSIGNED NOT NULL,
    product_purchase_date DATETIME NOT NULL,
    product_purchase_name VARCHAR(50) NOT NULL,
    product_purchase_unit_price DECIMAL(11,3) NOT NULL,
    product_purchase_quantity DECIMAL(9,0) NOT NULL,
    product_purchase_amount DECIMAL(11,3) NOT NULL,
    enter_date DATETIME NOT NULL,
    enter_user VARCHAR(50) NOT NULL,
    update_date DATETIME NOT NULL,
    update_user VARCHAR(50) NOT NULL,
    CONSTRAINT tbl_product_purchase_pk PRIMARY KEY (product_purchase_seq)
);

CREATE TABLE tbl_page_role_mst (
	page_role_seq INT UNSIGNED NOT NULL AUTO_INCREMENT,
    page_code VARCHAR(30) NOT NULL,
    page_role VARCHAR(10) NOT NULL,
    menu_display BOOLEAN NOT NULL,
    menu_seq INT UNSIGNED,
    menu_order SMALLINT,
    enter_date DATETIME NOT NULL,
    enter_user VARCHAR(50) NOT NULL,
    update_date DATETIME NOT NULL,
    update_user VARCHAR(50) NOT NULL,
    CONSTRAINT tbl_page_role_mst_pk PRIMARY KEY (page_role_seq)
);


CREATE TABLE tbl_menu_mst (
	menu_seq INT UNSIGNED NOT NULL AUTO_INCREMENT,
    menu_code VARCHAR(10) NOT NULL,
    menu_order SMALLINT NOT NULL,
    enter_date DATETIME NOT NULL,
    enter_user VARCHAR(50) NOT NULL,
    update_date DATETIME NOT NULL,
    update_user VARCHAR(50) NOT NULL,
    CONSTRAINT tbl_menu_mst_pk PRIMARY KEY (menu_seq)
);

ALTER TABLE tbl_product_purchase
	ADD CONSTRAINT tbl_product_purchase_fk FOREIGN KEY (product_seq) REFERENCES tbl_product_mst(product_seq)
	ON DELETE CASCADE;

ALTER TABLE tbl_product_stock_mst
	ADD CONSTRAINT tbl_product_stock_mst_fk FOREIGN KEY (product_seq) REFERENCES tbl_product_mst(product_seq)
	ON DELETE CASCADE;

ALTER TABLE tbl_page_role_mst
	ADD CONSTRAINT tbl_page_role_mst_fk FOREIGN KEY (menu_seq) REFERENCES tbl_menu_mst(menu_seq)
	ON DELETE CASCADE;

CREATE TABLE tbl_spring_session (
	primary_id CHAR(36) NOT NULL,
	session_id CHAR(36) NOT NULL,
	creation_time BIGINT NOT NULL,
	last_access_time BIGINT NOT NULL,
	max_inactive_interval INT NOT NULL,
	expiry_time BIGINT NOT NULL,
	principal_name VARCHAR(100),
	CONSTRAINT tbl_spring_session_pk PRIMARY KEY (primary_id)
);

CREATE UNIQUE INDEX idx_spring_session_1 on tbl_spring_session (session_id);
CREATE INDEX idx_spring_session_2 on tbl_spring_session (expiry_time);
CREATE INDEX idx_spring_session_3 on tbl_spring_session (principal_name);

CREATE TABLE tbl_spring_session_attributes (
	session_primary_id CHAR(36) NOT NULL,
	attribute_name VARCHAR(200) NOT NULL,
	attribute_bytes BLOB NOT NULL,
	CONSTRAINT tbl_spring_session_attributes_pk PRIMARY KEY (session_primary_id, attribute_name),
	CONSTRAINT tbl_spring_session_attributes_fk FOREIGN KEY (session_primary_id) REFERENCES tbl_spring_session(primary_id) ON DELETE CASCADE
);


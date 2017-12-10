CREATE TABLE "Countries" (
	"id" SERIAL PRIMARY KEY,
	"name" VARCHAR NOT NULL,
	"code" INTEGER NOT NULL
);

CREATE TABLE "Cities" (
	"id" SERIAL PRIMARY KEY,
	"name" VARCHAR NOT NULL,
	"code" INTEGER NOT NULL,
	"country_id" INTEGER,
	CONSTRAINT "Cities_country_id_fk" FOREIGN KEY ("country_id")
		REFERENCES "Countries" ("id") MATCH SIMPLE
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE "Roles" (
	"id" SERIAL PRIMARY KEY,
	"role_name" VARCHAR NOT NULL
);

CREATE TABLE "Users" (
	"id" SERIAL PRIMARY KEY,
	"first_name" VARCHAR,
	"last_name" VARCHAR,
	"user_name" VARCHAR,
	"password" VARCHAR,
	"address" VARCHAR(100),
	"phone_number" VARCHAR(12),
	"role_id" INTEGER NOT NULL,
	"city_id" INTEGER NOT NULL,
	"birthday" DATE,
	CONSTRAINT "Users_role_id_fk" FOREIGN KEY ("role_id")
		REFERENCES "Roles" ("id") MATCH SIMPLE
		ON UPDATE SET NULL
		ON DELETE SET NULL,
	CONSTRAINT "Users_city_id_fk" FOREIGN KEY ("city_id")
		REFERENCES "Cities" ("id") MATCH SIMPLE
		ON UPDATE CASCADE
		ON DELETE SET NULL
);

CREATE TABLE "Products" (
	"id" SERIAL PRIMARY KEY,
	"name" VARCHAR NOT NULL,
	"unit_price" INTEGER NOT NULL,
	"detail" VARCHAR(150)
);

CREATE TABLE "Stocks" (
	"id" SERIAL PRIMARY KEY,
	"name" VARCHAR,
	"product_id" INTEGER NOT NULL,
	"quantity" INTEGER DEFAULT 0,
	"unit_price" INTEGER NOT NULL,
	CONSTRAINT "Stocks_product_id_fk" FOREIGN KEY ("product_id")
		REFERENCES "Products" ("id") MATCH SIMPLE
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE "Products_In_Stock" (
	"stock_id" INTEGER,
	"serial" SERIAL,
	CONSTRAINT "Products_In_Stock_stock_id_fk" FOREIGN KEY ("stock_id")
		REFERENCES "Stocks" ("id") MATCH SIMPLE
		ON UPDATE CASCADE
		ON DELETE CASCADE
) INHERITS ("Products");
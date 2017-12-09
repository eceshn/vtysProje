CREATE TABLE "Cities" (
	"id" SERIAL PRIMARY KEY,
	"name" VARCHAR NOT NULL,
	"code" INTEGER NOT NULL,
	"countryId" INTEGER,
	CONSTRAINT "Cities_countryId_fk" FOREIGN KEY ("countryId")
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
	"role" INTEGER NOT NULL,
	"cityId" INTEGER NOT NULL,
	CONSTRAINT "Users_role_fk" FOREIGN KEY ("role")
		REFERENCES "Roles" ("id") MATCH SIMPLE
		ON UPDATE SET NULL
		ON DELETE SET NULL,
	CONSTRAINT "Users_cityId_fk" FOREIGN KEY ("cityId")
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

CREATE TABLE "Products_In_Stock" (
	"id" SERIAL PRIMARY KEY,
	"productId" INTEGER NOT NULL,
	"serial_number" SERIAL NOT NULL,
	"defective_status" BOOLEAN,
	CONSTRAINT "Products_In_Stock_productId_fk" FOREIGN KEY ("productId")
		REFERENCES "Products" ("id") MATCH SIMPLE
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE "Stocks" (
	"id" SERIAL PRIMARY KEY,
	"name" VARCHAR,
	"productId" INTEGER NOT NULL,
	"quantity" INTEGER DEFAULT 0,
	"unit_price" INTEGER NOT NULL,
	CONSTRAINT "Stocks_productId_fk" FOREIGN KEY ("productId")
		REFERENCES "Products_In_Stock" ("id") MATCH SIMPLE
		ON UPDATE CASCADE
		ON DELETE CASCADE
);
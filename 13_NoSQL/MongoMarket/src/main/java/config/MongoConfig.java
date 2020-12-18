package config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.Document;


import java.util.*;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Updates.*;
import static com.mongodb.client.model.Accumulators.*;


public class MongoConfig {

    private MongoCollection<Document> collectionShop;
    private MongoCollection<Document> collectionProduct;

    public void init() {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("local");
        collectionShop = database.getCollection("Shop");
        collectionProduct = database.getCollection("Product");

        collectionShop.drop();
        collectionProduct.drop();
    }

    public String addShop(String commandNewShop) {
        String[] commands = commandNewShop.split(" ");
        if (commands.length != 2) {
            System.out.println("Неправильный ввод магазина");
        } else {
            List<String> products = new ArrayList<>();
            Document document = new Document().append("name", commands[1]).append("products", products);
            collectionShop.insertOne(document);
        }
        return (String) collectionShop.find(eq("name", commands[1])).first().get("name");
    }

    public String addProduct(String commandNewProduct) {
        String[] commands = commandNewProduct.split(" ");
        if (commands.length != 3) {
            System.out.println("Неправильный ввод товара");
        } else {
            Document document = new Document().append("name", commands[1]).append("price", Integer.valueOf(commands[2]));
            collectionProduct.insertOne(document);

        }
        return (String) collectionProduct.find(eq("name", commands[1])).first().get("name");
    }

    public String displayProduct(String commandDisplayProduct) {
        String[] commands = commandDisplayProduct.split(" ");
        if (commands.length != 3) {
            System.out.println("Неправильная команда");
        } else {
            Document documentProduct = collectionProduct.find(eq("name", commands[1])).first();
            Document found = collectionShop.find(eq("name", commands[2])).first();
            if (documentProduct != null && found != null) {
                List<String> productList = (List<String>) found.get("products");
                productList.add(documentProduct.getString("name"));
                collectionShop.updateOne(collectionShop.find(eq("name", commands[2])).first(),
                        set("products", found.get("products")));
                Document document = collectionShop.find(eq("name", commands[2])).first();
                System.out.println("Товар " + documentProduct.get("name") + " выставлен в магазине " + document.get("name"));
            }
        }
        return "Неправильная команда";
    }

    public StringBuilder productStatistics() {
        StringBuilder builder = new StringBuilder();
        collectionShop.find().forEach((Consumer<Document>) document -> {
            List<String> productsInShopList = (List<String>) document.get("products");
            if (productsInShopList.size() > 0) {
                collectionShop.aggregate(
                        Arrays.asList(
                                lookup("Product", "products", "name", "prod_name"),
                                unwind("$prod_name"),
                                addFields(new Field("newField",
                                        new Document("$cond",
                                                new Document("if",
                                                        new Document("$gte", Arrays.asList
                                                                ("$prod_name.price", 100)))
                                                        .append("then", 0)
                                                        .append("else", 1)))),
                                group("$name", sum("count", 1),
                                        Accumulators.max("maxPrice", "$prod_name.price"),
                                        Accumulators.min("minPrice", "$prod_name.price"),
                                        Accumulators.avg("averagePrice", "$prod_name.price"),
                                        sum("countLess100", "$newField")
                                )
                        )
                ).forEach((Consumer<Document>) doc -> {
                    builder.append("Название магазина: " + doc.get("_id") + "\n")
                            .append("Общее количество товаров: " + doc.get("count") + "\n")
                            .append("Средняя цена товаров: " + doc.get("averagePrice") + "\n")
                            .append("Самый дорогой товар: " + doc.get("maxPrice") + "\n")
                            .append("Самый дешёвый товар: " + doc.get("minPrice") + "\n")
                            .append("Количество товаров дешевле 100 рублей: " + doc.get("countLess100") + "\n");
                });
            } else {
                builder.append("В магазине " + document.get("name") + " товаров не выставлено" + "\n");
            }
        });
        return builder;
    }
}
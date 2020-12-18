package service;

import config.MongoConfig;

public class ProductStatistics implements Command {

    @Override
    public String getCommand() {
        return "СТАТИСТИКА_ТОВАРОВ";
    }

    @Override
    public void parseCommand(String command, MongoConfig mongoConfig) {
        System.out.println(mongoConfig.productStatistics());
    }
}
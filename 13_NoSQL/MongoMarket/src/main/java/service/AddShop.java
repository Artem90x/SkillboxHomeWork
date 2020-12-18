package service;

import config.MongoConfig;

public class AddShop implements Command {

    @Override
    public String getCommand() {
        return "ДОБАВИТЬ_МАГАЗИН";
    }

    @Override
    public void parseCommand(String command, MongoConfig mongoConfig) {
        mongoConfig.addShop(command);
    }
}
package service;

import config.MongoConfig;

public class DisplayProduct implements Command {

    @Override
    public String getCommand() {
        return "ВЫСТАВИТЬ_ТОВАР";
    }

    @Override
    public void parseCommand(String command, MongoConfig mongoConfig) {
        mongoConfig.displayProduct(command);
    }
}
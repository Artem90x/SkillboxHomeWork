package service;
import config.MongoConfig;


public class AddProduct implements Command {

    @Override
    public String getCommand() {
        return "ДОБАВИТЬ_ТОВАР";
    }

    @Override
    public void parseCommand(String command, MongoConfig mongoConfig) {
        mongoConfig.addProduct(command);
    }
}
package service;

import config.MongoConfig;

public interface Command {

    String getCommand();

    void parseCommand(String command, MongoConfig mongoConfig);
}


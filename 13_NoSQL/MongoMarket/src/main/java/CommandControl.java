import config.MongoConfig;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CommandControl {

    private final MongoConfig mongoConfig = new MongoConfig();
    private final List<Command> commandList = new ArrayList<>();

    public CommandControl() {
        mongoConfig.init();

        commandList.add(new AddShop());
        commandList.add(new AddProduct());
        commandList.add(new DisplayProduct());
        commandList.add(new ProductStatistics());
    }

    public void execute(String command) {
        String[] commands = command.split(" ");
        AtomicInteger i = new AtomicInteger();
        commandList.forEach(com -> {
            if (commands[0].equals(com.getCommand())) {
                com.parseCommand(command, mongoConfig);
            } else i.getAndIncrement();
        });
        if (i.get() == commandList.size()) {
            System.out.println("Неправильная команда");
        }
    }
}


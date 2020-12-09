import org.redisson.Redisson;
import org.redisson.api.RDeque;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Random;

public class RedisStorage {

    public static final int USERS_AMOUNT = 20;

    private RedissonClient redissonClient;
    private RDeque<Integer> registeredUsersIds;

    private static final Random RANDOM = new Random();

    public void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        try {
            redissonClient = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            System.out.println("Failed to connect to Redis");
            System.out.println(Exc.getMessage());
        }
        registeredUsersIds = redissonClient.getDeque("users");
    }


    public void initData() {
        for (int i = 0; i < USERS_AMOUNT; i++) {
            registeredUsersIds.add(i);
        }
    }

    public void addLast(int userId) {
        registeredUsersIds.addLast(userId);
    }

    public void pushUser(int userId) {
        registeredUsersIds.push(userId);
    }

    public Integer peekFirstUser() {
        return registeredUsersIds.peekFirst();
    }

    public Integer removeFirstUser() {
        return registeredUsersIds.removeFirst();
    }

    public Integer getRandom() {
        return RANDOM.nextInt(RedisStorage.USERS_AMOUNT) + 1;
    }
}
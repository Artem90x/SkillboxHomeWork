public class Main {

    public static void main(String[] args) {

        RedisStorage rs = new RedisStorage();
        rs.init();
        rs.initData();
        try {
            while (true) {
                for (int i = 1; i <= RedisStorage.USERS_AMOUNT; i++) {
                    System.out.println("На главной странице показываем пользователя " + rs.peekFirstUser());
                    rs.addLast(rs.removeFirstUser());
                    if (i % rs.getRandom() == 0) {
                        System.out.println("Пользователь " + i + " оплатил платную услугу");
                        rs.pushUser(i);
                    }
                }
                System.out.println("");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package example.option_java8_test;

import java.util.Optional;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/3/7 16:21
 */
public class OptionTest {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(11);
        //不会报空指针
        User user1 = Optional.ofNullable(user).get();
        System.out.println(user1);
    }

    static class User{
        private  String name;
        private  int age;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}


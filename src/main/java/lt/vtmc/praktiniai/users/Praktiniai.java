package lt.vtmc.praktiniai.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Praktiniai {

    List<User> users = new ArrayList<>();

    public static Integer countUsersOlderThen25(List<User> users) {
//        Integer countUsersOlderThen25 = 0;
//        for (User user : users) {
//            if(user.getAge()> 25){
//                countUsersOlderThen25++;
//            }
//        }
//        return countUsersOlderThen25;
        return (int) users.stream().filter(u -> u.getAge() > 25).count();
    }

    public static double getAverageAge(List<User> users) {
//        double totalAge = 0.0;
//        for (User user : users) {
//               totalAge += user.getAge();
//            }
//        return totalAge/users.size();
        return users.stream().mapToDouble(User::getAge).average().orElse(0);
    }

    public static Integer getMinAge(List<User> users) {
//        Integer minAge = users.get(0).getAge();
//        for (User user : users) {
//            if( minAge > user.getAge()){
//            minAge = user.getAge();
//        }
//        }
//        return minAge;

        return users.stream().min(Comparator.comparing(User::getAge)).get().getAge();
    }

    public static User findByName(List<User> users, String name) {
//        for (User user : users) {
//            if(user.getName().equals(name)){
//                return user;
//            }
//        }
//        return null;
        return users.stream().filter(u -> u.getName().equals(name)).findAny().get();
    }

    public static List<User> sortByAge(List<User> users) {
//        Collections.sort(users, new UserAgeComparator());
//       return users;
        return users.stream().sorted((u1, u2) -> u1.getAge().compareTo(u2.getAge())).toList();
    }

    public static User findOldest(List<User> users) {
//        Integer maxAge = users.get(0).getAge();
//        User oldestUser = users.get(0);
//        for (User user : users) {
//            if( maxAge < user.getAge()){
//                maxAge = user.getAge();
//                oldestUser = user;
//            }
//        }
//        return oldestUser;
        return users.stream().max(Comparator.comparing(User::getAge)).get();
    }

    public static int sumAge(List<User> users) {
//        int totalAge = 0;
//        for (User user : users) {
//            totalAge += user.getAge();
//        }
//        return totalAge;
//    }
        return users.stream().mapToInt(User::getAge).sum();
    }
}

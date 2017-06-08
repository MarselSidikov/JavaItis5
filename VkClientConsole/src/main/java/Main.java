import ru.itis.vk.api.VkApi;
import ru.itis.vk.api.models.Friend;

import java.util.List;

import static ru.itis.vk.api.builders.VkApiBuilder.buildRestTemplate;
public class Main {
    public static void main(String[] args) {
        VkApi vkApi = buildRestTemplate();
        List<Friend> friends = vkApi.getUserFriends(2, 10,"city","photo_200_orig","sex");
        friends.forEach(System.out::println);
    }
}

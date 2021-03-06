package ru.itis.main;

import ru.itis.main.context.AppContext;
import ru.itis.main.models.User;
import ru.itis.main.services.UsersService;

public class Main {

    public static void main(String[] args) {
        /*
        IdGenerator idGenerator = SimpleIdGenerator.getGenerator();
        FileDaoQueryTemplate template = new FileDaoQueryTemplateImpl(idGenerator);
        UsersDao usersDao = new UsersDaoFileBasedImpl("users.txt", template);
        UsersService service = new UsersServiceImpl(usersDao);
        */
        AppContext appContext = new AppContext();
        UsersService service = appContext.getComponent(UsersService.class);
        System.out.println(service.isRegistered("RobertKnyzev"));
        service.register(new User("Robert", "aspirin12", "RobertKnyazev", 16));
        System.out.println(service.isRegistered("RobertKnyazev"));
    }
}

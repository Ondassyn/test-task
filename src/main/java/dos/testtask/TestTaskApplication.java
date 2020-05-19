package dos.testtask;

import dos.testtask.models.Merlin;
import dos.testtask.repositories.MerlinRepository;
import dos.testtask.services.TaskService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestTaskApplication implements CommandLineRunner {

    private TaskService taskService;
    private MerlinRepository repository;

    public TestTaskApplication(TaskService taskService, MerlinRepository repository) {
        this.taskService = taskService;
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestTaskApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        String url = "https://api.spacexdata.com/v3/cores/Merlin2A";
        if(args.length > 0)
            url = args[0];

        Merlin merlin = taskService.parseToObject(url);
        repository.save(merlin);

        System.out.println("Merlins found with findAll():");
        System.out.println("-------------------------------");
        for (Merlin m : repository.findAll()) {
            System.out.println(m.toString());
        }
    }
}

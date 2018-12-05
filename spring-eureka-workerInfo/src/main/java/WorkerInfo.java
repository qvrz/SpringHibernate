import com.example.eureka.springeurekaclientWorker.domain.Errand;
import com.example.eureka.springeurekaclientWorker.domain.ErrandRepository;
import com.example.eureka.springeurekaclientWorker.domain.Worker;
import com.example.eureka.springeurekaclientWorker.domain.WorkerRepository;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@ComponentScan("com.example.eureka")
public class WorkerInfo{
    private EurekaClient eurekaClient;
    private WorkerRepository workerRepository;
    private ErrandRepository errandRepository;

        public static void main(String[] args) {
            SpringApplication.run(WorkerInfo.class, args);
        }
    @Autowired
    public WorkerInfo(WorkerRepository workerRepository, ErrandRepository errandRepository) {
        this.workerRepository = workerRepository;
        this.errandRepository = errandRepository;
    }
    @GetMapping("/getDeskNumber/{id}")
    public String getDesk(@PathVariable long id)
    {
        Optional<Worker> user = workerRepository.findById(id);
        if (user.isPresent()) {
            Worker w=user.get();
            return "User with id "+id+ " has desk number "+w.getDeskNr();
        }
        return "No user with id "+id;
    }
    @GetMapping("{uid}/signErrand/{eid}")
    public String signErrand(@PathVariable long uid,@PathVariable long eid)
    {
        Optional<Worker> user= workerRepository.findById(uid);
        Optional<Errand> errand= errandRepository.findById(eid);
        if(user.isPresent() && errand.isPresent())
        {
            Errand e=errand.get();
            e.setWorker(user.get());
            errandRepository.save(e);
            return "Added errand with id "+eid+" to worker with id "+uid;
        }
     return "Invalid request";
    }

}

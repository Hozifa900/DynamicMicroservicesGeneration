package com.miu.eventtrackerapi;

import com.miu.eventtrackerapi.entities.DataApi;
import com.miu.eventtrackerapi.entities.Message;
import com.miu.eventtrackerapi.entities.Service;
//import com.miu.eventtrackerapi.repositories.DataApiRepository;
import com.miu.eventtrackerapi.repositories.MessageRepository;
import com.miu.eventtrackerapi.repositories.ServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {

//    private final DataApiRepository dataApiRepository;
    private final ServiceRepository serviceRepository;
    private final MessageRepository messageRepository;

    public DataSeeder(
                      ServiceRepository serviceRepository,
                      MessageRepository messageRepository) {
//        this.dataApiRepository = dataApiRepository;
        this.serviceRepository = serviceRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... args) {
//        seedApiList();
        seedServiceList();
    }

    private void addMessagesToService(Service service) {
        for(int i=0; i< 10; i++) {
            var message = new Message();
            message.setText("["+service.getName()+"] : generic service message at " + LocalDateTime.now());
            message.setService(service);
            messageRepository.save(message);
        }
    }

    private void seedServiceList() {
        var service = new Service();
        service.setName("WDFS");
        service.setMessageCount(45L);
        service.setLastMessage("Recieved : generic message");
        service.setLastMessageDate(LocalDateTime.of(2023,10,19,13,34));
        serviceRepository.save(service);
        addMessagesToService(service);

        service = new Service();
        service.setName("ACS");
        service.setMessageCount(23L);
        service.setLastMessage("Recieved : generic message");
        service.setLastMessageDate(LocalDateTime.of(2023,9,12,13,23));
        serviceRepository.save(service);
        addMessagesToService(service);

        service = new Service();
        service.setName("CSS");
        service.setMessageCount(23L);
        service.setLastMessage("Recieved : generic message");
        service.setLastMessageDate(LocalDateTime.of(2023,10,13,8,9));
        serviceRepository.save(service);
        addMessagesToService(service);

        service = new Service();
        service.setName("DSGS");
        service.setMessageCount(32L);
        service.setLastMessage("Recieved : generic message");
        service.setLastMessageDate(LocalDateTime.of(2023,10,22,16,11));
        serviceRepository.save(service);
        addMessagesToService(service);
    }

//    private void seedApiList() {
//        var api = new DataApi();
//        api.setUrl("https://localhost:8080/api/cpu");
//        api.setName("CPU source");
//        dataApiRepository.save(api);
//
//        api = new DataApi();
//        api.setUrl("https://localhost:8080/api/ram");
//        api.setName("RAM source");
//        dataApiRepository.save(api);
//
//        api = new DataApi();
//        api.setUrl("https://localhost:8080/api/storage");
//        api.setName("Storage source");
//        dataApiRepository.save(api);
//    }
}


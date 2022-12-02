package io.vgrente.callmeservice.controller;

import io.vgrente.callmeservice.model.Callme;
import io.vgrente.callmeservice.repository.CallmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
@RequestMapping("/callme")
public class CallmeController {

    @Value("${spring.application.name}")
    private String appName;
    @Value("${POD_NAME:pod-name}")
    private String podName;
    @Value("${POD_NAMESPACE:pod-namespace}")
    private String podNamespace;
    @Autowired
    private CallmeRepository repository;
    @Autowired(required = false)
    BuildProperties buildProperties;

    @GetMapping("/ping")
    public String ping() {
        Callme c = repository.save(new Callme(new Date(), podName,
                buildProperties != null ? buildProperties.getVersion() : null));
        return appName +
                " v" + c.getVersion() +
                " (id=" + c.getId() + "): " +
                podName +
                " in " + podNamespace;
    }

    @GetMapping("/")
    public String root() {
        return "Callme Service";
    }
}

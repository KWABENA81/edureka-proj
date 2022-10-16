package com.sas.studentmsclient.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentClientResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentClientResource.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/students-client/{id}")
    public Object getStudentsFGromStudentms(@PathVariable String id) {
        LOGGER.info("About to call studentms");
        return restTemplate.getForObject("http://studentms/students" + id, Object.class);
    }
}

package com.example.demo;



import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.dto.EmployeeDTO;


@SpringBootApplication
public class SalaryApplicationBackendApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SalaryApplicationBackendApplication.class, args);

}
}
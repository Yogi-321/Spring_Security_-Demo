package com.example.HibernateDemo.Controller;

import com.example.HibernateDemo.Dao.EmployeeDao;
import com.example.HibernateDemo.Entity.Employee;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/employee")
public class Employeecontroller {

    @Autowired
    EmployeeDao employeeDao;

    @Value("${fileDir}")
    String dir;

    @PostMapping("/newemployee")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addNewEmployee(@RequestBody Employee employee)
    {
        employeeDao.addNewEmployee(employee);
        return  new ResponseEntity<>("Employee Add Succesfully", HttpStatus.CREATED);

    }


    @GetMapping("/viewemployees")
    @PreAuthorize("hasRole('NORMAL')")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee> allEmployee = employeeDao.getAllEmployee();
        return new ResponseEntity<>(allEmployee,HttpStatus.OK);
    }

    @PostMapping(value = "/readFile")
    public void readCsv() throws IOException, CsvValidationException {
        FileReader fileReader= new FileReader(dir);
        System.out.println(dir);
        CSVReader csvReader= new CSVReader(fileReader);
        String[] value=null;
//        while((value=csvReader.readNext())!=null)
//        {
//            System.out.println(Arrays.asList(value));
//        }
        Pattern pattern=Pattern.compile(","+"yo");
        value=csvReader.readNext();
        for(String s:value)
        {
            System.out.println(s);


        }



    }









}

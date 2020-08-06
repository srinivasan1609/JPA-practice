package com.project.demo.controller;

import com.project.demo.entity.JpaEntity;
import com.project.demo.exceptions.InvalidParamException;
import com.project.demo.model.JpaModel;
import com.project.demo.service.JpaService;
import com.project.demo.service.S3BucketUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@RestController
public class JpaGetController {

    @Autowired
    JpaService jpaService;

    @Autowired
    S3BucketUploadService s3BucketUploadService;

    @RequestMapping(value = "/get/{id}", method= RequestMethod.GET)
    public String getMethod(@PathVariable("id") int id){
        return jpaService.getById(id).getName();
    }

    @RequestMapping(value = "/getByName/{name}", method= RequestMethod.GET)
    public JpaEntity getByNameMethod(@PathVariable("name") String name){
        return jpaService.getByName(name);
    }

    @RequestMapping(value = "/findOrderByNameAsc", method= RequestMethod.GET)
    public List<JpaEntity> findOrderByNameAsc(){
        return jpaService.getOrderByNameAsc();
    }

    @RequestMapping(value = "/findByNameContains/{name}", method= RequestMethod.GET)
    public List<JpaEntity> findOrderByNameAsc(@PathVariable("name") String name){
        return jpaService.getByNameContains(name);
    }

    @RequestMapping(value = "/findAllLimit/", method= RequestMethod.GET)
    public List<JpaEntity> findAllLimit(){
        return jpaService.getLimit();
    }

    @RequestMapping(value = "/findAllPage/{from}/{limit}", method= RequestMethod.GET)
    public Page<JpaEntity> findAllPage(@PathVariable("from") int from,@PathVariable("limit") int limit){
        return jpaService.getAllPagable(from,limit);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody JpaModel jpaModel){
        Validator validator = Validation.buildDefaultValidatorFactory()
                .getValidator();
        Set<ConstraintViolation<JpaModel>> violations =validator.validate(jpaModel);
        if(!violations.isEmpty()){
            System.out.println(violations.iterator().next().getMessage());
            throw new InvalidParamException(violations.iterator().next().getMessage());
        }
        return ResponseEntity.ok(jpaService.insertTable(jpaModel));
    }
    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file){
        s3BucketUploadService.uploadFile(file);
    }

    @DeleteMapping("/delete")
    public void deleteFile(@RequestParam("url") String url){
        s3BucketUploadService.deleteFile(url);
    }

}

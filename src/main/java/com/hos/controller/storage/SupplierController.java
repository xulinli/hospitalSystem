package com.hos.controller.storage;

import com.github.pagehelper.PageInfo;
import com.hos.entity.Supplier;
import com.hos.service.storage.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xu
 * @date 19/10/28-8:59
 */
@RestController
@RequestMapping("supp")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public Integer addSupplier(@RequestBody Map<String,Object> params){
        return supplierService.add(params);
    }

    @GetMapping
    public PageInfo<Supplier> querySupplier(@RequestParam Map<String,Object> params){
        System.out.println(params);
        return supplierService.query(params);
    }

    @PutMapping
    public Integer editSupplier(@RequestBody Map<String,Object> params){
        return supplierService.update(params);
    }

    @DeleteMapping
    public Integer deleteSupplier(@RequestParam Map<String,Object> params){
        return supplierService.delete(params);
    }

}

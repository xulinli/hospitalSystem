package com.hos.controller.storage;

import com.github.pagehelper.PageInfo;
import com.hos.entity.Drug;
import com.hos.entity.Supplier;
import com.hos.service.storage.DrugService;
import com.hos.service.storage.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xu
 * @date 19/10/28-15:57
 */
@RestController
@RequestMapping("drug")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @PostMapping
    public Integer addSupplier(@RequestBody Map<String,Object> params){
        return drugService.add(params);
    }

    @GetMapping
    public PageInfo<Drug> querySupplier(@RequestParam Map<String,Object> params){
        return drugService.query(params);
    }

    @PutMapping
    public Integer editSupplier(@RequestBody Map<String,Object> params){
        return drugService.update(params);
    }

    @DeleteMapping
    public Integer deleteSupplier(@RequestParam Map<String,Object> params){
        return drugService.delete(params);
    }
}

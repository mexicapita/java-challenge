package com.intelygenz.controller;

import com.intelygenz.service.SortNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SortNumbersController {

    @Autowired
    private SortNumbersService sortNumbersService;

    @GetMapping("/api/getNumbersSorted")
    public ResponseEntity<List<List<Integer>>> getNumbersSorted() {

        return ResponseEntity.ok(sortNumbersService.getSortedNumbers());
    }
}

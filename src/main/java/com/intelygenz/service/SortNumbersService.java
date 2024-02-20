package com.intelygenz.service;

import com.intelygenz.model.Numbers;
import com.intelygenz.repository.NumbersRepository;
import com.intelygenz.service.BinaryOnesComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortNumbersService {

    @Autowired
    private NumbersRepository numbersRepository;

    public List<List<Integer>> getSortedNumbers(){
        List<Numbers> numbers = numbersRepository.findAll();
        return numbers.stream()
                .map(number -> sortByBinaryOnes(number))
                .collect(Collectors.toList());

    }
    private List<Integer> sortByBinaryOnes(Numbers numbers){

        List<Integer> integers = Arrays.stream(numbers.getIntegers().split(","))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
        integers.sort(new BinaryOnesComparator());
        return integers;
    }


}

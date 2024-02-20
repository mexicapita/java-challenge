package com.intelygenz.service;

import org.springframework.util.StringUtils;

import java.util.Comparator;

public class BinaryOnesComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer int1, Integer int2) {
        String binary1 = Integer.toBinaryString(int1);
        String binary2 = Integer.toBinaryString(int2);
        Integer count1 = StringUtils.countOccurrencesOf(binary1,"1");
        Integer count2 = StringUtils.countOccurrencesOf(binary2,"1");
        if(count1==count2){
            return int1.compareTo(int2);
        }
        else{
            return count2.compareTo(count1);
        }
    }
}

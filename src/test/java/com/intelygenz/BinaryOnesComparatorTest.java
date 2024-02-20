package com.intelygenz;

import com.intelygenz.service.BinaryOnesComparator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BinaryOnesComparatorTest {

    @Test
    void binaryOnesComparatorTest() {
        List<Integer> list  = new ArrayList<>(List.of(1,1,1,1,2000,2000,20000,1,1,0,0,7,7,0));
        list.sort(new BinaryOnesComparator());
        List<Integer> expectedList  = List.of(2000, 2000, 20000, 7, 7, 1, 1, 1, 1, 1, 1, 0, 0, 0);
        assertEquals(expectedList,list);
    }
}

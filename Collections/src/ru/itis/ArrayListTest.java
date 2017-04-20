package ru.itis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 20.04.2017
 * ArrayListTest
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ArrayListTest {

    private ArrayList<Contract> contractArrayList;

    private final Contract CONTRACT = new Contract(1, "Sidikov", "Ypsupov", "02.02.02");
    private final Contract CONTRACT_1 = new Contract(1, "Sidikova", "Ypsupova", "02.02.02");
    private final Contract CONTRACT_2 = new Contract(1, "Sidikovs", "Ypsupovs", "02.02.02");
    @Before
    public void setUp() throws Exception {
        contractArrayList = new ArrayList<>();
        contractArrayList.add(CONTRACT);
        contractArrayList.add(CONTRACT_1);
        contractArrayList.add(CONTRACT_2);
    }

    @Test
    public void indexOfTest() throws Exception {
        int actual = contractArrayList.indexOf(CONTRACT_1);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void getTest() throws Exception {
        Contract actual = contractArrayList.get(2);
        Contract expected = CONTRACT_2;

        assertEquals(expected, actual);
    }

    @Test
    public void addToBeginTest() throws Exception {
        contractArrayList.addToBegin(CONTRACT_2);
        Contract actual = contractArrayList.get(0);
        Contract expected = CONTRACT_2;

        assertEquals(expected, actual);
    }

}
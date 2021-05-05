package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.ReaderService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReaderServiceImplTest {
    private static final String INPUT_FILE_DIRECTION_DEFAULT_TEST
            = "src/test/resources/InputFileTest.csv";
    private static final String INPUT_FILE_DIRECTION_EMPTY_TEST
            = "src/test/resources/InputFileTestEmpty.csv";
    private static final String INPUT_FILE_DIRECTION_NON_EXIST_FILE
            = "src/test/resources/InputFileTestNonExist";
    private static ReaderService readerService;
    private List<String> actual;
    private List<String> expected;

    @BeforeClass
    public static void beforeClass() {
        readerService = new ReaderServiceImpl();
    }

    @Before
    public void before() {
        expected = new ArrayList<>();
    }

    @Test
    public void readDefaultInputData_Ok() {
        expected.add("type,fruit,quantity");
        expected.add("b,banana,20");
        expected.add("b,apple,100");
        expected.add("s,banana,100");
        expected.add("p,banana,13");
        expected.add("r,apple,10");
        expected.add("p,apple,20");
        expected.add("p,banana,5");
        expected.add("s,banana,50");

        actual = readerService.read(INPUT_FILE_DIRECTION_DEFAULT_TEST);
        assertEquals(expected, actual);
    }

    @Test
    public void readEmptyInputData_Ok() {
        actual = readerService.read(INPUT_FILE_DIRECTION_EMPTY_TEST);
        assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void readFromNonExistFile_NotOk() {
        readerService.read(INPUT_FILE_DIRECTION_NON_EXIST_FILE);
    }
}

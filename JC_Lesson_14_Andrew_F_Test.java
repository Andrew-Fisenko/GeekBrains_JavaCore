package gb.ru;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class JC_Lesson_14_Andrew_F_Test {

    @Test
    void testArrayWith0ne4() {
        int[] arrTest = { 1, 5 , 7, 6 ,4 ,5 ,7 };
        int[] arrExpected = { 5 ,7 };
        Assertions.assertArrayEquals(arrExpected, JC_Lesson_14_Andrew_F.returnArrayAfterLastNumber4(arrTest));
    }

    @Test
    void testArrayWithTwo4() {
        int[] arrTest = { 1, 5 , 4, 6 ,4 ,5 ,7 };
        int[] arrExpected = { 5 ,7 };
        Assertions.assertArrayEquals(arrExpected, JC_Lesson_14_Andrew_F.returnArrayAfterLastNumber4(arrTest));
    }

    @Test
    void testArrayWithLast4() {
        int[] arrTest = { 1, 5 , 4, 6 ,4 ,5 ,4 };
        int[] arrExpected = { };
        Assertions.assertArrayEquals(arrExpected, JC_Lesson_14_Andrew_F.returnArrayAfterLastNumber4(arrTest));
    }

    @Test
    void testArrayWithout4() throws RuntimeException{
        int[] arrTest = { 1, 5 , 8, 6 ,9 ,5 ,0};
        Assertions.assertThrows(RuntimeException.class, () -> JC_Lesson_14_Andrew_F.returnArrayAfterLastNumber4(arrTest));
        }


    @Test
    void testArrayOnlyWith1And4() {
        int[] arrTest = { 1, 4 , 4, 1 ,4 ,1 ,4 };
        Assertions.assertTrue(JC_Lesson_14_Andrew_F.checkArrayFor1and4(arrTest));
    }

    @Test
    void testArrayOnlyWith1() {
        int[] arrTest = { 1, 1, 1, 1 ,1 ,1 ,1 };
        Assertions.assertFalse(JC_Lesson_14_Andrew_F.checkArrayFor1and4(arrTest));
    }

    @Test
    void testArrayOnlyWith4() {
        int[] arrTest = { 4, 4, 4, 4 ,4 ,4 ,4 };
        Assertions.assertFalse(JC_Lesson_14_Andrew_F.checkArrayFor1and4(arrTest));
    }

    @Test
    void testArrayWithAllNumbers() {
        int[] arrTest = { 1, 2, 3, 4 ,5 ,6 ,7, 8, 9 ,0};
        Assertions.assertFalse(JC_Lesson_14_Andrew_F.checkArrayFor1and4(arrTest));
    }
}


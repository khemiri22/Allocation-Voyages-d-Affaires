package com.example.demo.Controllers.Utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlFieldsTest {

    @Test
    void verifyEmptyEmptyString() {
        assertTrue(ControlFields.verifyEmpty(""));
    }
    @Test
    void verifyEmptyWithOnlySpaceString() {
        assertTrue(ControlFields.verifyEmpty("              "));
    }

    @Test
    void verifyEmptyWithFilledString() {
        assertFalse(ControlFields.verifyEmpty("hello testing"));
    }

    @Test
    void isoDoubleAlphabetsOnly() {
        assertFalse(ControlFields.isoDouble("double"));
    }
    @Test
    void isoDoubleAlphabetsWithPositiveInteger() {
        assertFalse(ControlFields.isoDouble("193double"));
    }
    @Test
    void isoDoubleAlphabetsWithNegativeInteger() {
        assertFalse(ControlFields.isoDouble("-193double"));
    }
    @Test
    void isoDoubleAlphabetsWithPositiveRealWithPoint() {
        assertFalse(ControlFields.isoDouble("19.5double"));
    }
    @Test
    void isoDoubleAlphabetsWithNegativeRealWithPoint() {
        assertFalse(ControlFields.isoDouble("-19.5double"));
    }

    @Test
    void isoDoubleAlphabetsWithPositiveRealWithVirgule() {
        assertFalse(ControlFields.isoDouble("19,5double"));
    }
    @Test
    void isoDoubleAlphabetsWithNegativeRealWithVirgule() {
        assertFalse(ControlFields.isoDouble("-19,5double"));
    }

    @Test
    void isoDoublePositiveInteger() {
        assertTrue(ControlFields.isoDouble("19"));
    }
    @Test
    void isoDoubleNegativeInteger() {
        assertFalse(ControlFields.isoDouble("-19"));
    }
    @Test
    void isoDoublePositiveRealWithPoint() {
        assertTrue(ControlFields.isoDouble("19.5"));
    }
    @Test
    void isoDoubleNegativeRealWithPoint() {
        assertFalse(ControlFields.isoDouble("-19.5"));
    }

    @Test
    void isoDoublePositiveRealWithVirgule() {
        assertFalse(ControlFields.isoDouble("19,5"));
    }
    @Test
    void isoDoubleNegativeRealWithVirgule() {
        assertFalse(ControlFields.isoDouble("-19,5"));
    }

    @Test
    void calculateAvaSoldWithNullType() {
        assertEquals(0,ControlFields.calculateAvaSold(10.0,null));
    }
    @Test
    void calculateAvaSoldWithNoType() {
        assertEquals(0,ControlFields.calculateAvaSold(10.0,""));
    }
    @Test
    void calculateAvaSoldWithTypeWhereIsNotAOrE() {
        assertEquals(0,ControlFields.calculateAvaSold(10.0,"f"));
    }
    @Test
    void calculateAvaSoldWithAUpperCaseType() {
        assertEquals(2.5,ControlFields.calculateAvaSold(10.0,"A"));
    }
    @Test
    void calculateAvaSoldWithEUpperCaseType() {
        assertEquals(3.5,ControlFields.calculateAvaSold(10.0,"E"));
    }
    @Test
    void calculateAvaSoldWithALowerCaseType() {
        assertEquals(0,ControlFields.calculateAvaSold(10.0,"a"));
    }
    @Test
    void calculateAvaSoldWithELowerCaseType() {
        assertEquals(0,ControlFields.calculateAvaSold(10.0,"e"));
    }
}
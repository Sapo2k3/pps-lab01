package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private final int MAX_ATTEMPTS = 3;
    private final int PIN = 1234;
    private final int WRONG_PIN = 1235;
    private final int WRONG_FORMAT_PIN = 123;

    SmartDoorLock smartDoorLock;

    @BeforeEach
    void setUp() {
        smartDoorLock = new SmartDoorLockImpl(MAX_ATTEMPTS);
        smartDoorLock.setPin(PIN);
    }

    @Test
    public void testIsInitiallyLocked() {
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testLock() {
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void  testUnlock(){
        smartDoorLock.lock();
        smartDoorLock.unlock(PIN);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testWrongFormatPin(){
        SmartDoorLock smartDoorLock = new SmartDoorLockImpl(MAX_ATTEMPTS);
        assertThrows(IllegalArgumentException.class, () -> smartDoorLock.setPin(WRONG_FORMAT_PIN));
    }

    @Test
    public void testWrongPinUnlock(){
        smartDoorLock.lock();
        smartDoorLock.unlock(WRONG_PIN);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void noPinUnlock(){
        SmartDoorLock smartDoorLock = new SmartDoorLockImpl(MAX_ATTEMPTS);
        smartDoorLock.lock();
        assertThrows(IllegalStateException.class, () -> smartDoorLock.unlock(PIN));
    }

    @Test
    public void testFailedAttempts(){
        smartDoorLock.lock();
        smartDoorLock.unlock(WRONG_PIN);
        assertEquals(1, smartDoorLock.getFailedAttempts());
    }

    @Test
    public void testFailedAttemptsAfterUnlock(){
        smartDoorLock.lock();
        smartDoorLock.unlock(WRONG_PIN);
        smartDoorLock.unlock(PIN);
        assertEquals(0, smartDoorLock.getFailedAttempts());
    }

    @Test
    public void testBlockAfterMaxAttempts(){
        smartDoorLock.lock();
        for (int index = 0; index <= smartDoorLock.getMaxAttempts(); index++){
            smartDoorLock.unlock(WRONG_PIN);
        }
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    public void testReset(){
        smartDoorLock.lock();
        smartDoorLock.reset();
        assertFalse(smartDoorLock.isLocked());
        assertFalse(smartDoorLock.isBlocked());
        assertEquals(0, smartDoorLock.getFailedAttempts());
    }
}

package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    @Test
    public void testIsInitiallyLocked() {
        SmartDoorLock smartDoorLock = new SmartDoorLockImpl();
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testLock() {
        SmartDoorLock smartDoorLock = new SmartDoorLockImpl();
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }
}

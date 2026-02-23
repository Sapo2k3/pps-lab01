package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private boolean isLocked = false;

    @Override
    public void setPin(int pin) {

    }

    @Override
    public void unlock(int pin) {

    }

    @Override
    public void lock() {
        this.isLocked = true;
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}

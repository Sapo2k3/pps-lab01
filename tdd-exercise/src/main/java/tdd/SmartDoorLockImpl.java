package tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private boolean isLocked = false;
    private boolean isBlocked = false;
    private int pin = 0;
    private int failedAttempts = 0;
    private int maxAttempts;

    public SmartDoorLockImpl(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if (this.pin == 0) {
            throw new IllegalStateException("No pin has been set");
        }
        if (isBlocked || !isLocked) return;
        if (pin == this.pin) {
            this.isLocked = false;
            this.failedAttempts = 0;
            return;
        }
        this.failedAttempts = this.failedAttempts + 1;
        if (this.failedAttempts >= this.maxAttempts) {
            this.isBlocked = true;
            this.isLocked = true;
        }
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
        return this.isBlocked;
    }

    @Override
    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        this.isLocked = false;
        this.isBlocked = false;
        this.failedAttempts = 0;
        this.pin = 0;
    }
}

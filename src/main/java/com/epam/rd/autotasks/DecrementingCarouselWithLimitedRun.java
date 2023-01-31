package com.epam.rd.autotasks;
public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {
    static int actionLimit;
    private int carouselRunCounter = 0;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit =actionLimit;
    }
    @Override
    public CarouselRun run(){
        if (carouselRunCounter == 0) {
            isRun = true;
            carouselRunCounter++;
            return new DecrementingCarouselWithLimitedCarouselRun();
        }
        return null;
    }
}
class DecrementingCarouselWithLimitedCarouselRun extends CarouselRun {
    int actionLimit = DecrementingCarouselWithLimitedRun.actionLimit;
    boolean flag = false;
    int actions = 0;
    @Override
    public int next() {
        if (isFinished())
            return -1;
        else {
            while (array[position %= array.length] <= 0) {
                position++;
            }
        }
        actions++;
        if (actions == actionLimit) {
            flag = true;
        }
        return array[position++]--;
    }
    @Override
    public boolean isFinished() {
        if (!flag) {
            for (int var : array) {
                if (var > 0) return false;
            }
            return true;
        }
        else {
            return actions == actionLimit;
        }
    }
}

/*public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
    }
    public CarouselRun run(int limit) {
        if (!isRun) {
            isRun = true;
            return new DecrementingCarouselWithLimitedRunRun(limit);
        }
        return null;
    }

    private class DecrementingCarouselWithLimitedRunRun extends CarouselRun {
        private int callsLeft;

        public DecrementingCarouselWithLimitedRunRun(int limit) {
            this.callsLeft = limit;
        }

        @Override
        public int next() {
            if (isFinished() || callsLeft <= 0) {
                return -1;
            }
            callsLeft--;
            int result = array[position++ % array.length];
            array[position % array.length] = Math.max(0, result - 1);
            return result;
        }

        @Override
        public boolean isFinished() {
            return callsLeft <= 0;
        }
    }
}*/

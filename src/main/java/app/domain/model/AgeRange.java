package app.domain.model;

public class AgeRange {
    private final int minAge;
    private final int maxAge;

    public AgeRange(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }


    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }


    public boolean isInRange(int age) {
        return age >= minAge && age <= maxAge;
    }

    @Override
    public String toString() {
        return "AgeRange{" +
                "minAge=" + minAge +
                ", maxAge=" + maxAge +
                '}';
    }
}

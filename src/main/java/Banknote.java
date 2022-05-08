public enum Banknote {
    THOUSAND(1000),
    FIVE_HUNDRED(500),
    ONE_HUNDRED(100);

    public final double value;

    Banknote(double value) {
        this.value = value;
    }
}

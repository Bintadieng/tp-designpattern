// Interface Strategy
public interface TaxStrategy {
    double calculateTax(double amount);
}

// Stratégies concrètes
public class AlbertaTaxStrategy implements TaxStrategy {
    private static final double FEDERAL_TAX = 0.06;

    @Override
    public double calculateTax(double amount) {
        return amount * FEDERAL_TAX;
    }
}

public class OntarioTaxStrategy implements TaxStrategy {
    private static final double FEDERAL_TAX = 0.06;
    private static final double PROVINCIAL_TAX = 0.06;

    @Override
    public double calculateTax(double amount) {
        return amount * FEDERAL_TAX + amount * PROVINCIAL_TAX;
    }
}

public class QuebecTaxStrategy implements TaxStrategy {
    private static final double FEDERAL_TAX = 0.06;
    private static final double PROVINCIAL_TAX = 0.075;

    @Override
    public double calculateTax(double amount) {
        double afterFederal = amount * (1 + FEDERAL_TAX);
        return amount * FEDERAL_TAX + afterFederal * PROVINCIAL_TAX;
    }
}

// Contexte
public class TaxCalculator {
    private TaxStrategy strategy;

    public void setStrategy(TaxStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateTotal(double amount) {
        return amount + strategy.calculateTax(amount);
    }
}
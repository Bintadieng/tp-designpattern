// Interface commune pour toutes les stratégies

import java.util.Vector;

public interface DisplayStrategy {
    void display(Vector<String> data);
}

public class ConsoleDisplayStrategy implements DisplayStrategy {
    public void display(Vector<String> data) {
        for (String item : data) {
            System.out.println(item);
        }
    }

    @Override
    public String toString() {
        return "ConsoleDisplayStrategy []";
    }
}

// Classe Date
public class Date {
    private Vector<String> strings;
    private DisplayStrategy displayStrategy;

    public void setDisplayStrategy(DisplayStrategy strategy) {
        this.displayStrategy = strategy;
    }

    public void show() {
        if (displayStrategy != null) {
            displayStrategy.display(strings);
        }
    }

    public Vector<String> getStrings() {
        return strings;
    }

    public void setStrings(Vector<String> strings) {
        this.strings = strings;
    }

    public DisplayStrategy getDisplayStrategy() {
        return displayStrategy;
    }
}
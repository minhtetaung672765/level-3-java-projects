public class Expense {

    String category;
    double budget;
    public Expense(String category, double budget) {
        this.category = category;
        this.budget = budget;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }


}

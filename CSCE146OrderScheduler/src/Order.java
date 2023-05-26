//Paksh Patel

class Order implements Comparable<Order> {
    private String customer;
    private String foodOrder;
    private int cookingTime;
    private int arrivalTime;
    private int cookingTimeLeft;

    // Constructors
    public Order() {
        this.customer = "none";
        this.foodOrder = "none";
        this.cookingTime = 1;
        this.arrivalTime = 0;
        this.cookingTimeLeft = 1;
    }

    public Order(String customer, String foodOrder, int cookingTime, int arrivalTime) {
        this.customer = customer;
        this.foodOrder = foodOrder;
        if (cookingTime > 0) {
            this.cookingTime = cookingTime;
        } else {
            this.cookingTime = 1;
        }
        if (arrivalTime >= 0) {
            this.arrivalTime = arrivalTime;
        } else {
            this.arrivalTime = 0;
        }
        this.cookingTimeLeft = this.cookingTime;
    }

    // Accessors
    public String getCustomer() {
        return customer;
    }

    public String getFoodOrder() {
        return foodOrder;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getCookingTimeLeft() {
        return cookingTimeLeft;
    }

    // Mutators
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setFoodOrder(String foodOrder) {
        this.foodOrder = foodOrder;
    }

    public void setCookingTime(int cookingTime) {
        if (cookingTime > 0) {
            this.cookingTime = cookingTime;
        }
    }

    public void setArrivalTime(int arrivalTime) {
        if (arrivalTime >= 0) {
            this.arrivalTime = arrivalTime;
        }
    }

    public void setCookingTimeLeft(int cookingTimeLeft) {
        this.cookingTimeLeft = cookingTimeLeft;
    }

    // Other methods
    @Override
    public String toString() {
        return "Customer: " + customer + ", Order: " + foodOrder + ", Cooking Time Left: " + cookingTimeLeft;
    }

    @Override
    public int compareTo(Order o) {
        if (this.cookingTime < o.cookingTime) {
            return -1;
        } else if (this.cookingTime > o.cookingTime) {
            return 1;
        } else {
            return 0;
        }
    }

    public void cookForOneMinute() {
        if (cookingTimeLeft > 0) {
            cookingTimeLeft--;
        }
    }

    public boolean isDone() {
        return cookingTimeLeft == 0;
    }
}
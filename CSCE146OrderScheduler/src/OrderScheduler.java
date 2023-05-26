//Paksh Patel

public class OrderScheduler {
    private MinHeap<Order> orders;
    private Order currentOrder;
    private int currentMinute;
    private int totalOrders;
    private int summedWaitingTimes;

    public OrderScheduler() {
        orders = new MinHeap<>();
        currentOrder = null;
        currentMinute = 0;
        totalOrders = 0;
        summedWaitingTimes = 0;
    }

    public void addOrder(Order order) {
        orders.add(order);
        totalOrders++;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public int getCurrentMinute() {
        return currentMinute;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public int getSummedWaitingTimes() {
        return summedWaitingTimes;
    }

    public void advanceOneMinute() {
        currentMinute++;
        if (currentOrder != null) {
            currentOrder.cookForOneMinute();
            if (currentOrder.isDone()) {
                summedWaitingTimes += currentMinute - currentOrder.getArrivalTime();
                currentOrder = null;
            }
        }
        if (currentOrder == null && !orders.isEmpty()) {
            currentOrder = orders.remove();
        }
    }

    public boolean isDone() {
        return currentOrder == null && orders.isEmpty();
    }

    public int getAverageWaitingTime() {
        if (totalOrders == 0) {
            return 0;
        } else {
            return summedWaitingTimes / totalOrders;
        }
    }
}

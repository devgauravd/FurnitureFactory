package hackerrank;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private HashMap<Furniture, Integer> orders;
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        orders = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        if(Objects.nonNull(orders.get(type))) {
            orders.put(type, (orders.get(type)+furnitureCount));
        } else {
            orders.put(type, furnitureCount);
        }
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return orders;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        AtomicReference<Float> totalOrderCost= new AtomicReference<>(0f);
        orders.entrySet().forEach( ele ->  {
            totalOrderCost.set((ele.getKey().cost() * ele.getValue())+totalOrderCost.get());
        });
        return totalOrderCost.get();
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        if(orders.containsKey(type))
            return orders.get(type);
        return 0;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        if(orders.containsKey(type))
            return orders.get(type) * type.cost();
        return 0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        AtomicReference<Integer> totalOrderQuantity = new AtomicReference<>(0);
        orders.entrySet().forEach( ele ->  {
            totalOrderQuantity.set(totalOrderQuantity.get()+ele.getValue());
        });
        return totalOrderQuantity.get();
    }
}
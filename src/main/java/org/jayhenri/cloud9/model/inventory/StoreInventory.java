package org.jayhenri.cloud9.model.inventory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jayhenri.cloud9.model.item.Item;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * The type Store inventory.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "store_inventory")
public class StoreInventory implements Serializable {

    private static final long serialVersionUID = -1112477284611964207L;

    @Id
    @Column(name = "inventory_id", nullable = false)
    private UUID inventoryUUID = UUID.randomUUID();

    @OneToOne
    @JoinColumn(name = "item_id", nullable = false, unique = true)
    private Item item;

    @Column(name = "item_name", nullable = false, unique = true)
    private String itemName;

    @Column(name = "quantity", nullable = false, unique = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;

    /**
     * Instantiates a new Store inventory.
     *
     * @param item     the item
     * @param itemName the item name
     * @param quantity the quantity
     * @param price    the price
     */
    public StoreInventory(Item item, String itemName, int quantity, double price) {
        this.item = item;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
}

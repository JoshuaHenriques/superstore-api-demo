package org.jayhenri.ecommerce.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * The type Order.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = -3543368529566294417L;

    @Id
    @Column(name = "order_details_id", nullable = false)
    private UUID orderDetailsUUID = UUID.randomUUID();

    @Column(name = "customer_email", nullable = false, length = 50)
    private String customerEmail;

    @Column(name = "item_names", nullable = true, insertable = false, updatable = false)
    private List<String> itemNames;

    @Column(name = "order_status", nullable = false, length = 10)
    private String orderStatus;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    /**
     * Instantiates a new Order details.
     *
     * @param orderStatus   the order status
     * @param customerEmail the customer email
     * @param itemNames      the item list
     * @param totalPrice    the total price
     */
    public OrderDetails(String orderStatus, String customerEmail, List<String> itemNames, double totalPrice) {
        this.customerEmail = customerEmail;
        this.itemNames = itemNames;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
    }
}

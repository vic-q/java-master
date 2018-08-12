package com.java.master.shardingjdbc.entity;

/**
 * @author wangqing 
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 261534701950670670L;

    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "status")
    private String status;

    public long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(final long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(final long orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("order_item_id: %s, order_id: %s, user_id: %s, status: %s", orderItemId, orderId, userId, status);
    }

}

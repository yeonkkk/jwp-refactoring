package kitchenpos.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MenuProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Long quantity;

    protected MenuProduct() {
    }

    public MenuProduct(final Long seq,
                       final Menu menu,
                       final Product product,
                       final Long quantity) {
        this.seq = seq;
        this.menu = menu;
        this.product = product;
        this.quantity = quantity;
    }

    public static MenuProduct of(final Long seq,
                                 final Menu menu,
                                 final Product product,
                                 final long quantity) {
        return new MenuProduct(seq, menu, product, quantity);
    }

    public static MenuProduct of(final Menu menu,
                                 final Product product,
                                 final long quantity) {
        return new MenuProduct(null, menu, product, quantity);
    }

    public static MenuProduct of(final Product product,
                                 final long quantity) {
        return new MenuProduct(null, null, product, quantity);
    }

    public BigDecimal getTotalPrice() {
        return product.multiplyPrice(quantity);
    }

    public Long getSeq() {
        return seq;
    }

    public Long getMenuId() {
        return menu.getId();
    }

    public Long getProductId() {
        return product.getId();
    }

    public long getQuantity() {
        return quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public Product getProduct() {
        return product;
    }
}

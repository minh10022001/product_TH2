package product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Product", //
uniqueConstraints = { //
        @UniqueConstraint(name = "PRODUCT_UK", columnNames = "Code") })
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
	@Column(name = "Code", length = 36, nullable = false)
	private String code;
	private String description;
	private double price;
}

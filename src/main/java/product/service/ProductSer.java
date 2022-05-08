package product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.Product;
import product.data.ProductRepo;


@Service
public class ProductSer {
	@Autowired
	private ProductRepo productRepo;

	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	public List<Product> getProduct() {
		return productRepo.findAll();
	}

	public Product getPByID(long ID) {

		Optional<Product> model = productRepo.findById(ID);

		if (model.isPresent()) {
			return model.get();
		}
		return null;
	}

	public void deletePById(Long ID) {
		productRepo.deleteById(ID);

	}

}

package product.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import product.Product;
import product.service.ProductSer;



@Controller

public class MainController {
	@Autowired
	private ProductSer productSer;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	@PostMapping("/addProduct")
	public String addTeacher(@ModelAttribute Product product,  Model model, HttpSession session) {
		productSer.addProduct(product);

		
		model.addAttribute("newProduct", new Product());
		session.setAttribute("msg", "Product Added Sucessfully...");
		return "redirect:/ShowProduct";
	}
	@GetMapping("/Product")
	public String Student(Model model) {
		model.addAttribute("newProduct", new Product());
		
		return "AddProduct";

	}

	@GetMapping("/ShowProduct")
	public String PHome(Model model) {
		List<Product> product = productSer.getProduct();
		model.addAttribute("product", product);
		return "ShowProduct";
	}

	@GetMapping("/ShowProduct/edit/{ID}")
	public String editP(@PathVariable("ID") long ID, Model m) {
		Product product = productSer.getPByID(ID);
		m.addAttribute("product", product);
		return "ProductEdit";
	}

	@PostMapping("/ShowProduct/edit/UpdateProduct")
	public String UpdateStudent(@ModelAttribute Product product, Model model, HttpSession session) {
		product.setCode(product.getCode());
		productSer.addProduct(product);

		model.addAttribute("newProduct", new Product());

		session.setAttribute("msg", "Product Edited Sucessfully...");
		return "redirect:/ShowProduct";
	}
	@GetMapping("/ShowProduct/delete/{ID}")
	public String deleteP(@PathVariable("ID") long ID, Model m) {
		Product product = productSer.getPByID(ID);
		m.addAttribute("product", product);
		return "ProductDelete";
	}
	@GetMapping("/ShowProduct/delete/DeleteProduct")
	public String DeleteP(@ModelAttribute Product product, Model model, HttpSession session) {
		
		productSer.deletePById(product.getID());

		

		session.setAttribute("msg", "Product deleted Sucessfully...");
		return "redirect:/ShowProduct";
	}
//	@GetMapping("/Studentshow/delete/{ID}")
//	public String deleteStudent(@PathVariable("ID") Long ID, HttpSession session) {
//		Student student = studentSer.getStdByID(ID);
//		AppUser appUser = student.getAppUser();
//		Long idUser = appUser.getUserId();
//		UserRole ul = userRoleSer.findAppRole(appUser);
//
//		userRoleSer.deleteUserRoleByAppUser(ul.getId());
//		studentSer.deleteByStudentId(ID);
//		appUserSer.deleteByAppUserId(idUser);
//		session.setAttribute("msg", "The User ID " + ID + " Deleted Succesfully");
//		return "redirect:/Studentshow";
//	}

}

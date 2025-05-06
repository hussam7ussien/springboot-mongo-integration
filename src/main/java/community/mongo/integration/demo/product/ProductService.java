package community.mongo.integration.demo.product;

import community.mongo.integration.demo.category.Category;
import community.mongo.integration.demo.category.CategoryDTO;
import community.mongo.integration.demo.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public String save(ProductRequestDTO dto){
        // fetch category by ID
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .category(category)
                .build();
        return productRepository.save(product).getId();
    }

    public String edit(String id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCategory(category);

        return productRepository.save(product).getId();
    }

    public ProductRequestDTO findById(String id){
        return productRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    public List<ProductRequestDTO> findAll(){
        return productRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public void delete(String id){
        productRepository.deleteById(id);
    }

    private ProductRequestDTO mapToDTO(Product product){
        Category category = product.getCategory();

        CategoryDTO categoryDTO = category != null
                ? CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build()
                : null;

        return ProductRequestDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .categoryId(category != null ? category.getId() : null)
                .category(categoryDTO)
                .build();
    }

}

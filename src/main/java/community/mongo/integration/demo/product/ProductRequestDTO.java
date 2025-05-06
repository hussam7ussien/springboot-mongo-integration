package community.mongo.integration.demo.product;

import community.mongo.integration.demo.category.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDTO {
    private String name;
    private String description;
    private String categoryId;         // for incoming request
    private CategoryDTO category;      // for response (optional)
}

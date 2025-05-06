package community.mongo.integration.demo.product;

import community.mongo.integration.demo.category.Category;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@AllArgsConstructor
public class Product {
    @Id
    private String id;

    private String name;

    private String description;

    @DBRef
    private Category category;
}

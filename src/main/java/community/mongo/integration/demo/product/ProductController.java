package community.mongo.integration.demo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

   private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ProductRequestDTO request) {
        return ResponseEntity.ok(productService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductRequestDTO>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }


    @GetMapping("/{productId}")
    public ResponseEntity<ProductRequestDTO> findById(@PathVariable("productId") String productId) {
        ProductRequestDTO dto = productService.findById(productId);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable("productId") String productId) {
        productService.delete(productId);
        return ResponseEntity.accepted().build();
    }
}

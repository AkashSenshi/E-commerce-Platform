package com.apnadukaan.productservice.service;

import com.apnadukaan.productservice.ExceptionHandler.Exceptions.ProductNotFoundException;
import com.apnadukaan.productservice.dtos.ProductDtoViaFakeStore;
import com.apnadukaan.productservice.model.Category;
import com.apnadukaan.productservice.model.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("ProductServiceViaFakeStore")
public class ProductServiceViaFakeStore implements ProductService {
    private RestTemplate restTemplate;

    ProductServiceViaFakeStore(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Product product = null;
        ProductDtoViaFakeStore fakeStoreDto = null;
        fakeStoreDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductDtoViaFakeStore.class);
        if (fakeStoreDto == null) {
            throw new ProductNotFoundException(id, "Hello No Product Found");
        }
        product = convertProductDtoViaFakeStoreToProduct(fakeStoreDto);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = null;

//        List<Product> products = restTemplate.getForObject("https://fakestoreapi.com/products",
//                List.class); // will also work
        ProductDtoViaFakeStore[] productArr = restTemplate.getForObject("https://fakestoreapi.com/products",
                ProductDtoViaFakeStore[].class);
                products = Arrays.stream(productArr)
                .map(this::convertProductDtoViaFakeStoreToProduct)
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        Product newProduct = null;
//        public <T> T execute(String uriTemplate, HttpMethod method, @Nullable RequestCallback requestCallback,
//                @Nullable ResponseExtractor<T> responseExtractor, Object... uriVariables) throws RestClientException {
        ProductDtoViaFakeStore productDto = convertProductToProductDtoViaFakeStore(product);
        RequestCallback callback = restTemplate.httpEntityCallback(productDto,ProductDtoViaFakeStore.class);
        HttpMessageConverterExtractor<ProductDtoViaFakeStore> extractor = new HttpMessageConverterExtractor(ProductDtoViaFakeStore.class,restTemplate.getMessageConverters());
        ProductDtoViaFakeStore resonseDto = restTemplate.execute("https://fakestoreapi.com/products/"+product.getId(), HttpMethod.PUT, callback,extractor);

        System.out.println(resonseDto);
        newProduct = convertProductDtoViaFakeStoreToProduct(resonseDto);
        return newProduct;
    }

    @Override
    public Product replaceProduct(Product product) {
        return null;
    }

    @Override
    public void removeProductById(Long id) {

    }

    public Product convertProductDtoViaFakeStoreToProduct(ProductDtoViaFakeStore dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImageUrl(dto.getImage());

        Category category = new Category();
        category.setDescription(dto.getCategory());
        product.setCategory(category);
        return product;
    }

    public ProductDtoViaFakeStore convertProductToProductDtoViaFakeStore(Product product) {
        ProductDtoViaFakeStore dto = new ProductDtoViaFakeStore();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setImage(product.getImageUrl());
        dto.setCategory(product.getCategory().getDescription());
        return dto;
    }
}

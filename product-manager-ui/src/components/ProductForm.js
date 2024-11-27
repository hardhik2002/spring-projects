import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ProductForm = ({ currentProduct, onSave }) => {
    const [product, setProduct] = useState({
        name: '',
        description: '',
        price: '',
    });

    useEffect(() => {
        if (currentProduct) {
            setProduct(currentProduct);
        }
    }, [currentProduct]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setProduct({ ...product, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const apiUrl = currentProduct
            ? `http://localhost:8080/api/products/${currentProduct.id}`
            : 'http://localhost:8080/api/products';

        const method = currentProduct ? axios.put : axios.post;

        method(apiUrl, product)
            .then(() => onSave())
            .catch((error) => console.error('Error saving product:', error));
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>{currentProduct ? 'Edit Product' : 'Add Product'}</h2>
            <input
                type="text"
                name="name"
                placeholder="Name"
                value={product.name}
                onChange={handleChange}
                required
            />
            <input
                type="text"
                name="description"
                placeholder="Description"
                value={product.description}
                onChange={handleChange}
                required
            />
            <input
                type="number"
                name="price"
                placeholder="Price"
                value={product.price}
                onChange={handleChange}
                required
            />
            <button type="submit">Save</button>
        </form>
    );
};

export default ProductForm;

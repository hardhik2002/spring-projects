import React, { useState } from 'react';
import ProductList from './ProductList';
import ProductForm from './ProductForm';
import axios from 'axios';

const ProductManager = () => {
    const [currentProduct, setCurrentProduct] = useState(null);

    const handleEdit = (product) => setCurrentProduct(product);

    const handleDelete = (id) => {
        axios.delete(`http://localhost:8080/api/products/${id}`)
            .then(() => alert('Product deleted successfully'))
            .catch((error) => console.error('Error deleting product:', error));
    };

    const handleSave = () => {
        setCurrentProduct(null);
        window.location.reload(); // Reload to fetch the updated list
    };

    return (
        <div>
            <ProductForm currentProduct={currentProduct} onSave={handleSave} />
            <ProductList onEdit={handleEdit} onDelete={handleDelete} />
        </div>
    );
};

export default ProductManager;

import { useState } from "react";
import { Product } from "src/models/Product";
import {Map} from "immutable"

type ProductId = number;
type Quantity = number;

export const useBasketContainer = () => {
  const [basket, setBasket] = useState<Map<ProductId, Quantity>>(Map());
  
  const addToBasket = (product: Product, quantity: number) => {
    setBasket(basket.set(product.id, quantity));
  }

  const removeFromBasket = (productToRemove: Product) => {
    setBasket(basket.delete(productToRemove.id));
  }

  return {basket, addToBasket, removeFromBasket};
};

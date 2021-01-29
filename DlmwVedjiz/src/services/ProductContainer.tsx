import {useState} from "react";
import Axios from "axios";
import { UserContainer } from ".";
import { Product } from "src/models/Product";

export const useProductContainer = () => {
  const userContainer = UserContainer.useContainer();
  const [products, setProducts] = useState<Product[]>();

  const getProducts = async () => {
    try {
      const res = await Axios.get("api/products", {
        headers: {
          Authorization: "Bearer " + userContainer.token
        }
      });

      setProducts(res.data.data.map((product: Product) => {
        product.pictureUrl = Axios.defaults.baseURL + "storage/pictures/" + product.picture;
        return product
      }));
    } catch (e) {
      console.log(e)
    }
  };

  const getProduct = (id: number) => {
    return products?.find((product: { id: number; }) => product.id == id)
  };

  return {products, getProducts, getProduct}
};

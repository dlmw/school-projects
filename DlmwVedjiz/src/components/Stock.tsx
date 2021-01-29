import { ToastAndroid, View } from "react-native";
import React, { useEffect, useState } from 'react';
import { Product } from "src/models/Product";
import { ProductContainer, UserContainer } from "../services";
import { Button, Image, Text } from "react-native-elements";
import { TextInput } from "react-native-gesture-handler";
import Axios from "axios";

export default function Stock() {

  const productContainer = ProductContainer.useContainer();
  const userContainer = UserContainer.useContainer();
  const [products, setProducts] = useState<Product[]>(productContainer.products as Product[]);

  const [currentIndexOfProduct, setIndex] = useState<number>(0);

  const [productsReviewed, setReviewed] = useState<Product[]>([]);

  const [currentStock, setCurrentStock] = useState<number>(products[currentIndexOfProduct]?.stock);

  const [allStocksReviewed, setAllStocksReviewed] = useState<boolean>(false);

  useEffect(() => {
    if (products.length != 0) {
      setCurrentStock(products[currentIndexOfProduct].stock);
    }
  }, [currentIndexOfProduct]);

  function nextProduct() {
    updateStock(products[currentIndexOfProduct], currentStock);
    setIndex(currentIndexOfProduct === products.length - 1 ? 0 : currentIndexOfProduct + 1);
  }

  function previousProduct() {
    updateStock(products[currentIndexOfProduct], currentStock);
    setIndex(currentIndexOfProduct === 0 ? products.length - 1 : currentIndexOfProduct - 1);
  }

  function updateStock(product: Product, newStock: number) {
    setReviewed(productsReviewed.map(item => 
      item.id === product.id
      ? {...item, stock : newStock}
      : item
    ))
  }

  function confirmStock() {
    updateStock(products[currentIndexOfProduct], currentStock);
    nextProduct();
    removeFromProducts(products[currentIndexOfProduct]);
    if (products.length == 0) {
      setAllStocksReviewed(true);
    }
  }

  function removeFromProducts(product: Product) {
    let copy = [...products];
    let indexOfElementToRemove = copy.indexOf(product);
    if (indexOfElementToRemove !== -1) {
      copy.splice(indexOfElementToRemove, 1);
      setProducts(copy);

      product.stock = currentStock;
      let newReviewedArray = productsReviewed.concat(product);
      setReviewed(newReviewedArray);
    }
  }

  function onReset() {
    setProducts(productContainer.products as Product[]);
  }

  async function onConfirm() {
    await Axios.post("api/products/stock", {
    
      quantities: productsReviewed.map(value => {
        return { // TODO: fonctionne pas (401)
          id: value.id,
          quantity: value.stock
        }
      })
    }, {
      headers: {
        Authorization: "Bearer " + userContainer.token
      }
    })
      .then(function (response: any) {
        ToastAndroid.show("Les quantités ont été enregistrées.", ToastAndroid.LONG);
      })
      .catch(function (error: any) {
        console.log(error);
        ToastAndroid.show("Une erreur s'est produite.", ToastAndroid.SHORT);
      });
  }

  return (
    <View style={{height: "50%"}}>
      {products.length > 0 && <View>
        <Text h3>{products[currentIndexOfProduct]?.name}</Text>
        <Image source={{uri: products[currentIndexOfProduct]?.pictureUrl}} style={{width: "100%", height: "60%"}}/>
        <TextInput keyboardType="decimal-pad" value={currentStock.toString()}
          onChangeText={value => {
              if (!isNaN(Number(value)))
                setCurrentStock(Number(value));
            }
          }
        />
        <Text>{products[currentIndexOfProduct]?.unit}</Text>
        <Button onPress={previousProduct} title="<" />
        <Button onPress={nextProduct} title=">" />
        <Button onPress={confirmStock} title="OK" />
        <Button onPress={onConfirm} title="Enregistrer" />
        <Button onPress={onReset} title="Recommencer" />
      </View>}
      {allStocksReviewed && <View>
        {/* <Text></Text> TODO: Display summary of stocks */}
      </View>
      }
    </View>
  );
}
import { Picker } from '@react-native-community/picker';
import React, { useMemo, useState } from 'react';
import { Button, FlatList, Text, View } from 'react-native';
import {  ListItem } from 'react-native-elements';
import { TextInput } from 'react-native-gesture-handler';
import { Product } from 'src/models/Product';
import { BasketContainer, ProductContainer } from '../services';

export default function Basket() {

  const [selectedProduct, setSelectedProduct] = useState<Product | null>(null);
  const productContainer = ProductContainer.useContainer();
  const basketContainer = BasketContainer.useContainer();

  const basketPrice = useMemo(() => {
    let price = 0;
    basketContainer.basket.forEach(function (quantity, productId) {
      let product = productContainer.getProduct(productId);
      if (product) {
        price += product.price * quantity;
      }
    });
    return Math.round(price * 100) / 100;
  }, [basketContainer.basket])

  const productsFromBasketWithQuantity: (Product & {quantity: number})[] = []

  basketContainer.basket.forEach((quantity, productId) => {
    const product = productContainer.getProduct(productId) as Product;

    productsFromBasketWithQuantity.push({
      ...product,
      quantity
    })
  })

  return (
    <View style={{justifyContent:"space-between", height: "100%"}}>
      <View>
        <Text>The price is {basketPrice}</Text>
        <Picker
          onValueChange={(item) => setSelectedProduct(productContainer.products?.find(product => product.id == item) || null)}
          selectedValue={selectedProduct?.id}>
          
          <Picker.Item value={-1} label ={"Select a product"}/>
          {
            productContainer.products?.map(product => <Picker.Item key={product.id} value={product.id} label={product.name}/>)
          }
        </Picker>
      </View>

      <FlatList
        data={productsFromBasketWithQuantity}
        keyExtractor={((item => String(item.id)))}
        renderItem={({item}) => 
          <View>
            <ListItem
              leftAvatar={{
                source: {
                  uri: item.pictureUrl
                }
              }}
              title={item.name}
              subtitle={`CHF ${item.price}/${item.unit}, Stock: ${item.stock}`}
              onPress={() => {
                basketContainer.removeFromBasket(item);
              }}
              bottomDivider
              chevron
            />
            <TextInput keyboardType="numeric" value={item.quantity.toString()} onChangeText={value => {
              if (!isNaN(Number(value)))
                basketContainer.addToBasket(item, Number(value))}
              }
            />
          </View>
        }
      />
        
      
    <Button
      title="Add to basket"
      onPress={(value) => {
        if (selectedProduct) {
          basketContainer.addToBasket(selectedProduct, 1);
        }
      }}
      disabled={selectedProduct == null}
    />
    </View>
  );
}

import React, {useEffect, useState} from "react";
import { View, FlatList, Text, Image } from 'react-native';
import { ProductContainer } from '../services';
import { ListItem } from "react-native-elements";
import { useNavigation } from "@react-navigation/native";

export default function ProductList() {

  const productContainer = ProductContainer.useContainer();

  const navigation = useNavigation();

  const [isLoading, setIsLoading] = useState<boolean>(false);

  useEffect(() => {
      loadProducts();
  }, []);

  const loadProducts = async () => {
    try {
      setIsLoading(true);

      await productContainer.getProducts()
    } catch (e) {
      console.log(e)
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <View>
      <FlatList
        data={productContainer.products} 
        keyExtractor={(item, index) => index.toString()}
        renderItem={({item}) => 
          <ListItem
            leftAvatar={{
              source: {
                uri: item.pictureUrl
              }
            }}
            title={item.name}
            subtitle={`CHF ${item.price}/${item.unit}, Stock: ${item.stock}`}
            onPress={() => {
              navigation.navigate('Detail', {product: item})
            }}
            bottomDivider
            chevron
          />
        }
        style={{height: "100%"}}
        onRefresh={loadProducts}
        refreshing={isLoading}
      />
    </View>
  );
}
import {Image, StyleSheet, View} from "react-native";
import {useNavigation, useRoute} from "@react-navigation/native";
import {Text} from "react-native-elements";
import React, {Fragment} from "react";
import { Supplier } from "src/models/Product";


export default function Product() {

    const route = useRoute();
    const {product} = route.params as any;

    const navigation = useNavigation();

    if (product == null) {
        navigation.goBack();
        return (<Fragment/>)
    }

    return (
      <View>
        <Image source={{uri: product.pictureUrl}} style={{width: "100%", height: "60%"}}/>
        <View style={styles.wrapper}>
          <Text h3>{product.name}</Text>
          <Text>{product.details}</Text>
          <Text h4>Fournisseur</Text>
          {
              product.suppliers.map((sup: Supplier, id: number) => {
                  return (
                      <Text key={id}>{sup.company_name}</Text>
                  )
              })
          }
        </View>
      </View>
    );
}

const styles = StyleSheet.create({
  wrapper: {
      margin: 10,
  }
});

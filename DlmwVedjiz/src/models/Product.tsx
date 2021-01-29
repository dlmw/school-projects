export interface Product {
  id: number;
  name: string;
  picture: string;
  pictureUrl: string;
  current: number;
  details: string;
  price: number;
  stock: number;
  suppliers: Supplier[];
  unit: string;
  created_at: string;
  updated_at: string;
}

export interface Supplier {
  company_name: string;
  city: string;
  pivot: any[];
}
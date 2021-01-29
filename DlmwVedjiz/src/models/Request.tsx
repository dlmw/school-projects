import { User } from "./User";

export interface LoginRequest {
  token: string;
}

export interface LoginResponse {
  data: User
}

export interface RegisterRequest {
  firstname: string;
  lastname: string;
  phonenumber: string;
}

export interface GetUserInfoResponse {
  data: {
    data: User;
  }
}
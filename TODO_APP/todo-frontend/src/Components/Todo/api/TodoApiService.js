import axios from "axios";

import { apiClient } from "./ApiClient";

export const retriveAllTodosForUsername = (username) =>
  apiClient.get(`/users/${username}/todos`);

export const deleteATodo = (username, id) =>
  apiClient.delete(`/users/${username}/todos/${id}`);

export const getATodo = (username, id) =>
  apiClient.get(`/users/${username}/todos/${id}`);

export const updateTodoApi = (username, id, todo) =>
  apiClient.put(`/users/${username}/todos/${id}`, todo);

export const createTodoApi = (username, todo) =>
  apiClient.post(`/users/${username}/todos`, todo);

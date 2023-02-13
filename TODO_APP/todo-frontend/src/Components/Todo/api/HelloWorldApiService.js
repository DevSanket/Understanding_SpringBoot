import axios from "axios";

import { apiClient } from "./ApiClient";

export const retriveHelloWorldBean = () => apiClient.get(`/hello-world-bean`);

export const retriveHelloWorldPathVariable = (username, token) =>
  apiClient.get(`/hello-world/path-variable/${username}`, {
    headers: {
      Authorization: token,
    },
  });

export const executeBasicAuthenticationService = (token) =>
  apiClient.get(`/basicauth`, {
    headers: {
      Authorization: token,
    },
  });

import axios from "axios";

// export function retriveHelloWorldBean() {
//   return axios.get(`http://localhost:8080/hello-world-bean`);
// }

const apiClient = axios.create({
  baseURL: "http://localhost:8080",
});

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

import { Link, useParams } from "react-router-dom";
import { useState } from "react";
import { retriveHelloWorldPathVariable } from "./api/HelloWorldApiService";
import { useAuth } from "./security/AuthContext";

export default function WelcomeComponent({}) {
  const { username } = useParams();
  const [message, setMessage] = useState(null);
  const context = useAuth();
  const { token } = context;
  //   console.log(params.username);
  const callHelloWorldApi = async () => {
    await retriveHelloWorldPathVariable(username, token)
      .then((res) => successFullResponse(res.data.message))
      .catch((err) => errorResponse(err));
  };

  function successFullResponse(message) {
    setMessage(message);
  }

  function errorResponse(error) {
    console.log(error);
  }

  return (
    <div className="Welcome">
      <h1>Welcome {username}</h1>
      <div>
        Manage Your todos. <Link to="/todos">Go here</Link>
      </div>
      <div>
        <button className="btn btn-success m-5" onClick={callHelloWorldApi}>
          Call Hello World
        </button>
      </div>
      <div className="text-info">{message}</div>
    </div>
  );
}

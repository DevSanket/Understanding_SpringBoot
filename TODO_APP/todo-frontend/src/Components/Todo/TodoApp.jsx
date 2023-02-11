import React, { useState } from "react";
import "./TodoApp.css";
import {
  BrowserRouter,
  Route,
  Routes,
  useNavigate,
  useParams,
} from "react-router-dom";

export default function TodoApp() {
  return (
    <div className="TodoApp">
      ``
      <HeaderComponent />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginComponent />} />
          <Route path="/login" element={<LoginComponent />} />
          <Route path="/welcome/:username" element={<WelcomeComponent />} />
          <Route path="/todos" element={<ListTodosComponent />} />
          <Route path="/logout" element={<LogoutComponent />} />
          <Route path="*" element={<ErroComponent />} />
        </Routes>
      </BrowserRouter>
      <FooterComponent />
    </div>
  );
}

function LoginComponent() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [successMsg, setSuccessMsg] = useState(false);
  const [errorMsg, setErrorMsg] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = () => {
    if (username === "admin" && password === "root") {
      setSuccessMsg(true);
      navigate(`/welcome/${username}`);
    } else {
      setErrorMsg(true);
    }
  };

  return (
    <div className="Login">
      <h1>Time to Login</h1>
      {successMsg && (
        <div className="successMessage">Authenticated successfully</div>
      )}
      {errorMsg && <div className="errorMessage">Invalid Credentials</div>}
      <div className="LoginForm">
        <div>
          <label>User Name</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </div>
        <div>
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        <div>
          <button type="button" name="login" onClick={handleSubmit}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}

function WelcomeComponent({}) {
  const { username } = useParams();
  //   console.log(params.username);
  return (
    <div className="Welcome">
      <h1>Welcome {username}</h1>
      <div>
        Manage Your todos. <a href="/todos">Go here</a>
      </div>
    </div>
  );
}

function ErroComponent() {
  return (
    <div className="ErrorComponent">
      <h1>We are working really hard!</h1>
      <div>Apologies for 404.</div>
    </div>
  );
}

function ListTodosComponent() {
  const today = new Date();
  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay()
  );
  const todos = [
    {
      id: 1,
      description: "Learn AWS",
      done: false,
      targetDate,
    },
    {
      id: 2,
      description: "learn devops",
      done: false,
      targetDate,
    },
    {
      id: 3,
      description: "learn azure",
      done: false,
      targetDate,
    },
  ];
  return (
    <div className="ListTodosComponent">
      <h1>Things You want To Do!</h1>
      <div>
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Description</th>
              <th>Is Done?</th>
              <th>Target Date</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.id}</td>
                <td>{todo.description}</td>
                <td>{todo.done}</td>
                <td>{todo.targetDate.toDateString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

function HeaderComponent() {
  return (
    <div className="header">
      Header <hr />
    </div>
  );
}

function FooterComponent() {
  return (
    <div className="footer">
      <hr /> Footer
    </div>
  );
}

function LogoutComponent() {
  return (
    <div className="logout">
      <h1>You are logged out!</h1>
      <div>Thank You for using out App. Come back soon!</div>
    </div>
  );
}

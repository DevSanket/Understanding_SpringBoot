import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function LoginComponent() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [successMsg, setSuccessMsg] = useState(false);
  const [errorMsg, setErrorMsg] = useState(false);
  const navigate = useNavigate();

  const authcontext = useAuth();

  const handleSubmit = async () => {
    if (await authcontext.login(username, password)) {
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

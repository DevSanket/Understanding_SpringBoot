import { Link } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function HeaderComponent() {
  const authcontext = useAuth();
  const { isAuthenticated } = authcontext;
  console.log(isAuthenticated);
  // console.log(authcontext.number);

  function logout() {
    authcontext.logout();
  }

  return (
    <header className="border-bottom border-light border-5 mb-5 p-2">
      <div className="container">
        <div className="row">
          <nav className="navbar navbar-expand-lg">
            <a className="nav-link" href="https://www.in28minutes.com">
              in28minutes
            </a>
            <div className="collapse navbar-collapse">
              <ul className="navbar-nav">
                {isAuthenticated && (
                  <li className="nav-item">
                    <Link className="nav-link" to="/welcome/admin">
                      Home
                    </Link>
                  </li>
                )}
                {isAuthenticated && (
                  <li className="nav-item">
                    <Link className="nav-link" to="/todos">
                      Todos
                    </Link>
                  </li>
                )}
              </ul>
            </div>
            <ul className="navbar-nav">
              {isAuthenticated && (
                <li className="nav-item">
                  <Link className="nav-link" to="/logout" onClick={logout}>
                    Logout
                  </Link>
                </li>
              )}
              {!isAuthenticated && (
                <li className="nav-item">
                  <Link className="nav-link" to="/login">
                    Login
                  </Link>
                </li>
              )}
            </ul>
          </nav>
        </div>
      </div>
    </header>
  );
}

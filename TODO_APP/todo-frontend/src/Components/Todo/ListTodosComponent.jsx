import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { deleteATodo, retriveAllTodosForUsername } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";

export default function ListTodosComponent() {
  const navigate = useNavigate();

  const [todos, setTodos] = useState([]);
  const [message, setMessage] = useState(null);
  const authcontext = useAuth();
  const { username } = authcontext;

  const getTheData = async () => {
    await retriveAllTodosForUsername(username)
      .then((res) => {
        setTodos(res.data);
      })
      .catch((err) => console.log(err));
  };

  const deleteTodo = async (id) => {
    await deleteATodo(username, id);
    setMessage("Delete Todo Successfull");
    getTheData();
  };

  const updateTodo = async (id) => {
    console.log("Updating " + id);
    navigate(`/todos/${id}`);
  };

  useEffect(() => {
    getTheData();
  }, []);

  function AddNewTodo() {
    navigate(`/todos/-1`);
  }

  return (
    <div className="container">
      <h1>Things You want To Do!</h1>
      {message && <div className="alert alert-warning">{message}</div>}
      <div>
        <table className="table">
          <thead>
            <tr>
              <th>Description</th>
              <th>Is Done?</th>
              <th>Target Date</th>
              <th>Delete</th>
              <th>Update</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.description}</td>
                <td>{String(todo.done)}</td>
                <td>{todo.targetDate}</td>
                <td>
                  <button
                    className="btn btn-danger"
                    onClick={() => deleteTodo(todo.id)}
                  >
                    Delete
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-success"
                    onClick={() => updateTodo(todo.id)}
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <button className="btn btn-success mt-5" onClick={AddNewTodo}>
        Add New Todo
      </button>
    </div>
  );
}

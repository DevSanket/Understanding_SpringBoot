import { ErrorMessage, Field, Form, Formik } from "formik";
import moment from "moment";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { createTodoApi, getATodo, updateTodoApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";

export default function TodoComponent() {
  const [description, setDescription] = useState("");
  const [targetDate, setTargetDate] = useState("");

  const { id } = useParams();
  const authcontext = useAuth();
  const { username } = authcontext;
  const navigate = useNavigate();

  function retriveTodo() {
    if (id !== -1) {
      getATodo(username, id)
        .then((res) => {
          setDescription(res.data.description);
          setTargetDate(res.data.targetDate);
        })
        .catch((err) => console.log(err));
    }
  }

  useEffect(() => {
    retriveTodo();
  }, []);

  const onSubmit = async (values) => {
    const { description, targetDate } = values;
    const todo = {
      id,
      username,
      description: description,
      targetDate: targetDate,
      done: false,
    };

    if (id == -1) {
      await createTodoApi(username, todo).then((res) => {
        console.log(res.data);
      });
    } else {
      await updateTodoApi(username, id, todo)
        .then((res) => {
          console.log(res);
        })
        .catch((err) => console.log(err));
    }

    navigate(`/todos`);
  };

  const validate = (values) => {
    let errors = {
      // description: "Enter a valid description",
      // targetDate: "Enter a valid Target date",
    };

    if (values.description.length < 5 || values.description === "") {
      errors.description = "Enter at least 5 Characters";
    }

    if (
      values.targetDate == null ||
      values.targetDate === "" ||
      !moment(values.targetDate).isValid()
    ) {
      errors.targetDate = "Enter a date";
    }

    return errors;
  };

  return (
    <div className="container">
      <h1>Enter Todo Details</h1>
      <div>
        <Formik
          initialValues={{
            description,
            targetDate,
          }}
          enableReinitialize={true}
          onSubmit={onSubmit}
          validate={validate}
          validateOnChange={false}
          validateOnBlur={false}
        >
          {(props) => (
            <Form>
              <ErrorMessage
                name="description"
                component="div"
                className="alert alert-warning"
              />
              <ErrorMessage
                name="targetDate"
                component="div"
                className="alert alert-warning"
              />
              <fieldset className="form-group">
                <label>Description</label>
                <Field
                  type="text"
                  className="form-control"
                  name="description"
                />
              </fieldset>
              <fieldset className="form-group">
                <label>Target Date</label>
                <Field type="date" className="form-control" name="targetDate" />
              </fieldset>
              <div>
                <button className="btn btn-success mt-5" type="submit">
                  Save
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}

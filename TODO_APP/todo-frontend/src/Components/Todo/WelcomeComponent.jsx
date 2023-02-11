import { Link, useParams } from "react-router-dom";

export default function WelcomeComponent({}) {
  const { username } = useParams();
  //   console.log(params.username);
  return (
    <div className="Welcome">
      <h1>Welcome {username}</h1>
      <div>
        Manage Your todos. <Link href="/todos">Go here</Link>
      </div>
    </div>
  );
}

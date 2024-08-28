import { NavLink, useNavigate } from "react-router-dom";

export default function NavBar() {
  const navigete = useNavigate();

  const handleLoginClick = () => {
    navigete("/login");
  };

  return(
    <>
      {/* 로고 */}
      <NavLink to="/">
        DevSquard
      </NavLink>

      <div>
        <NavLink to="/project">Project</NavLink>
        <NavLink to="/project">Lounge</NavLink>
        <NavLink to="/project">MyPage</NavLink>

        <div onClick={handleLoginClick}>
          Login
        </div>
      </div>
    </>
  );
};
